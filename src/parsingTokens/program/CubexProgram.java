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
	public void typeCheck(CubexCompleteContext c) throws SemanticException{

		try {
			c = programType.typeCheck(c);
		} catch (SemanticException e) {
			e.printStackTrace();
			System.out.println(c.toString());
			throw e;
		}
		if(nextProgram != null){
			nextProgram.typeCheck(c);
		}
		
	}
}
