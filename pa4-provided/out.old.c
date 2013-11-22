#include "cubex_lib.h"
#include "stdio.h"
iterator_t _it1;
git_t _ret;
void* __temp4;
git_t __temp0;
git_t __temp1;
iterator_t _it2;
void* __temp2;
git_t __temp3;
git_t _iter0;
git_t _input = NULL;
iterator_t __it1;
git_t _return;

void cubex_main(){
_input = get_input();
printf ("finished with input\n");
printf("|--ref_increment((General_t)_input);\n");
ref_increment((General_t)_input);

_ret = NULL;
__temp4 = NULL;
__temp0 = NULL;
__temp1 = NULL;
__temp2 = NULL;
__temp3 = NULL;
__temp0 = NULL;
ref_decrement((General_t)__temp0);
__temp0 = NULL;
ref_increment((General_t)__temp0);
ref_decrement((General_t)_ret);
_ret = __temp0;
ref_increment((General_t)_ret);
ref_decrement((General_t)__temp0);
__temp0 = NULL;
printf ("_iter0 = iterable_append((_input), NULL);\n");
_iter0 = iterable_append((_input), NULL);
printf ("ref_increment((General_t)_iter0);\n");
ref_increment((General_t)_iter0);
_it1 = new_iterator((_iter0));
printf ("ref_increment((General_t)_it1)\n");
ref_increment((General_t)_it1);
while(hasNext(_it1)) {
printf ("begin loop...\n");
void* i = getNext(_it1);
__temp1 = NULL;
ref_decrement((General_t)__temp1);
printf ("nothing above...\n");
__temp1 = new_git_obj(new_git_obj(i));
printf ("ref_increment((General_t)__temp1);\n");
ref_increment((General_t)__temp1);
printf ("|__end increment__|\n");
__temp2 = NULL;
ref_decrement((General_t)__temp2);
if (_ret == NULL)
{
	printf ("ret is null\n");
}
__temp2 = iterable_append(__temp1, _ret );
printf ("ref_increment((General_t)__temp2);\n");
ref_increment((General_t)__temp2);
printf ("|__end increment__|\n");
__temp3 = NULL;
ref_decrement((General_t)__temp3);
__temp3 = new_git_obj(new_git_obj(i));
printf ("ref_increment((General_t)__temp3);\n");
ref_increment((General_t)__temp3);
printf ("|__end increment__|\n");
__temp4 = NULL;
ref_decrement((General_t)__temp4);
printf ("__temp4 = iterable_append(__temp2, __temp3 );\n");
__temp4 = iterable_append(__temp2, __temp3 );
printf("|--ref_increment((General_t)__temp4);\n");
ref_increment((General_t)__temp4);
printf ("|__end increment__|\n");
printf ("ref_decrement((General_t)_ret);\n");
ref_decrement((General_t)_ret);
printf ("|__end decrement__|\n");
_ret = __temp4;
printf ("|--ref_increment((General_t)_ret);\n");
ref_increment((General_t)_ret);
printf ("|__end crement__|\n");

printf ("|--ref_decrement((General_t)__temp1);\n");
ref_decrement((General_t)__temp1);
printf ("|__end crement__|\n");
__temp1 = NULL;
printf ("|--ref_decrement((General_t)__temp2);\n");
ref_decrement((General_t)__temp2);
printf ("|__end crement__|\n");
__temp2 = NULL;
printf ("|--ref_decrement((General_t)__temp3);\n");
ref_decrement((General_t)__temp3);
printf ("|__end crement__|\n");
__temp3 = NULL;
printf ("|--ref_decrement((General_t)__temp4);\n");
ref_decrement((General_t)__temp4);
printf ("|__end crement__|\n");
__temp4 = NULL;
}
printf ("[END LOOP]\n");
printf ("|--ref_decrement((General_t) _iter0);\n");
ref_decrement((General_t) _iter0);

printf ("|__end crement__|\n");
printf ("|--ref_decrement((General_t)_it1);\n");
ref_decrement((General_t)_it1);

printf ("|__end crement__|\n");

_it2 = new_iterator((_ret));
ref_increment((General_t)_it2);
printf ("[START WHILE LOOP]\n");
while(hasNext(_it2)) {
_return = getNext(_it2);
print_line(charToString(_return), stringLength(_return));
}
printf ("[END WHILE LOOP]\n");

printf ("|--ref_decrement((General_t)_it2);\n");
ref_decrement((General_t)_it2);

printf ("|__end crement__|\n");

printf ("|--ref_decrement((General_t)_ret);\n");
ref_decrement((General_t)_ret);
printf ("|__end crement__|\n");
printf ("|--ref_decrement((General_t)_input);\n");
ref_decrement((General_t)_input);
printf ("|__end crement__|\n");
/*
printf ("|-- ref_decrement((General_t)_return);\n");
ref_decrement((General_t)_return);
printf ("|__end crement__|\n");
*/

/* WHYYYY */
/*
ref_decrement(_return);
*/
printf ("[FINISH]\n");
ending();
return;
}
