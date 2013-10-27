package parsingTokens.program;

import java.util.ArrayList;

import ir.IrProgram;
import ir.IrProgramElem;
import Exception.SemanticException;
import typeChecker.CubexCompleteContext;

public class CubexProgram {
	CubexProgramType programType;
	CubexProgram nextProgram;
	
	public CubexProgram (CubexProgramType programType, CubexProgram nextProgram) {
		this.programType = programType;
		this.nextProgram = nextProgram;
	}	
	
	public IrProgram toIr() {
		ArrayList<IrProgramElem> arr;
		if (nextProgram == null) {
			arr = new ArrayList<IrProgramElem>();
		} else {
			arr = new ArrayList<IrProgramElem>(nextProgram.toIr().components);
		}
		arr.addAll(programType.toIr());
		return new IrProgram(arr);
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

		c = programType.typeCheck(c);
		if(nextProgram != null){
			nextProgram.typeCheck(c);
		}
		
	}
}
