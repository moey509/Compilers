#include <stdio.h>

typedef struct blah* blah_t;
typedef struct git * git_t;
typedef struct nit * nit_t;
typedef struct iterator * iterator_t;
typedef struct iterable * iterable_t;

struct blah
{
  int val;
  blah_t next;
};

// empty iterables are going to be NULL
struct git 
{
  void* val;
  git_t next;
  int is_int;
};

struct iterator
{
  git_t g;  
  void * cur;
};


// status: {-1 : regular number} {0 : through} {1 : onwards}
// for the case of a single number, the value will be held in the field 'low'
struct nit 
{
  void * low;
  void * high;
  int status;
};

// returns a pointer to the next elements
void* getNext(iterator_t it) {
  if (it == NULL || it->g == NULL) {
    return NULL;
  }
  void * temp;
  git_t g;
  nit_t n;

  g = it->g;
  // int case
  if (it->is_int == 1) {
    n = g->val;
    // regular case 
    if (n->status == -1) {
      temp = n->low;
      it->g = g->next;
      it->cur = NULL;
      return temp;      
    }
    //set cur value if not set yet
    if (it->cur == NULL) 
      it->cur = n->low;
    // through case
    if (n->status == 0) {
      // case with no data
      if (it->cur > n->high) {
        it->g = g->next;
        it->cur = NULL;
        return getNext(it);
      }
      temp = it->cur;
      // increment value
      it->cur += 1;
      if ((int)(it->cur) > (int)(n->high)) {
        it->g = g->next;
        it->cur = NULL;        
      }
    }
    // infinite case
    else {
      temp = it->cur;
      it->cur += 1;
    }
    return temp;
  }
  // regular case
  else {
    temp = g->val;
    it->g = g->next;
    it->cur = NULL;
    return temp;
  }
}

// method that frees an iterator
void freeIterator(iterator_t it) {
  if (it != NULL)
    free(it);
}

//TODO: need to redo so that it uses the iterable struct
// // method that frees a git_t struct
// void free_git(git_t g) {
//   git_t temp;
//   git_t free_ptr;
//   nit_t n;
//   temp = g;
//   while (temp != NULL) {
//     // int case
//     if (temp->is_int == 1) {
//       n = temp->val;
//       free(n);
//     }
//     free_ptr = temp;
//     temp = temp->next;
//     free(free_ptr);
//   }
// }

// combines two iterables, 
git_t iterable_append (git_t first, git_t second) {
  git_t g;
  git_t temp;
  git_t itr;
  git_t prev = NULL;
  g = NULL;
  // first 
  itr = first;
  while (itr != NULL) {
    temp = (git_t)malloc(sizeof(struct git));
    temp->val = itr->val;
    temp->is_int = itr->is_int;
    itr = itr->next;  
    // update pointers
    if (prev != NULL) 
      prev->next = temp;
    if (g == NULL)
      g = temp;
  }
  // second
  itr = second;
  while (itr != NULL) {
    temp = (git_t)malloc(sizeof(struct git));
    temp->val = itr->val;
    temp->is_int = itr->is_int;
    itr = itr->next;  
    // update pointers
    if (prev != NULL) 
      prev->next = temp;
    if (g == NULL)
      g = temp;
  }

  return g;
}

// constructs a new iterable for anything but ints
git_t new_git_obj (void* obj) {
  git_t g = (git_t)malloc(sizeof(struct git));
  g->val = obj;
  g->is_int = 0;
  return g;
}

// constructs a new iterable for ints. The status, low and high inputs
// correspond to the values in a nit_T struct
iterable_t new_iterable_int (int status, void* low, void* high) {  
  git_t g = (git_t)malloc(sizeof(struct git));
  nit_t n = (nit_t)malloc(sizeof(struct nit));
  n->status = status;
  n->low = low;
  n->high = high;
  g->val = n;
  g->is_int = 1;
  return iter;
}

iterator_t new_iterator (git_t g) {
  iterator_t it = (iterator_t) malloc(sizeof(struct iterator));
  it->g = g;
  it->cur = NULL;
  return it;
}

void intTest() {
  void * ans;

  iterable_t i1 = new_iterable_int(-1, 1, 0);
  iterator_t it = new_iterator (i1);

  
  ans = getNext(it);
  printf ("[INFO][one element][regular]\n");
  if (ans == 1) 
    printf("[ASSERT] pass [one element]\n");    
  else
    printf("[ASSERT] fail [one element]\n");    
  ans = getNext(it);
  if (ans == NULL) 
    printf("[ASSERT] pass [one element]\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  // one element: through (0)
  i1 = new_iterable_int (0, 2, 5);
  // reset iterator 
  it = new_iterator (i1);

  printf ("[INFO][one element][through]\n");
  ans = getNext(it);
  if (ans == 2) 
    printf("[ASSERT] pass [one element] 2 \n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  if (ans == 3) 
    printf("[ASSERT] pass [one element] 3\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  if (ans == 4) 
    printf("[ASSERT] pass [one element] 4\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  if (ans == 5) 
    printf("[ASSERT] pass [one element] 5\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  if (ans == NULL) 
    printf("[ASSERT] pass [one element]\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  // one element: through (0) broken case
  // reset iterator 
  i1 = new_iterable_int (0, 5, 2);
  // reset iterator 
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

  // one element: onwards (1)
  i1 = new_iterable_int (1, 2, 0);
  // reset iterator 
  it = new_iterator (i1);

  printf ("[INFO][one element][through]\n");
  ans = getNext(it);
  //printf ("---%d\n", ans);
  if (ans == 2) 
    printf("[ASSERT] pass [one element] 2 \n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  if (ans == 3) 
    printf("[ASSERT] pass [one element] 3\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  if (ans == 4) 
    printf("[ASSERT] pass [one element] 4\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  if (ans == 5) 
    printf("[ASSERT] pass [one element] 5\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  // two element tests (-1), (0)
  i1 = new_iterable_int (-1, 10, 0);
  iterable_t i2 = new_iterable_int (0, 12, 13);
  iterable_append(i1, i2);
  // reset iterator 
  it = new_iterator (i1);

  ans = getNext(it);
  printf ("[INFO][one element][regular]\n");
  if (ans == 10) 
    printf("[ASSERT] pass [one element] 10\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  if (ans == 12) 
    printf("[ASSERT] pass [one element] 12\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  if (ans == 13) 
    printf("[ASSERT] pass [one element] 13\n");    
  else
    printf("[ASSERT] fail [one element]\n");    


  // two element tests (0), (-1)
  i1 = new_iterable_int (0, 12, 13);
  i2 = new_iterable_int (-1, 5, 0);
  iterable_append(i1, i2);
  // reset iterator 
  //it->g = i1->first;
  it = new_iterator (i1);

  ans = getNext(it);
  printf ("--- %d\n", ans);
  printf ("[INFO][one element][regular]\n");
  if (ans == 12) 
    printf("[ASSERT] pass [one element] 12\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  printf ("--- %d\n", ans);
  if (ans == 13) 
    printf("[ASSERT] pass [one element] 13\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  ans = getNext(it);
  printf ("--- %d\n", ans);
  if (ans == 5) 
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
  void * ans;

  iterable_t i1 = new_iterable_obj('a');
  iterable_t i2 = new_iterable_obj('b');

  iterator_t it = (iterator_t) malloc(sizeof(struct iterator));

  // iterator
  it->g = i1->first;
  it->is_int = 0;

  // one element:
  ans = getNext(it);
  if ((char)ans == 'a') 
    printf("[ASSERT] pass [one element]\n");    
  else
    printf("[ASSERT] fail [one element]\n");    
  ans = getNext(it);
  if (ans == NULL) 
    printf("[ASSERT] pass [one element]\n");    
  else
    printf("[ASSERT] fail [one element]\n");    

  
  // two elements:
  iterable_append(i1,i2);

  // reset iterator
  it->g = i1->first;

  ans = getNext(it);
  if ((char)ans == 'a') 
    printf("[ASSERT] pass [two element]\n");    
  else
    printf("[ASSERT] fail [two element]\n");    
  ans = getNext(it);
  if (ans == 'b') 
    printf("[ASSERT] pass [two element]\n");    
  else
    printf("[ASSERT] fail [two element]\n");    
  ans = getNext(it);
  if (ans == NULL) 
    printf("[ASSERT] pass [two element]\n");    
  else
    printf("[ASSERT] fail [two element]\n");    
}

int main()
{
  //charTest();
  intTest();

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


//TODO: list of things that still need to be tested:
// make sure we don't add emtpy iterators
/*
- update everything with new iterable struct
- remaining TODOs
- WHEN MALLOCING, SET ALL FIELDS TO NULL
- getNext (everything else, ints)
- memory leaks!
- make it easy to link up iterables to iterators.
test:
- appending
- creation of iterables
*/
