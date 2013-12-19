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

myout = subprocess.check_output("echo test > output", shell=True)

print "[INFO] Started Running files.."
directory = "../cg_tests/autotest"
run_dir = "../cg_tests"
for fname in sorted(glob.glob(directory + "/*.x3"), key=getnum):
    myout = subprocess.check_output("echo --- " + fname + ">> output", shell=True)
    num = getnum(fname)
    print fname
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
        print "1"
        input_file = fname[:-len("in")] + "in"
        print "2"
        running = "cat " + input_file + " | xargs ../pa4-provided/a.out >> output"
        print "3"
        print "----running code..."
        print running
        myout = subprocess.check_output(running, shell=True)
      except:
        print "echo [ERROR] %s error running file >> output"% fname
    except:
      print ("echo [ERROR] %s does not compile >> output" % fname)
    myout = subprocess.check_output("echo ~~~~~~~ >> output", shell=True) 
    myout = subprocess.check_output("echo  >> output", shell=True) 
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
