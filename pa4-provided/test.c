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

struct git 
{
  void* val;
  git_t next;
};

struct iterator
{
  git_t g;
  int is_int;
  void * cur;
};

struct iterable
{
  git_t first;
  git_t last;
  int is_int;
};

// status: {-1 : regular number} {0 : through} {1 : onwards}
// for the case of a single number, the value will be held in the field 'low'
struct nit 
{
  void * low;
  void * high;
  int status;
};

// returns a pointer to the next element
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

    // through case
    if (n->status == 0) {
      // set cur value if not set yet
      if (it->cur == NULL) 
        it->cur = n->low;
      // case with no data
      if (it->cur > n->high) {
        it->g = g->next;
        it->cur = NULL;
        return getNext(it);
      }
      temp = it->cur;
      // increment value
      it->cur += 1;
      if (it->cur > n->high) {
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

void git_append (git_t first, git_t second) {
  git_t temp;
  temp = first;
  if (second == NULL) 
    return;
  if (first == NULL) {
    first = second;
    return;
  }
  while (temp->next != NULL) {
    temp = temp->next;
  }
  temp->next = second;
  return;
}

//TODO: need to tes
void charTest() {
  void * ans;
  git_t g1 = (git_t) malloc(sizeof(struct git));
  git_t g2 = (git_t) malloc(sizeof(struct git));
  iterable_t iter = (iterable_t) malloc (sizeof(struct iterable));
  iterator_t it = (iterator_t) malloc(sizeof(struct iterator));

  // iterable
  iter->is_int = 0;
  iter->first = g1;
  iter->last = g1;

  // iterator
  it->g = iter->first;
  it->is_int = 0;

  // null test:
  ans = getNext(it);
  if (ans == NULL) 
    printf("[ASSERT] pass [null test]\n");
  else
    printf("[ASSERT] fail [null test]\n");

  // reset iterator
  it->g = iter->first;

  // one element:
  g1->val = 'a';
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

  // reset iterator
  it->g = iter->first;
  // two elements:
  g2->val = 'b';
  g1->next = g2;

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
  charTest();
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

  printf ("test: %d\n", ((nit_t)test->val)->high);

*/

  /*
  char string[6];
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
/*
- update everything with new iterable struct
- remaining TODOs
- appending
- getNext (everything else, ints)
- memory leaks!
*/
