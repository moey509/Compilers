#include "cubex_lib.h"
void* __temp0;
void* __temp1;
git_t _it1;
git_t _return;
void cubex_main(){
git_t _input = NULL;
_input = get_input();
__temp0 = NULL;
__temp1 = NULL;
ref_decrement((General_t)__temp0);
__temp0 = iterable_append(new_git_obj(new_character(charuni('H'))), iterable_append(new_git_obj(new_character(charuni('e'))), iterable_append(new_git_obj(new_character(charuni('l'))), iterable_append(new_git_obj(new_character(charuni('l'))), iterable_append(new_git_obj(new_character(charuni('o'))), iterable_append(new_git_obj(new_character(charuni(' '))), iterable_append(new_git_obj(new_character(charuni('W'))), iterable_append(new_git_obj(new_character(charuni('o'))), iterable_append(new_git_obj(new_character(charuni('r'))), iterable_append(new_git_obj(new_character(charuni('l'))), iterable_append(new_git_obj(new_character(charuni('d'))), iterable_append(new_git_obj(new_character(charuni('!'))), NULL))))))))))));
ref_increment((General_t)__temp0);
ref_decrement((General_t)__temp1);
__temp1 = iterable_append(new_git_obj(__temp0), NULL);
ref_increment((General_t)__temp1);
ref_decrement((General_t)__temp0);
_it1 = new_iterator((__temp1));
while(hasNext(_it1)) {
_return = getNext(_it1);
print_line(charToString(_return), stringLength(_return));
}
ref_decrement((General_t)_input);
return;
}
