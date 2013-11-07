typedef struct Cc* Cc_t;
struct Cc
{
int refcount;
char** funcName;
functionPointer p;
Thing_t con_comp;
};
void* _a
void* __temp5
void* __temp6
void* __temp7
_a = NULL;
__temp5 = NULL;
__temp6 = NULL;
__temp7 = NULL;
Integer_t foo(){
void* __temp0;
ref_decrement(__temp0);
__temp0 = new_integer(1);
ref_increment(__temp0);
return __temp0;
}
Integer_t bar(){
void* __temp1;
ref_decrement(__temp1);
__temp1 = new_integer(2);
ref_increment(__temp1);
return __temp1;
}
Integer_t foo(void**_t ConstructableComponent){
__struct->ConstructableComponent = NULL;
void* __temp2;
ref_decrement(__temp2);
__temp2 = new_integer(1);
ref_increment(__temp2);
return __temp2;
return _Aa_foo();
}
Cc_t _Cc(){
Cc_t __struct = (Cc_t)(x3malloc(sizeof(structCc)));
__struct->ref_count = 0;
__struct->con_comp = Thing();
__struct->con_comp->ref_count = 1;
return __struct;
}
Integer_t bar(void*_t ConstructableComponent){
__struct->ConstructableComponent = NULL;
void* __temp3;
ref_decrement(__temp3);
__temp3 = new_integer(2);
ref_increment(__temp3);
return __temp3;
return _Bb_bar();
}
Integer_t foo(void*_t ConstructableComponent){
__struct->ConstructableComponent = NULL;
void* __temp4;
ref_decrement(__temp4);
__temp4 = new_integer(1);
ref_increment(__temp4);
return __temp4;
return _Bb_foo();
}
void cubex_main(){
ref_decrement(__temp5);
__temp5 = _Cc();
ref_increment(__temp5);
ref_decrement(__temp6);
__temp6 = Cc_foo(__temp5);
ref_increment(__temp6);
_a = __temp6;
ref_increment(_a);
ref_decrement(__temp5);
ref_decrement(__temp6);
ref_decrement(__temp7);
__temp7 = NULL;
ref_increment(__temp7);
return __temp7;
}
