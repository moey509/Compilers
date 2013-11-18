package parsingTokens.program;

import java.util.HashMap;
import java.util.HashSet;

import ir.program.IrProgram;
import Exception.SemanticException;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;

public class CubexProgram {
	CubexProgramType programType;
	CubexProgram nextProgram;
	// keywords in C that we want to replace
	private static final HashMap<String, String> cKeywords = new HashMap<String, String>();
	static { // initializes cKeywords
		String prepend = "__ckeyword_";
		HashSet<String> keywords = new HashSet<String>(){
			{
				add("auto");
				add("break");
				add("case");
				add("char");
				add("const");
				add("continue");
				add("default");
				add("do");
				add("double");
				add("enum");
				add("extern");
				add("float");
				add("goto");
				add("int");
				add("long");
				add("register");
				add("short");
				add("signed");
				add("sizeof");
				add("static");
				add("struct");
				add("switch");
				add("typedef");
				add("union");
				add("unsigned");
				add("void");
				add("volatile");
			}
		};
		for (String s : keywords) {
			cKeywords.put(s, prepend + s);
		}
	}

	public CubexProgram(CubexProgramType programType, CubexProgram nextProgram) {
		this.programType = programType;
		this.nextProgram = nextProgram;
	}

	public IrProgram toIr(IrGenerationContext context, IrProgram program) {
		program = programType.toIr(context, program);
		if (nextProgram == null)
			return program;
		else
			return nextProgram.toIr(context, program);
	}

	public String toString() {
		if (nextProgram == null) {
			return programType.toString();
		} else {
			return programType.toString() + " " + nextProgram.toString();
		}
	}

	public void typeCheck(CubexCompleteContext c) throws SemanticException {
		c = programType.typeCheck(c);
		if (nextProgram != null) {
			nextProgram.typeCheck(c);
		}

	}
	
	// called in IrMain to replace all C keywords with safe counterparts
	public void replaceCKeyWords() {
		programType.replaceVars(cKeywords);
		if (nextProgram != null) {
			nextProgram.replaceCKeyWords();
		}
	}
}
