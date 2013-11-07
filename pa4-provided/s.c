#include "cubex_lib.h"
void* _ret;
void* __temp0;
git_t __temp1;
iterator_t _it1;
iterator_t _it2;
git_t _return;

void test() {
  git_t i1;
  git_t i2;
  git_t i3;
  git_t i4;
  git_t i5;
  git_t i6;
  git_t i7;
  Character_t c1 = new_character(70);
  Character_t c2 = new_character(71);
  Character_t c3 = new_character(72);
  Character_t c4 = new_character(73);
  Character_t c5 = new_character(74);
  Character_t c6 = new_character(75);
  Character_t c7 = new_character(76);
  i1 = new_git_obj(c1); 
  i2 = new_git_obj(c2); 
  i3 = new_git_obj(c3); 
  i4 = new_git_obj(c4); 
  i5 = new_git_obj(c5); 
  i6 = new_git_obj(c6); 
  i7 = new_git_obj(c7); 
  git_t cur = NULL;
  git_t blah = NULL;
  cur = iterable_append(iterable_append(iterable_append(i1, NULL), blah ), iterable_append(i1, NULL) );
  blah = cur;
  toString(cur);

  cur = iterable_append(iterable_append(iterable_append(i2, NULL), blah ), iterable_append(i2, NULL) );
  blah = cur;
  toString(cur);

  cur = iterable_append(iterable_append(iterable_append(i3, NULL), blah ), iterable_append(i3, NULL) );
  blah = cur;
  toString(cur);
}

void cubex_main(){
	/*test(); */
  
git_t _iter0;
git_t _input = NULL;
_input = get_input();
_ret = NULL;
__temp0 = NULL;
ref_decrement((General_t)__temp0);
__temp0 = NULL;
ref_increment((General_t)__temp0);
_ret = __temp0;
ref_increment((General_t)_ret);
ref_decrement((General_t)__temp0);
_iter0 = iterable_append((_input), NULL);
_it1 = new_iterator((_iter0));
while(hasNext(_it1)) {
void* i = getNext(_it1);
ref_decrement((General_t)__temp1); 
/*printf ("before:\n ");
totoString(_ret);  */
__temp1 = iterable_append(iterable_append(iterable_append(new_git_obj(i), NULL), _ret ), iterable_append(new_git_obj(i), NULL) );
/*printf ("after:\n ");
totoString(__temp1); */
ref_increment((General_t)__temp1);
_ret = __temp1;
ref_increment((General_t)_ret);
ref_decrement((General_t)__temp1); 

totoString(__temp1);
}
_it2 = new_iterator((_ret));
while(hasNext(_it2)) {
_return = getNext(_it2);
print_line(charToString(_return), stringLength(_return));
}
ref_decrement((General_t)_input);
return;

}
