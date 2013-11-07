#include "cubex_lib.h"
void* _ret;
void* __temp0;
iterator_t _it1;
git_t _return;
void cubex_main(){
void* __temp0;
void* __temp1;
iterator_t _it2;
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
__temp1 = iterable_append(iterable_append(iterable_append(new_git_obj(i), NULL), _ret ), iterable_append(new_git_obj(i), NULL) );
ref_increment((General_t)__temp1);
_ret = __temp1;
ref_increment((General_t)_ret);
ref_decrement((General_t)__temp1);
}
_it2 = new_iterator((_ret));
while(hasNext(_it2)) {
_return = getNext(_it2);
print_line(charToString(_return), stringLength(_return));
}
ref_decrement((General_t)_input);
return;
}
