#include "cubex_main.h"
#include "cubex_external_functions.h"

#define NULL 0

typedef struct blah* blah_t;
typedef struct git * git_t;
typedef struct nit * nit_t;
typedef struct iterator * iterator_t;
typedef struct iterable * iterable_t;
typedef struct general * general_t;
typedef struct integer * integer_t;
typedef struct character * character_t;
typedef struct boolean * boolean_t;


struct general {
  int ref_count;
  char** fun_names;
  int fun_length;
  char** fun_ptrs;
  int ptr_length;
  void* con_comp;
  int is_iter;
  int is_thru_ward;
};

struct character {
  int ref_count;
  char** fun_names;
  int fun_length;
  char** fun_ptrs;
  int ptr_length;
  void* con_comp;
  int is_iter;
  int is_thru_ward;
  char value;
};

struct integer {
  int ref_count;
  char** fun_names;
  int fun_length;
  char** fun_ptrs;
  int ptr_length;
  void* con_comp;
  int is_iter;
  int is_thru_ward;
  int value;
};

struct boolean {
  int ref_count;
  char** fun_names;
  int fun_length;
  char** fun_ptrs;
  int ptr_length;
  void* con_comp;
  int is_iter;
  int is_thru_ward;
  int value;
};


struct blah
{
  int val;
  blah_t next;
};

/* empty iterables are going to be NULL */
struct git 
{
  int ref_count;
  char** fun_names;
  int fun_length;
  char** fun_ptrs;
  int ptr_length;
  void* con_comp;
  int is_iter;
  int is_thru_ward;
  void* val;
  git_t next;
  int is_int;
  git_t storage;
  int is_input;
};

struct iterator
{
  int ref_count;
  char** fun_names;
  int fun_length;
  char** fun_ptrs;
  int ptr_length;
  void* con_comp;
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
  char** fun_ptrs;
  int ptr_length;
  void* con_comp;
  int is_iter;
  int is_thru_ward;
  int low;
  int high;
  int status;
};

character_t new_character(int input) {
  character_t c = (character_t)x3malloc(sizeof(struct character));
  c->ref_count = 0;
  c->fun_names = NULL;
  c->fun_length = 0;
  c->fun_ptrs = NULL;
  c->ptr_length = 0;
  c->con_comp = NULL; 
  c->is_iter = 0;
  c->is_thru_ward = 0;
  c->value = unichar(intput); /* will get replaced by included function */
  return c;
}

integer_t new_integer(int input) {
  integer_t i = (integer_t)x3malloc(sizeof(struct integer));
  i->ref_count = 0;
  i->fun_names = NULL;
  i->fun_length = 0;
  i->fun_ptrs = NULL;
  i->ptr_length = 0;
  i->con_comp = NULL; 
  i->is_iter = 0;
  i->is_thru_ward = 0;
  i->value = input;
  return i;
}

boolean_t new_boolean(int input) {
  boolean_t b = (boolean_t)x3malloc(sizeof(struct boolean));
  b->ref_count = 0;
  b->fun_names = NULL;
  b->fun_length = 0;
  b->fun_ptrs = NULL;
  b->ptr_length = 0;
  b->con_comp = NULL;
  b->is_iter = 0;
  b->is_thru_ward = 0;
  b->value = input;
  return b;
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
    return new_integer(int_temp);
  }
  /* regular case */
  else {
    temp = g->val;
    it->g = g->next;
    it->set = 0;
    return temp;
  }
}

/* method that frees an iterator */
void freeIterator(iterator_t it) {
  if (it != NULL)
    x3free(it);
}

/* combines two iterables, */
git_t iterable_append (git_t first, git_t second) {
  git_t g;
  git_t temp;
  git_t itr;
  git_t prev = NULL;
  g = NULL;

  /* input cases */
  if (first->is_input == 1 || second->is_input == 1) {
  	/* input appended with input */
  	if (first->is_input == 1 && second->is_input == 1) {
  		itr = first->
  		first->storage = second;

  	}

  	/*** NEED TO CLONE OTHER NODES TOO!!!! ***/

  	/* first */
  	if (first->is_input == 1) {  		
  		temp = iterable_append(input->storage, second);
  		itr = first->storage;
  		if (itr == NULL) {
  			itr = temp;
  			return first;
  		}
  		while (itr->next != NULL) 
  			itr = itr->next;
  		itr->next = temp;
  		return;
  	}
  	/* second */
  	else {
  		temp = iterable_append(first, NULL);
  		if (temp == NULL)
  			return second;
  		itr = temp;
  		while(itr->next != NULL) 
  			itr = itr->next;
  		itr->next = second;
  	}
  }

  /* regular cases */
  /* first */
  itr = first;
  while (itr != NULL) {
    temp = (git_t)x3malloc(sizeof(struct git));
    temp->val = itr->val;
    temp->is_int = itr->is_int;
    temp->next = NULL;
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
    temp = (git_t)x3malloc(sizeof(struct git));
    temp->val = itr->val;
    temp->is_int = itr->is_int;
    temp->next = NULL;
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

/* constructs a new iterable for anything but ints */
git_t new_git_obj (void* obj) {
  git_t g = (git_t)x3malloc(sizeof(struct git));

  g->ref_count = 0;
  g->fun_names = NULL;
  g->fun_length = 0;
  g->fun_ptrs = NULL;
  g->ptr_length = 0;
  g->con_comp = NULL;
  g->is_iter = 0;
  g->is_thru_ward = 0;

  g->val = obj;
  g->is_int = 0;
  g->next = NULL;

  g->storage = NULL;
  g->is_input = 0;
  return g;
}

/* constructs a new iterable for ints. The status, low and high inputs
// correspond to the values in a nit_T struct */
git_t new_git_int (int status, int low, int high) {  
  git_t g = (git_t)x3malloc(sizeof(struct git));
  nit_t n = (nit_t)x3malloc(sizeof(struct nit));

	g->ref_count = 0;
  g->fun_names = NULL;
  g->fun_length = 0;
  g->fun_ptrs = NULL;
  g->ptr_length = 0;
  g->con_comp = NULL;
  g->is_iter = 0;
  g->is_thru_ward = 0;

  n->status = status;
  n->low = low;
  n->high = high;
  g->val = n;
  g->is_int = 1;
  g->next = NULL;

  g->storage = NULL;
  g->is_input = 0;
  return g;
}

iterator_t new_iterator (git_t g) {
  iterator_t it = (iterator_t) x3malloc(sizeof(struct iterator));
  it->g = g;
  it->cur = 0;
  it->set = 0;
  return it;
}

void ref_decrement(general_t gen) {
  if (gen == NULL) 
    return;
  gen->ref_count -= 1;
  if (gen->ref_count == 0) {
    x3free(gen);
  }
}

void ref_increment(general_t gen) {
  gen->ref_count += 1;
}

/* convert a char iterable into a String */
char* charToString(git_t g) {
  if (g == NULL) 
    return NULL;
  git_t itr = g;
  int counter = 0;
  while (itr != NULL) {
    counter += 1;
    itr = itr->next;
  }
  char* buf = (char*) x3malloc (sizeof(char*) * (counter + 1));
  itr = g;
  counter = 0;
  while (itr != NULL) {
    buf[counter] = ((character_t)(itr->val))->value;
    counter += 1;
    itr=itr->next;
  }
  buf[counter] = '\0';
  return buf;
}

git_t stringToIterableHelper(char* buf, int offset) {
  if (buf[offset] == '\0') {
    return NULL;
  }
  character_t c = new_character((int)(buf[offset]));
  git_t g = new_git_obj(c);
  return iterable_append(g, stringToIterableHelper(buf, offset+1));
}

git_t stringToIterable(char* buf) {
  if (buf == NULL)
    return NULL;
  return stringToIterableHelper(buf, 0);
}




/* FUNCTIONS */

/* the following two are given to us */

integer_t integer_add (integer_t i1, integer_t i2) {
  return new_integer(i1->value + i2->value);
}

integer_t integer_subtract (integer_t i1, integer_t i2) {
  return new_integer(i1->value - i2->value);
}

integer_t integer_multiply (integer_t i1, integer_t i2) {
  return new_integer(i1->value * i2->value);
}

integer_t integer_divide (integer_t i1, integer_t i2) {
  return new_integer(i1->value / i2->value);
}

integer_t integer_mod (integer_t i1, integer_t i2) {
  return new_integer(i1->value % i2->value);
}

integer_t integer_negate (integer_t i1) {
  return new_integer (0 - (i1->value));
}

git_t integer_through (integer_t i1, integer_t i2, int include1, int include2) {
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

git_t integer_onwards (integer_t i1, int include1) {
  int int1 = i1->value;
  if (include1 == 0)
    int1 = int1 + 1;
  return new_git_int(1, int1, 0);
}

boolean_t integer_equals (integer_t i1, integer_t i2) {
  int ans;
  if (i1->value != i2->value)
    ans = 0;
  else 
    ans = 1;
  return new_boolean(ans);
}

boolean_t integer_lessThan(integer_t i1, integer_t i2, int strict) {
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

boolean_t character_equals (character_t c1, character_t c2) {
  int ans;
  if (c1->value == c2->value) 
    ans = 1;
  else
    ans = 0;
  return new_boolean (ans);
}

boolean_t string_equals (git_t g1, git_t g2) {
  git_t t1;
  git_t t2;
  character_t c1;
  character_t c2;
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

boolean_t boolean_negate(boolean_t b) {
  int ans;
  if (b->value == 1)
    ans = 0;
  else 
    ans = 1;
  return new_boolean(ans);
}

boolean_t boolean_and (boolean_t b1, boolean_t b2) {
  int ans;
  ans = (b1->value) && (b2->value);
  return new_boolean(ans);
}

boolean_t boolean_or (boolean_t b1, boolean_t b2) {
  int ans;
  ans = (b1->value) || (b2->value);
  return new_boolean(ans);
}

boolean_t boolean_equals (boolean_t b1, boolean_t b2) {
  int ans;
  ans = (b1->value) == (b2->value);
  return new_boolean(ans);
}

git_t boolean_through (boolean_t b1, boolean_t b2, int include1, int include2) {
  int int1;
  int int2;
  git_t g1;
  boolean_t bool1;
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
      boolean_t bool2 = new_boolean(int1);
      git_t g2 = new_git_obj(bool2);
      g1->next = g2;
    }
  }
  else
    g1 = NULL;
  return g1;
}

git_t boolean_onwards (boolean_t b1, int include) {
  boolean_t bool1;
  git_t g1;
  int int1 = b1->value;
  if (include == 0)
    int1 = int1 + 1;
  if (int1 <= 1) {
    bool1 = new_boolean(int1);
    g1 = new_git_obj(bool1);
    int1 += 1;
    if (int1 <= 1) {
      boolean_t bool2 = new_boolean(int1);
      git_t g2 = new_git_obj(bool2);
      g1->next = g2;
    }
  }
  else
    g1 = NULL;
  return g1;
}

boolean_t boolean_lessThan(boolean_t b1, boolean_t b2, int strict) {
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

void cubex_main(){
	/*TODO: the following lines need to be inserted into the actual C*/ 

	git_t input = new_git_obj(NULL);
	input->is_input = 1;
	/* *E*N*D* * * * * * * */

	printf ("%d\n", next_line_len());
	char * b = (char*)malloc(sizeof(char*)*next_line_len());
	read_line(b);
	printf ("%s\n", b);
}
