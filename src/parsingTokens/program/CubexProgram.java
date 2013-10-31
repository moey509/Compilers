package parsingTokens.program;

import context.IrContext;
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
	
	public IrProgram toIr(IrContext context) {
		IrProgram program = new IrProgram();
		IrContext ircontext = context;
		CubexProgram programPointer = this;
		while (programPointer != null) {
			for (IrProgramElem elem : programPointer.programType.toIr(ircontext)){
				program.addComponent(elem);
			}
			programPointer = programPointer.nextProgram;
		} 
		return program;
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
