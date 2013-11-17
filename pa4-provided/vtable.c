#include "cubex_lib.h"

typedef void* (*functionPtr)();
int addInt(int n, int m);


int addInt(int n, int m) {
	return n + m;
}

int multInt(int n, int m) {
	return n * m;
}

void cubex_main(){
int length = 2;
functionPtr* v = (functionPtr**) malloc (sizeof (functionPtr*) * length);
v[0] = &addInt;
v[1] = &multInt;
char** c = (char**) malloc (sizeof(char**) * length);
c[0] = "addInt\0";
c[1] = "multInt\0";



functionPtr f = v[0];
int a = f(1,2);


int b = (v[0])(1, 2);
/*printf ("a: %d, b: %d\n", a, b); */
printf ("0: %s\n", c[0]);
printf ("1: %s\n", c[1]);

return;
}
