package parsingTokens.program;

import Exception.SemanticException;
import typeChecker.CubexCompleteContext;

public class CubexProgram {
	CubexProgramType programType;
	CubexProgram nextProgram;
	
	public CubexProgram (CubexProgramType programType, CubexProgram nextProgram) {
		this.programType = programType;
		this.nextProgram = nextProgram;
	}	
	
	public String toString() {
		if (nextProgram == null) {
			return programType.toString();
		}
		else {
			return programType.toString() + " " + nextProgram.toString();
		}
	}
	public boolean typeCheck(CubexCompleteContext c) throws SemanticException{
		return programType.typeCheck(c) && (nextProgram == null || nextProgram.typeCheck(c));
	}
}
