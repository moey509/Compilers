#include "cubex_main.h"
#include "cubex_external_functions.h"

#define NULL 0

typedef struct blah* blah_t;
typedef struct git * git_t;
typedef struct nit * nit_t;
typedef struct iterator * iterator_t;
typedef struct Iterable * Iterable_t;
typedef struct General * General_t;
typedef struct Integer * Integer_t;
typedef struct Character * Character_t;
typedef struct Boolean * Boolean_t;
typedef void* (*functionPointer)();


struct General {
  int ref_count;
  char** fun_names;
  int fun_length;
  functionPointer* fun_ptrs;
  General_t con_comp;
  int is_iter;
  int is_thru_ward;
};

struct Character {
  int ref_count;
  char** fun_names;
  int fun_length;
  functionPointer* fun_ptrs;
  General_t con_comp;
  int is_iter;
  int is_thru_ward;
  char value;
};

struct Integer {
  int ref_count;
  char** fun_names;
  int fun_length;
  functionPointer* fun_ptrs;
  General_t con_comp;
  int is_iter;
  int is_thru_ward;
  int value;
};

struct Boolean {
  int ref_count;
  char** fun_names;
  int fun_length;
  functionPointer* fun_ptrs;
  General_t con_comp;
  int is_iter;
  int is_thru_ward;
  int value;
};

/* empty iterables are going to be NULL */
struct git 
{
  int ref_count;
  char** fun_names;
  int fun_length;
  functionPointer* fun_ptrs;
  General_t con_comp;
  int is_iter;
  int is_thru_ward;
  void* val;
  git_t next;
  int is_int;
  git_t storage;
  int is_input;
  int is_input_head;
  int dummy;
};

struct iterator
{
  int ref_count;
  char** fun_names;
  int fun_length;
  functionPointer* fun_ptrs;
  General_t con_comp;
  int is_iter;
  int is_thru_ward;
  git_t g;  
  int cur;
  int set;
};


/* status:{0 : through} {1 : onwards}
 for the case of a single number, the value will be held in the field 'low' */
struct nit 
{
  int ref_count;
  char** fun_names;
  int fun_length;
  functionPointer* fun_ptrs;
  void* con_comp;
  int is_iter;
  int is_thru_ward;
  int low;
  int high;
  int status;
};

nit_t new_nit() {
  nit_t n = (nit_t) x3malloc(sizeof(struct nit));
  n->ref_count = 0;
  n->fun_names = NULL;
  n->fun_length = 0;
  n->fun_ptrs = NULL;
  n->con_comp = NULL;
  n->is_iter = 0;
  n->is_thru_ward = 0;
}

Character_t new_character(int input) {
  printf ("NEW char\n");
  Character_t c = (Character_t)x3malloc(sizeof(struct Character));
  c->ref_count = 0;
  c->fun_names = NULL;
  c->fun_length = 0;
  c->fun_ptrs = NULL;
  c->con_comp = NULL; 
  c->is_iter = 0;
  c->is_thru_ward = 0;
  c->value = unichar(input); /* will get replaced by included function */
  return c;
}

Integer_t new_integer(int input) {
  Integer_t i = (Integer_t)x3malloc(sizeof(struct Integer));
  i->ref_count = 0;
  i->fun_names = NULL;
  i->fun_length = 0;
  i->fun_ptrs = NULL;
  i->con_comp = NULL; 
  i->is_iter = 0;
  i->is_thru_ward = 0;
  i->value = input;
  return i;
}

Boolean_t new_boolean(int input) {
  Boolean_t b = (Boolean_t)x3malloc(sizeof(struct Boolean));
  b->ref_count = 0;
  b->fun_names = NULL;
  b->fun_length = 0;
  b->fun_ptrs = NULL;
  b->con_comp = NULL;
  b->is_iter = 0;
  b->is_thru_ward = 0;
  b->value = input;
  return b;
}

/* function look up: given a class struct and the name of a function
 *     , will return a function pointer to the appropriate function */
functionPointer function_lookup (General_t gen, char * function_name    ) {
  int error;
  int length;
  int temp;
  char** arr;
  functionPointer * pointers;
  int i;
  int counter;
  int eof;
  char* name;
  char c1;
  char c2;
  /* error checking... */
  if (gen == NULL) {
    error = 1;
    return NULL;
  }
  if (function_name == NULL) {
    error = 2;
    return NULL;
  }
  
  length = gen->fun_length;
  arr = gen->fun_names;
  /*printf ("length: %d\n", length); */
  for (i = 0; i < length; i++) {
    /*printf ("name: %s\n", arr[i]); */
    eof = 1;
    counter = 0;
    name = arr[i];
    while (eof == 1) {
      c1 = function_name[counter];
      c2 = name[counter];
      if (c1 != c2) {
        eof = 0;
      }
      else if (c1 == '\0') {
        /* found the name */
        pointers = gen->fun_ptrs;
        return pointers[i];
      }
      else {
        counter += 1;
      }
    }
  }
  /* not found in this level */
  return function_lookup (gen->con_comp, function_name);
}

/*returns whether there is another element left */
int hasNext(iterator_t it) {
  git_t g;
  nit_t n;
  if (it == NULL || it->g == NULL) {
    return 0;  
  }

  /* through and onward cases */
  g = it->g;
  if (g->is_int == 1) {
    n = g->val;
    /* set cur value if not set yet */
    if (it->set == 0) {
      it->cur = n->low;
      it->set = 1;
    }
    /*  through case */
    if (n->status == 0) {
      if (it->cur > n->high) {
        it->g = g->next;
        it->set = 0;
        return hasNext(it);
      }
      return 1;
    }
    /* infinite case */
    else {
      return 1;
    }
  }
  /* regular case */
  else {
    return 1;
  }
}

/* returns a pointer to the next elements */
void* getNext(iterator_t it) {
  void * temp;
  int int_temp;
  Integer_t integer;
  git_t g;
  nit_t n;
  if (it == NULL || it->g == NULL) {
    return NULL;
  }
  g = it->g;

  /* onward and through cases */
  if (g->is_int == 1) {
    n = g->val;
    /* set cur value if not set yet */
    if (it->set == 0) {
      it->cur = n->low;
      it->set = 1;
    }
    /* through case */
    if (n->status == 0) {
      /* case with no data */
      if (it->cur > n->high) {
        it->g = g->next;
        it->set = 0;
        return getNext(it);
      }
      int_temp = it->cur;
      /* increment value */
      it->cur += 1;
      if ((int)(it->cur) > (int)(n->high)) {
        it->g = g->next;
        it->set = 0;        
      }
    }
    /* infinite case */
    else {
      int_temp = it->cur;
      it->cur += 1;
    }
    integer = new_integer(int_temp);
    integer->is_thru_ward = 1;
    return integer;
  }
  /* regular case */
  else {
    temp = g->val;
    it->g = g->next;
    it->set = 0;
    return temp;
  }
}

/* constructs a new iterable for anything but ints */
git_t new_git_obj(void* obj) {
  if(obj == NULL)return NULL;
  printf ("NEW git\n");
  git_t g = (git_t)x3malloc(sizeof(struct git));

  g->ref_count = 0;
  g->fun_names = NULL;
  g->fun_length = 0;
  g->fun_ptrs = NULL;
  g->con_comp = NULL;
  g->is_iter = 1;
  g->is_thru_ward = 0;

  g->val = obj;
  g->is_int = 0;
  g->dummy = 0;
  g->next = NULL;

  g->storage = NULL;
  g->is_input = 0;
  return g;
}

/* combines two iterables, */
git_t iterable_append (git_t first, git_t second) {
  git_t g;
  git_t temp;
  git_t itr;
  git_t prev = NULL;
  g = NULL;

  /* regular cases */
  /* first */
  itr = first;
  while (itr != NULL) {
    /*temp = (git_t)x3malloc(sizeof (struct git));*/
    temp = new_git_obj(itr->val);
    /*temp->ref_count = 0;
  temp->fun_names = NULL;
  temp->fun_length = 0;
  temp->fun_ptrs = NULL;
  temp->con_comp = NULL;
  temp->is_iter = 1;
  temp->is_thru_ward = 0;

  temp->val = itr->val;
  temp->is_int = 0;
  temp->dummy = 0;
  temp->next = NULL;

  temp->storage = NULL;
  temp->is_input = 0;
*/
    temp->val = itr->val;
    /*ref_increment(temp->val); */
    temp->is_int = itr->is_int;
    temp->next = NULL;

    temp->is_input = itr->is_input;
    temp->is_input_head = itr->is_input_head;
    temp->storage = itr->storage;

    itr = itr->next;  
    /* update pointers */
    if (prev != NULL){ 
      prev->next = temp;
      prev = temp;
    }
    if (prev == NULL)
      prev = temp;
    if (g == NULL)
      g = temp;
  }
  /* second */
  itr = second;
  while (itr != NULL) {
    /* temp = (git_t)x3malloc(sizeof (struct git)); */
    temp = new_git_obj(itr->val);
    temp->val = itr->val;
    /*ref_increment(temp->val); */
    temp->is_int = itr->is_int;
    temp->next = NULL;

		temp->is_input = itr->is_input;
		temp->is_input_head = itr->is_input_head;
    temp->storage = itr->storage;

    itr = itr->next;  
    /* update pointers */
    if (prev != NULL) { 
      prev->next = temp;
      prev = temp;
    }
    if (prev == NULL) 
      prev = temp;
    if (g == NULL)
      g = temp;
  }

  return g;
}

/* constructs a new iterable for ints. The status, low and high inputs
// correspond to the values in a nit_T struct */
git_t new_git_int (int status, int low, int high) {  
  printf ("NEW git\n");
  git_t g = (git_t)x3malloc(sizeof(struct git));
  nit_t n = new_nit();

	g->ref_count = 0;
  g->fun_names = NULL;
  g->fun_length = 0;
  g->fun_ptrs = NULL;
  g->con_comp = NULL;
  g->is_iter = 1;
  g->is_thru_ward = 0;

  n->status = status;
  n->low = low;
  n->high = high;
  g->val = n;
  g->is_int = 1;
  g->next = NULL;
  g->dummy = 0;

  g->storage = NULL;
  g->is_input = 0;
  return g;
}

iterator_t new_iterator (git_t g) {
  printf ("NEW iterator\n");
  iterator_t it = (iterator_t) x3malloc(sizeof(struct iterator));

  it->ref_count = 0;
  it->fun_names = NULL;
  it->fun_length = 0;
  it->fun_ptrs = NULL;
  it->con_comp = NULL;
  it->is_iter = 0;
  it->is_thru_ward = 0;

  it->g = g;
  it->cur = 0;
  it->set = 0;
  return it;
}

void decrement_iterable(git_t g) {
  git_t itr;
  git_t temp;
  itr = g;
  while (itr != NULL) {
    printf ("decrementing itr from: %d to %d\n", itr->ref_count, itr->ref_count - 1);
    ref_decrement (itr->val);
    temp = itr;
    itr = itr->next;
    temp->ref_count -= 1;
    if (temp->ref_count <= 0) {  
      printf ("freeing!\n");
      if (temp->fun_length > 0) {
        (function_lookup (g, "__kill"))();
      }
      if (temp->fun_names != NULL) {        
        x3free(temp->fun_names);  
      }
      if (temp->fun_ptrs != NULL) {      
        x3free(temp->fun_ptrs);  
      }
      if (temp->con_comp != NULL) {        
        x3free(temp->con_comp);  
      }          
      x3free(temp);
    }
  }
}
void decrement_iterable_no_free(git_t g) {
  git_t itr;
  git_t temp;
  itr = g;
  while (itr != NULL) {
    printf ("decrementing itr from: %d to %d\n", itr->ref_count, itr->ref_count - 1);
    ref_decrement_no_free (itr->val);
    temp = itr;
    itr = itr->next;
    temp->ref_count -= 1;
  }
}

void increment_iterable(git_t g) {
  git_t itr;
  git_t temp;
  itr = g;
  /*printf ("INC\n"); */
  while (itr != NULL) {
    printf ("incrementing itr from: %d to %d\n", itr->ref_count, itr->ref_count + 1);
    ref_increment (itr->val);
    itr->ref_count += 1;
    /*ref_increment (itr);*/
    itr = itr->next;
  }
}

void ref_decrement(General_t gen) {
  if (gen == NULL) 
    return;
  if (gen->is_iter) {
    decrement_iterable (gen);
    return;
  }
  printf ("decrementing reg from: %d to %d\n", gen->ref_count, gen->ref_count - 1);
  gen->ref_count -= 1;
  if (gen->ref_count <= 0) {
    printf ("freeing!\n");
    if (gen->fun_length > 0) {
      (function_lookup (gen, "__kill"))();
    }
    if (gen->fun_names != NULL) {        
      x3free(gen->fun_names);  
    }
    if (gen->fun_ptrs != NULL) {      
      x3free(gen->fun_ptrs);  
    }
    if (gen->con_comp != NULL) {        
      x3free(gen->con_comp);  
    }          
    
    x3free(gen);
  }
  return;
}
void ref_decrement_no_free(General_t gen) {
  if (gen == NULL) 
    return;
  if (gen->is_iter) {
    decrement_iterable_no_free (gen);
    return;
  }
  printf ("decrementing reg from: %d to %d\n", gen->ref_count, gen->ref_count - 1);
  gen->ref_count -= 1;
  return;
}

void ref_increment(General_t gen) {
  if (gen == NULL)
    return;
  if (gen->is_iter) {
    increment_iterable (gen);
    return;
  }
  printf ("incrementing reg from: %d to %d\n", gen->ref_count, gen->ref_count + 1);
  gen->ref_count += 1;
}


void for_v_free(General_t gen) {
  if (gen == NULL)
    return;
  if (gen->is_thru_ward == 1) {
    ref_decrement (gen);
  }
}

int stringLength(git_t g) {
  git_t itr;
  int counter;
  if (g == NULL) 
    return 0;
  itr = g;
  counter = 0;
  while (itr != NULL) {
    counter += 1;
    itr = itr->next;
  }
  return counter;
}

/* convert a char iterable into a String */
char* charToString(git_t g) {
  /*printf ("QWERTY\n");*/
  git_t itr;
  int counter;
  char* buf;
  if (g == NULL) 
    return NULL;
  itr = g;
  counter = 0;
  while (itr != NULL) {
    counter += 1;
    itr = itr->next;
  }
  /*printf ("NEW string\n"); */
  buf = (char*) x3malloc (sizeof(char*) * (counter + 1));
  itr = g;
  counter = 0;
  while (itr != NULL) {
    buf[counter] = ((Character_t)(itr->val))->value;
    counter += 1;
    itr=itr->next;
  }
  buf[counter] = '\0';
  return buf;
}

git_t stringToIterableHelper(char* buf, int offset) {
  Character_t c;
  git_t g;
  git_t temp;
  if (buf[offset] == '\0') {
    return NULL;
  }
  c = new_character((int)(buf[offset]));
  g = new_git_obj(c);
  g->next = stringToIterableHelper(buf, offset+1);
  return g;
  /*(return iterable_append(g, stringToIterableHelper(buf, offset+1)); */
}

git_t stringToIterable(char* buf) {
  if (buf == NULL)
    return NULL;
  return stringToIterableHelper(buf, 0);
}




/* FUNCTIONS */

/* the following two are given to us */

Integer_t Integer_plus (Integer_t i1, Integer_t i2) {
  return new_integer(i1->value + i2->value);
}

Integer_t Integer_subtract (Integer_t i1, Integer_t i2) {
  return new_integer(i1->value - i2->value);
}

Integer_t Integer_times (Integer_t i1, Integer_t i2) {
  return new_integer(i1->value * i2->value);
}

git_t Integer_divide (Integer_t i1, Integer_t i2) {
  if (i2->value == 0) 
    return NULL;
  return new_git_obj(new_integer(i1->value / i2->value));
}

git_t Integer_modulo (Integer_t i1, Integer_t i2) {
  if (i2->value == 0)
    return NULL;
  return new_git_obj(new_integer(i1->value % i2->value));
}

Integer_t Integer_negative (Integer_t i1) {
  return new_integer (0 - (i1->value));
}

git_t Integer_through (Integer_t i1, Integer_t i2, int include1, int include2) {
  int int1;
  int int2;
  int1 = i1->value;
  int2 = i2->value; 
  if (include1 == 0) 
    int1 = int1 + 1;
  if (include2 == 0) 
    int2 = int2 - 1;
  return new_git_int(0, int1, int2);
}

git_t Integer_onwards (Integer_t i1, int include1) {
  int int1 = i1->value;
  if (include1 == 0)
    int1 = int1 + 1;
  return new_git_int(1, int1, 0);
}

Boolean_t Integer_equals (Integer_t i1, Integer_t i2) {
  int ans;
  if (i1->value != i2->value)
    ans = 0;
  else 
    ans = 1;
  return new_boolean(ans);
}

Boolean_t Integer_lessThan(Integer_t i1, Integer_t i2, int strict) {
  int int1;
  int int2;
  int ans;
  int1 = i1->value;
  int2 = i2->value;
  if (strict == 0) {
    if (int1 <= int2)
      ans = 1;
    else 
      ans = 0;
  }
  else {
    if (int1 < int2)
      ans = 1;
    else
      ans = 0;
  }
  return new_boolean(ans);
}

Boolean_t Character_equals (Character_t c1, Character_t c2) {
  int ans;
  if (c1->value == c2->value) 
    ans = 1;
  else
    ans = 0;
  return new_boolean (ans);
}

Boolean_t String_equals (git_t g1, git_t g2) {
  git_t t1;
  git_t t2;
  Character_t c1;
  Character_t c2;
  int flag;
  int ans;
  t1 = g1;
  t2 = g2;
  flag = 0;
  while (t1 != NULL && t2 != NULL && flag == 0) {
    c1 = t1->val;
    c2 = t2->val;
    if (c1->value != c2->value)
      flag = 1;
    t1 = t1->next;
    t2 = t2->next;
  }
  /* only way that the two were equal: */
  if (t1 == NULL && t2 == NULL && flag == 0)
    ans = 1;
  else
    ans = 0;
  return new_boolean(ans);
}

Boolean_t Boolean_negate(Boolean_t b) {
  int ans;
  if (b->value == 1)
    ans = 0;
  else 
    ans = 1;
  return new_boolean(ans);
}

Boolean_t Boolean_and (Boolean_t b1, Boolean_t b2) {
  int ans;
  ans = (b1->value) && (b2->value);
  return new_boolean(ans);
}

Boolean_t Boolean_or (Boolean_t b1, Boolean_t b2) {
  int ans;
  ans = (b1->value) || (b2->value);
  return new_boolean(ans);
}

Boolean_t Boolean_equals (Boolean_t b1, Boolean_t b2) {
  int ans;
  ans = (b1->value) == (b2->value);
  return new_boolean(ans);
}

git_t Boolean_through (Boolean_t b1, Boolean_t b2, int include1, int include2) {
  int int1;
  int int2;
  git_t g1;
  Boolean_t bool1;
  int1 = b1->value;
  int2 = b2->value; 
  if (include1 == 0) 
    int1 = int1 + 1;
  if (include2 == 0) 
    int2 = int2 - 1;
  if (int1 <= int2) {
    bool1 = new_boolean(int1);
    g1 = new_git_obj(bool1);
    int1 += 1;
    if (int1 <= int2) {
      Boolean_t bool2 = new_boolean(int1);
      git_t g2 = new_git_obj(bool2);
      g1->next = g2;
    }
  }
  else
    g1 = NULL;
  return g1;
}

git_t Boolean_onwards (Boolean_t b1, int include) {
  Boolean_t bool1;
  git_t g1;
  int int1 = b1->value;
  if (include == 0)
    int1 = int1 + 1;
  if (int1 <= 1) {
    bool1 = new_boolean(int1);
    g1 = new_git_obj(bool1);
    int1 += 1;
    if (int1 <= 1) {
      Boolean_t bool2 = new_boolean(int1);
      git_t g2 = new_git_obj(bool2);
      g1->next = g2;
    }
  }
  else
    g1 = NULL;
  return g1;
}

Boolean_t Boolean_lessThan(Boolean_t b1, Boolean_t b2, int strict) {
  int int1;
  int int2;
  int ans;
  int1 = b1->value;
  int2 = b2->value;
  if (strict == 0) {
    if (int1 <= int2)
      ans = 1;
    else 
      ans = 0;
  }
  else {
    if (int1 < int2)
      ans = 1;
    else
      ans = 0;
  }
  return new_boolean(ans);
} 

General_t Thing(){  
  General_t __struct = (General_t)x3malloc(sizeof(struct General));
  __struct->ref_count = 0;
  __struct->fun_names = NULL;
  __struct->fun_length = 0;
  __struct->fun_ptrs = NULL;
  __struct->con_comp = NULL;
  __struct->is_iter = 0;
  __struct->is_thru_ward = 0;
  return __struct;
}

/*TODO: delete before submitting */
void toString(git_t g) {
  int count = 5;
  char * buffer;
  if (g == NULL) {
    printf ("[null]\n");
    return;
  }
  iterator_t it;
  it = new_iterator(g);
  Character_t c;
  int temp = count;
  while (count > 0) {
    c = getNext(it);
    /*buffer = charToString(c); */
    printf ("--> %c\n", c->value);
     
    if (!hasNext(it)) {
      printf ("[null]\n");
      return;
    }
  }
}

void totoString(git_t g) {
  int count = 5;
  char * buffer;
  if (g == NULL) {
    printf ("[null]\n");
    return;
  }
  iterator_t it;
  it = new_iterator(g);
  git_t c;
  int temp = count;
  while (count > 0) {
    c = getNext(it);
    buffer = charToString(c);
    printf ("--> %s\n", buffer);
     /*count -= 1;*/
    if (!hasNext(it)) {
      printf ("[null]\n");
      return;
    }
  }
}

git_t get_input () {
	char * buf;
	git_t temp;
  git_t temp2;
  git_t cur;
	git_t string;
	git_t head = NULL;
	while (next_line_len() > 0) {
    printf ("NEW temp string buf\n");
		buf = (char*)x3malloc(sizeof(char) * next_line_len());
		read_line(buf);
		string = stringToIterable(buf);
    printf ("FREE temp string buff\n");
		x3free(buf);  
		temp = new_git_obj(string);
    if (head == NULL) {
      head = temp;
      cur = head;
    }
    else {
      cur->next = temp;
      cur = cur->next;
    }
	}
	return head;
}

Character_t _character(Integer_t i) {
  return new_character(i->value);
}

git_t _string(git_t str) {
  return str;
}


