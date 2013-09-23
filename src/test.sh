#!/bin/bash
# NOTE1: Execute by running $ /src/test.sh while in Compilers or $ ./test.sh while in src
# NOTE2: if system complains about permissions, run $ chmod u+x test.sh

# diff <(java blah) filename

for f in ../parser_tests/*.in
do 
  echo "running: $f..."
  java CubexParserMain $f
  printf '\n'
done 
