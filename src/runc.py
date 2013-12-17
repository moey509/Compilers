#!/usr/bin/env python
import glob, subprocess, re

def getnum(fname):
    return int(re.search(r"([0-9]+)", fname).group(1))

#myout = subprocess.check_output(")
# find command to compile all code: javac Exception/* lexer/* parser/* parsingTokens/* typeChecker/* -d test_dir
# run code: java -classpath test_dir/ CubexParserMain

print ("[INFO] Started Compiling...")
#myout = subprocess.check_output("javac Exception/*java lexer/*java parser/*java parsingTokens/*java typeChecker/*java ir/*java optimization/*java", shell=True)
print ("[INFO] Finished Compiling...")

print "[INFO] Started Running files.."
directory = "../pa4-provided"
for fname in sorted(glob.glob(directory + "/*.x3"), key=getnum):
    num = getnum(fname)
    cur = "java ir.IrMain " + str(fname)
    print "[INFO] running " + cur
    # generate out.c
    myout = subprocess.check_output(cur, shell=True)
    # move the file
    myout = subprocess.check_output("cp out.c ../pa4-provided", shell=True)
    # attempt to run 'make'
    try:
      myout = subprocess.check_output("make -C ../pa4-provided", shell=True)
      # attempt to run the C code
      try:
        input_file = fname[:-len("in")] + "in"
        running = "cat " + input_file + " | xargs " + directory + "/a.out"
        print "----running code..."
        myout = subprocess.check_output(running, shell=True)
      except:
        print "[ERROR] %s error running file"
    except:
      print ("[ERROR] %s does not compile" % fname)
      '''
    if not isinstance(myout, str): myout = str(myout, encoding='utf-8')
    expectedout = open(fname[:-len("in")] + "out").read()
    # Strip trailing newline
    expectedout = expectedout.rstrip()
    if not (myout == expectedout):
        print("*" * 10)
        print("TEST %s WRONG" % num)
        print(myout)
        print("*" * 10)
        print(expectedout)
        print("*" * 10)
    else:
        print("TEST %s OK" % num)
        '''
print "[INFO] Finished Running Files"
