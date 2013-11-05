void* _ret;
void cubex_main(){
_ret = NULL;
_it1 = new_iterator((_input));
while(hasNext(_it1)) {
i = getNext(_it1);
_ret = iterable_append(iterable_append(iterable_append(i, NULL), _ret ), iterable_append(i, NULL) );
}
return _ret;
}
