package parsingTokens.program;

import ir.program.IrProgram;
import ir.program.IrProgramContext;
import Exception.SemanticException;
import typeChecker.CubexCompleteContext;

public class CubexProgram {
	CubexProgramType programType;
	CubexProgram nextProgram;

	public CubexProgram(CubexProgramType programType, CubexProgram nextProgram) {
		this.programType = programType;
		this.nextProgram = nextProgram;
	}

	public IrProgram toIr(IrProgramContext context, IrProgram program) {
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
}
