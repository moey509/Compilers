typedef struct
{
int refcount;
char** funcName;
functionPointer p;
Thing* constructableComponent;
}Aa;
typedef struct
{
int refcount;
char** funcName;
functionPointer p;
Aa* constructableComponent;
}Bb;
void* __temp2;
void* __temp3;
Aa _Aa(void** _args){
Thing();
}
String getStringHelper(void** _args){
void* __temp0;
__temp0 = iterable_append(H, iterable_append(e, iterable_append(l, iterable_append(l, iterable_append(o, iterable_append( , iterable_append(W, iterable_append(o, iterable_append(r, iterable_append(l, iterable_append(d, iterable_append(!, NULL))))))))))));
return __temp0;
}
Bb _Bb(void** _args){
Aa();
}
String getString(void** _args){
void* __temp1;
__temp1 = _Bb_getStringHelper();
return __temp1;
}
void cubex_main(){
__temp2 = _Bb();
__temp3 = Bb_getString(__temp2);
return __temp3;
}
