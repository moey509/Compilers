#include <stdio.h>

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
  void* val;
  git_t next;
  int is_int;
};

struct iterator
{
  git_t g;  
  int cur;
};


/* status:{0 : through} {1 : onwards}
 for the case of a single number, the value will be held in the field 'low' */
struct nit 
{
  int low;
  int high;
  int status;
};

character_t new_character(int input) {
  character_t c = (character_t)malloc(sizeof(struct character));
  c->ref_count = 0;
  c->fun_names = NULL;
  c->fun_length = 0;
  c->fun_ptrs = NULL;
  c->ptr_length = 0;
  c->con_comp = NULL; 
  c->is_iter = 0;
  c->is_thru_ward = 0;
  c->value = (char) input; /* will get replaced by included function */
  return c;
}

integer_t new_integer(int input) {
  integer_t i = (integer_t)malloc(sizeof(struct integer));
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
  boolean_t b = (boolean_t)malloc(sizeof(struct boolean));
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
  if (it == NULL || it->g == NULL)
    return 0;
  git_t g;
  nit_t n;
  /* through and onward cases */
  g = it->g;
  if (g->is_int == 1) {
    n = g->val;
    /*  through case */
    if (n->status == 0) {
      if (it->cur > n->high) {
        it->g = g->next;
        it->cur = NULL;
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
  if (it == NULL || it->g == NULL) {
    return NULL;
  }
  void * temp;
  git_t g;
  nit_t n;

  g = it->g;
  /* onward and through cases */
  if (g->is_int == 1) {
    n = g->val;
    /* set cur value if not set yet */
    if (it->cur == NULL) 
      it->cur = n->low;
    /* through case */
    if (n->status == 0) {
      /* case with no data */
      if (it->cur > n->high) {
        it->g = g->next;
        it->cur = NULL;
        return getNext(it);
      }
      temp = it->cur;
      /* increment value */
      it->cur += 1;
      if ((int)(it->cur) > (int)(n->high)) {
        it->g = g->next;
        it->cur = NULL;        
      }
    }
    /* infinite case */
    else {
      temp = it->cur;
      it->cur += 1;
    }
    return new_integer(temp);
  }
  /* regular case */
  else {
    temp = g->val;
    it->g = g->next;
    it->cur = NULL;
    return temp;
  }
}

/* method that frees an iterator */
void freeIterator(iterator_t it) {
  if (it != NULL)
    free(it);
}

/* combines two iterables, */
git_t iterable_append (git_t first, git_t second) {
  git_t g;
  git_t temp;
  git_t itr;
  git_t prev = NULL;
  g = NULL;
  /* first */
  itr = first;
  while (itr != NULL) {
    temp = (git_t)malloc(sizeof(struct git));
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
    temp = (git_t)malloc(sizeof(struct git));
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
  git_t g = (git_t)malloc(sizeof(struct git));
  g->val = obj;
  g->is_int = 0;
  g->next = NULL;
  return g;
}

/* constructs a new iterable for ints. The status, low and high inputs
// correspond to the values in a nit_T struct */
git_t new_git_int (int status, int low, int high) {  
  git_t g = (git_t)malloc(sizeof(struct git));
  nit_t n = (nit_t)malloc(sizeof(struct nit));
  n->status = status;
  n->low = low;
  n->high = high;
  g->val = n;
  g->is_int = 1;
  g->next = NULL;
  return g;
}

iterator_t new_iterator (git_t g) {
  iterator_t it = (iterator_t) malloc(sizeof(struct iterator));
  it->g = g;
  it->cur = NULL;
  return it;
}

void intTest() {
  integer_t ans;

  integer_t int1 = new_integer(1);
  git_t i1 = new_git_obj(int1);
  iterator_t it = new_iterator (i1);

  printf ("--- begin of int test\n");

  ans = getNext(it);
  printf ("[INFO][one element][regular]\n");
  if (ans->value == 1) 
    printf("[ASSERT] pass [one element]\n");    
  else
    printf("[ASSERT] fail [one element]\n");    
  ans = getNext(it);
  if (ans == NULL) 
    printf("[ASSERT] pass [one element]\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  /*  one element: through (0) */
  i1 = new_git_int (0, 2, 5);
  /* reset iterator  */
  it = new_iterator (i1);

  printf ("[INFO][one element][through]\n");
  ans = getNext(it);
  if (ans->value == 2) 
    printf("[ASSERT] pass [one element] 2 \n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  if (ans->value == 3) 
    printf("[ASSERT] pass [one element] 3\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  if (ans->value == 4) 
    printf("[ASSERT] pass [one element] 4\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  if (ans->value == 5) 
    printf("[ASSERT] pass [one element] 5\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  if (ans == NULL) 
    printf("[ASSERT] pass [one element]\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  /* one element: through (0) broken case */
  /* reset iterator */
  i1 = new_git_int (0, 5, 2);
  /* reset iterator  */
  it = new_iterator (i1);
  
  printf ("[INFO][one element][through]\n");
  ans = getNext(it);
  if (ans == NULL) 
    printf("[ASSERT] pass [one element]\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  if (ans == NULL) 
    printf("[ASSERT] pass [one element]\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  if (ans == NULL) 
    printf("[ASSERT] pass [one element]\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  /* one element: onwards (1) */
  i1 = new_git_int (1, 2, 0);
  /* reset iterator  */
  it = new_iterator (i1);

  printf ("[INFO][one element][through]\n");
  ans = getNext(it);
  /*printf ("---%d\n", ans); */
  if (ans->value == 2) 
    printf("[ASSERT] pass [one element] 2 \n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  if (ans->value == 3) 
    printf("[ASSERT] pass [one element] 3\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  if (ans->value == 4) 
    printf("[ASSERT] pass [one element] 4\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  if (ans->value == 5) 
    printf("[ASSERT] pass [one element] 5\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  /* two element tests (-1), (0) */
  int1 = new_integer(10);
  i1 = new_git_obj(int1);
  iterable_t i2 = new_git_int (0, 12, 13);
  git_t i3 = iterable_append(i1, i2);
  /* reset iterator  */
  it = new_iterator (i3);

  ans = getNext(it);
  printf ("[INFO][one element][regular]\n");
  if (ans->value == 10) 
    printf("[ASSERT] pass [one element] 10\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  if (ans->value == 12) 
    printf("[ASSERT] pass [one element] 12\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  if (ans->value == 13) 
    printf("[ASSERT] pass [one element] 13\n");    
  else
    printf("[ASSERT] fail [one element]\n");    


  /* two element tests (0), (-1) */
  i1 = new_git_int (0, 12, 13);
  int1 = new_integer(5);
  i2 = new_git_obj(int1);
  i3 = iterable_append(i1, i2);
  /* reset iterator  */
  
  it = new_iterator (i3);

  ans = getNext(it);
  printf ("--- %d\n", ans);
  printf ("[INFO][one element][regular]\n");
  if (ans->value == 12) 
    printf("[ASSERT] pass [one element] 12\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  printf ("--- %d\n", ans);
  if (ans->value == 13) 
    printf("[ASSERT] pass [one element] 13\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  printf ("--- %d\n", ans);
  if (ans->value == 5) 
    printf("[ASSERT] pass [one element] 5\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  printf ("--- %d\n", ans);
  if (ans == NULL) 
    printf("[ASSERT] pass [one element] NULL\n");    
  else
    printf("[ASSERT] fail [one element]\n");    
}


void charTest() {
  character_t ans;

  character_t c1 = new_character('a');
  character_t c2 = new_character('b');
  git_t i1 = new_git_obj(c1);
  git_t i2 = new_git_obj(c2);

  /* iterator */
  iterator_t it = new_iterator(i1);
 
  printf ("--- char test begin\n");

  /* one element: */
  ans = getNext(it);
  if (ans->value == 'a') 
    printf("[ASSERT] pass [one element]\n");    
  else
    printf("[ASSERT] fail [one element]\n");    
  ans = getNext(it);
  if (ans == NULL) 
    printf("[ASSERT] pass [one element]\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  
  /*  two elements: */
  git_t i3 = iterable_append(i1,i2);

  /* reset iterator */
  it = new_iterator(i3);

  ans = getNext(it);
  if (ans->value == 'a') 
    printf("[ASSERT] pass [two element] a\n");    
  else
    printf("[ASSERT] fail [two element]\n");    
  ans = getNext(it);
  if (ans->value == 'b') 
    printf("[ASSERT] pass [two element] b\n");    
  else
    printf("[ASSERT] fail [two element]\n");    
  ans = getNext(it);
  if (ans == NULL) 
    printf("[ASSERT] pass [two element]\n");    
  else
    printf("[ASSERT] fail [two element]\n");    
}

void for_test() {
  git_t i1 = new_git_int(0, 0, 10);
  iterator_t it;
  iterator_t it1;
  integer_t temp;


  printf ("starting...\n");
  /*
  for (it = new_iterator(i1);  temp = getNext(it); temp != NULL; temp = getNext(it)) {
    printf ("--> %d\n", temp);
  }
  */
  it = new_iterator(i1);
  while (hasNext(it)) {
    temp = getNext(it);
    
    /*
     *  insert code here
     */
    
    printf ("==> %d\n", temp->value);
  }
}


void misc_test() {
  void * ans;
  integer_t int1 = new_integer(5);
  git_t i1 = new_git_obj(int1);
  character_t char1 = new_character('b');
  git_t i2 = new_git_obj(char1);
  git_t i3 = new_git_int(0, 3, 5);
  git_t i4 = new_git_obj("sdfsdf");
  git_t i5 = new_git_int(1, 9, 0);
  git_t i6 = i1;
  i6 = iterable_append(i6, i2);
  i6 = iterable_append(i6, i3);
  i6 = iterable_append(i6, i4);
  i6 = iterable_append(i6, i5);

  /* iterator */
  iterator_t it = new_iterator(i6);
   
  printf ("%s\n", i4->val); /* sdfsdf */
  printf ("%c\n", i2->val); /* b */
  printf ("%c\n", i6->next->val); /*b */
  printf ("%p\n", i6->next->next);
  if (i6->next->next==NULL)
    printf ("wut\n");
  ans = getNext(it);
  printf ("-> %d\n", ((integer_t)ans)->value);
  ans = getNext(it);
  printf ("-> %c\n", ((character_t)ans)->value);
  ans = getNext(it);
  printf ("-> %d\n", ((integer_t)ans)->value); 
  ans = getNext(it);
  printf ("-> %d\n", ((integer_t)ans)->value);
  ans = getNext(it);
  printf ("-> %d\n", ((integer_t)ans)->value);
  ans = getNext(it);
  printf ("-> %s\n", ans);
  ans = getNext(it);
  printf ("-> %d\n", ((integer_t)ans)->value);
  ans = getNext(it);
  printf ("-> %d\n", ((integer_t)ans)->value);
  ans = getNext(it);
  printf ("-> %d\n", ((integer_t)ans)->value);

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
  char* buf = (char*) malloc (sizeof(char*) * (counter + 1));
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

void stringTest() {
  char* string = "hello world!\0";
  printf ("%s\n", string);
  git_t g = stringToIterable (string);
  if (g == NULL) {
    printf ("nulllllled\n");
  }
  char * output = charToString(g);
  printf("--> %s\n", output);
}

void charToStringTest() {
  character_t c1 = new_character(65);
  git_t g1 = new_git_obj(c1);
  character_t c2 = new_character(66);
  git_t g2 = new_git_obj(c2);
  character_t c3 = new_character(67);
  git_t g3 = new_git_obj(c3);
  character_t c4 = new_character(68);
  git_t g4 = new_git_obj(c4);
  character_t c5 = new_character(69);
  git_t g5 = new_git_obj(c5);
  character_t c6 = new_character(70);
  git_t g6 = new_git_obj(c6);

  git_t g = iterable_append(g1, iterable_append(g2, iterable_append (g3, iterable_append (g4, iterable_append(g5, g6)))));
  char* c = charToString(g);
  printf ("%s\n", c);
}


/* FUNCTIONS */

/* the following two are given to us */
char unichar(int uni) {
  return (char) uni;
}

int charuni(char c) {
  return (int) c;
}

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
  new_git_int(0, int1, int2);
}

git_t integer_onwards (integer_t i1, int include1) {
  int int1 = i1->value;
  if (include1 == 0)
    int1 = int1 + 1;
  new_git_int(1, int1, 0);
}

boolean_t integer_lessThan(integer_t i1, integer_t i2, int strict) {
  int int1;
  int int2;
  int ans;
  int1 = i1->value;
  int2 = i2->value;
  if (strict == 1) {
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
  ans = (b1->value) && (v2->value);
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
  int1 = b1->value;
  int2 = b2->value; 
  if (include1 == 0) 
    int1 = int1 + 1;
  if (include2 == 0) 
    int2 = int2 - 1;
  new_git_int(0, int1, int2);
}

git_t boolean_onwards (boolean_t b1, int include) {
  int int1 = b1->value;
  if (include1 == 0)
    int1 = int1 + 1;
  new_git_int(1, int1, 0);
}

boolean_t boolean_lessThan(boolean_t b1, boolean_t b2, int strict) {
  int int1;
  int int2;
  int ans;
  int1 = b1->value;
  int2 = b2->value;
  if (strict == 1) {
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


int main()
{
  /*
  charTest(); 
  intTest();
  misc_test();
  for_test();
*/
  /* charToStringTest();*/
  stringTest(); 
  /*
  blah_t one = (blah_t)malloc(sizeof(struct blah));
  blah_t two = (blah_t)malloc(sizeof(struct blah));
  one->val = 4;
  one->next = two;
  two->val = 5;
  
  //printf ("next val: %d\n", one->next->val);

  // String literals
  char * string = "hello world!";
  printf ("%s\n", string);

  git_t t1 = (git_t)malloc(sizeof(struct git));
  // characters
  t1->val = 'a';
  printf ("character: %c\n", t1->val);
  // integers
  t1->val = 24;
  printf ("integer: %d\n", (t1->val + 6));
  // strings
  t1->val = string;
  printf ("string: %s\n", string);

  git_t test = (git_t) malloc (sizeof(struct git));
  nit_t ntest = (nit_t) malloc (sizeof(struct nit));
  test->is_int = 1;
  test->val = ntest;
  test->next = NULL;
  ntest->low = 3;
  ntest->cur = 3;
  ntest->high = 7;
  ntest->status = 0;
no i'm 
  printf ("test: %d\n", ((nit_t)test->val)->high);

*/

  /*
  char string[6];
  sprintf("%s", string);
  string[0] = '\0';
  sprintf("%s", string[0]);
  sprintf("%s", string);
  */
  
  /*
  // array of chars
  char buffer[100];
  buffer[0] = 'a';
  buffer[1] = 'b';
  buffer[2] = 'c';
  buffer[3] = '\0';
  printf ("hello world! %s \n", buffer);
  */

  /*
  char buffer[100];
  buffer = "Hello World!\0";
  buffer[80] = '\0';
  printf("blahhh");
  sprintf(" %s \n", buffer);   
  */
  return 0;
}

/*
convert git and nit and all that to support the general schema
*/
