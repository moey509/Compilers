import subprocess, re
#myout = subprocess.check_output("javac Exception/*java lexer/*java parser/*java parsingTokens/*java typeChecker/*java ir/*java optimization/*java", shell=True)
#myout = subprocess.check_output("java ir.IrMain ../cg_tests/b_tc_test1.x3", shell=True)
#myout = subprocess.check_output("cp out.c ../pa4-provided", shell=True)
try:
  myout = subprocess.check_output("make -C ../pa4-provided", shell=True)
  print "crap"
except:
  

myout = subprocess.check_out("echo --- SCRIPT COMPLETED ---", shell=True)

#myout = subprocess.check_output("", shell=True)
