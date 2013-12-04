#include "cubex_lib.h"
#include "stdio.h"
iterator_t _it1;
git_t a;
git_t __temp4;
void* __temp0;
git_t __temp5;
void* __temp1;
git_t __temp6;
git_t __temp2;
git_t __temp7;
git_t __temp3;
git_t input = NULL;
iterator_t __it1;
git_t _return;

void cubex_main(){
input = get_input();
ref_increment((General_t)input);
a = NULL;
__temp4 = NULL;
__temp0 = NULL;
__temp5 = NULL;
__temp1 = NULL;
__temp6 = NULL;
__temp2 = NULL;
__temp7 = NULL;
__temp3 = NULL;
__temp0 = NULL;
ref_decrement((General_t)__temp0);
__temp0 = new_integer(1);
ref_increment((General_t)__temp0);
ref_decrement((General_t)__temp0);
__temp0 = NULL;
ref_decrement((General_t)__temp1);
__temp1 = new_integer(1);
ref_increment((General_t)__temp1);
if(((Boolean_t)__temp1)->value) {
ref_decrement((General_t)__temp1);
__temp1= NULL;
__temp2 = NULL;
ref_decrement((General_t)__temp2);
__temp2 = new_git_obj_charuni((char) 't');
ref_increment((General_t)__temp2);
__temp3 = NULL;
ref_decrement((General_t)__temp3);
__temp3 = iterable_append((git_t) __temp2,(git_t) NULL);
ref_increment((General_t)__temp3);
ref_decrement((General_t)__temp2);
__temp2 = NULL;
ref_decrement((General_t)a);
a = __temp3;
ref_increment((General_t)a);
ref_decrement((General_t)__temp3);
__temp3 = NULL;
} else {
ref_decrement((General_t)__temp1);
__temp1= NULL;
__temp4 = NULL;
ref_decrement((General_t)__temp4);
__temp4 = new_git_obj_charuni((char) 'f');
ref_increment((General_t)__temp4);
__temp5 = NULL;
ref_decrement((General_t)__temp5);
__temp5 = iterable_append((git_t) __temp4,(git_t) NULL);
ref_increment((General_t)__temp5);
ref_decrement((General_t)__temp4);
__temp4 = NULL;
ref_decrement((General_t)a);
a = __temp5;
ref_increment((General_t)a);
ref_decrement((General_t)__temp5);
__temp5 = NULL;
}
ref_decrement((General_t)__temp6);
__temp6 = new_git_obj((void*) a);
ref_increment((General_t)__temp6);
ref_decrement((General_t)a);
a = NULL;
ref_decrement((General_t)__temp7);
__temp7 = iterable_append((git_t) __temp6,(git_t) NULL);
ref_increment((General_t)__temp7);
ref_decrement((General_t)__temp6);
__temp6 = NULL;
_it1 = new_iterator((__temp7));
ref_increment((General_t)_it1);
while(hasNext(_it1)) {
_return = getNext(_it1);
print_line(charToString(_return), stringLength(_return));
}
ref_decrement((General_t)_it1);
_it1 = NULL;
ref_decrement((General_t)__temp7);
__temp7 = NULL;
ref_decrement((General_t)input);
ending();
return;
}
