#include "cubex_lib.h"

int addOne (int i) {
  return i+1;
} 
int addTwo(int i) {
  return i+2;
}
int addThree(int i ) {
  return i+3;
}
int addSix(int i) {
  return i + 6;
} 

int addFour(int i) {
 return i+4;
}

int addFive (int i) {
  return i+5;
}

void cubex_main(){
  Integer_t i1 = new_integer(3);
  Integer_t i2 = new_integer(4);
  i1->fun_ptrs = (functionPointer*) malloc (sizeof (functionPointer*) * 3);
  i2->fun_ptrs = (functionPointer*) malloc (sizeof (functionPointer*) * 3);
  i1->fun_names = (char**) malloc (sizeof (char**) * 3);
  i2->fun_names = (char**) malloc (sizeof (char**) * 3);
  i1->fun_length = 3;
  i2->fun_length = 3;
  functionPointer * p1 = i1->fun_ptrs;
  functionPointer * p2 = i2->fun_ptrs;
  char** c1 = i1->fun_names;
  char** c2 = i2->fun_names;
  p1[0] = &addOne;
  p1[1] = &addTwo;
  p1[2] = &addThree;
  p2[0] = &addFour;
  p2[1] = &addFive;
  p2[2] = &addSix;

  c1[0] = "addOne\0";
  c1[1] = "addSi\0"; /*addTwo*/
  c1[2] = "addThree\0";
  c2[0] = "addOn\0"; /*addFour*/
  c2[1] = "addFive\0";
  c2[2] = "addSix\0";

  i1->con_comp = i2;

  /* actual functions */
  functionPointer f = function_lookup (i1, "addOne\0");
  printf ("two: %d\n", f(1));
  f = function_lookup(i1, "addSix\0");
  printf ("ten: %d\n", f(4));
  f = function_lookup(i1, "addFive\0");
  printf ("eight: %d\n", f(3));
  f = function_lookup(i1, "addSix\0");
  printf ("seven: %d\n", f(1));
  f = function_lookup(i1, "addOn\n");
  printf ("six: %d\n", f(2));
  printf ("TEST COMPLETE\n");
  return;
}
