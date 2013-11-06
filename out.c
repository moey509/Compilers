void* _ret;
void* __temp0;
void cubex_main(){
__temp0 = NULL;
_ret = __temp0;
__it1 = new_iterator((_input));
while(hasNext(__it1)) {
void* __temp1;
void* _ret;
void* i = getNext(__it1);
__temp1 = iterable_append(iterable_append(iterable_append(i, NULL), _ret ), iterable_append(i, NULL) );
_ret = __temp1;
}
return _ret;
}
