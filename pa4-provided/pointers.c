#include "cubex_lib.1.h"
#include "stdio.h"

typedef struct node * node_t;

struct node {
	node_t next;
	int val;
};


void switching (Integer_t i1, Integer_t i2) {
	Integer_t temp = malloc(sizeof (struct Integer));
	*temp = *i2;
	*i2 = *i1;
	*i1 = *temp;	
	printf ("switching value: %d, %d\n", i1->value, i2->value);
}

void cubex_main(){
	/*
	git_t input;
	git_t this;
	functionPointer fun_ptr;
	functionPointer blah;
	input = new_lazy_git_obj(&_lazy_input);
*/
	node_t n1 = (node_t) malloc (sizeof (struct node));
	node_t n2 = (node_t) malloc (sizeof (struct node));
	node_t n3 = (node_t) malloc (sizeof (struct node));

	n1->val = 1;
	n2->val = 2;
	n3->val = 3;
	n1->next = n2;
	printf ("old value: %d\n", n1->next->val);	
	*n2 = *n3;
	printf ("new value: %d\n", n1->next->val);

	Integer_t i1 = new_integer(1);
	Integer_t i2 = new_integer(2);	
	printf ("old value: %d, %d\n", i1->value, i2->value);
	switching (i1, i2);
	printf ("new value: %d, %d\n", i1->value, i2->value);

	printf ("hello world!\n");
return;
}
