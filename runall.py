#!/usr/bin/env python
import glob, subprocess, re

def getnum(fname):
    return int(re.search(r"([0-9]+)", fname).group(1))

#myout = subprocess.check_output(")
# find command to compile all code: javac Exception/* lexer/* parser/* parsingTokens/* typeChecker/* -d test_dir
# run code: java -classpath test_dir/ CubexParserMain

print "sadf"
for fname in sorted(glob.glob("../parser_tests/*.in"), key=getnum):
    num = getnum(fname)
    print "[INFO] running java parser.CubexParserMain %s" % fname
    myout = subprocess.check_output("java parser.CubexParserMain %s" % fname, shell=True)
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
