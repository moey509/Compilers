#!/bin/bash

# diff <(java blah) filename

for f in ../parser_tests/*.in
do 
  echo "running: $f..."
  java CubexParserMain $f
  printf '\n'
done 
