#!/bin/bash
# NOTE1: Execute by running $ /src/test.sh while in Compilers or $ ./test.sh while in src
# NOTE2: if system complains about permissions, run $ chmod u+x test.sh

# diff <(java blah) filename

for f in ../parser_tests/*.in
do 
  echo "running: $f..."
  printf "  contents of file: "
  cat $f
  echo "--EOF--"
  #java CubexParserMain $f
#  printf '\n'
  temp="$f"
  len=${#f}
  new=`expr $len - 3`
#  echo `expr $len - 3`
  out=${temp:0:new}
  outFile="$out.out"
#  echo $outFile
  diff <(java CubexParserMain $f) $outFile
  printf '\n\n'
done 
