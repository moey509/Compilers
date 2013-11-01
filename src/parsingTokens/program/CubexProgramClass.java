package parsingTokens.program;

import ir.program.IrProgram;
import ir.program.IrProgramContext;
import Exception.SemanticException;
import parsingTokens.CubexClassGrammar;
import typeChecker.CubexCompleteContext;

public class CubexProgramClass implements CubexProgramType {
	private CubexClassGrammar cubexClass;

	public CubexProgramClass(CubexClassGrammar cubexClass) {
		this.cubexClass = cubexClass;
	}

	public String toString() {
		return cubexClass.toString();
	}

	@Override
	public CubexCompleteContext typeCheck(CubexCompleteContext c)
			throws SemanticException {
		// TODO Auto-generated method stub
		return cubexClass.typeCheck(c);
	}

	@Override
	public IrProgram toIr(IrProgramContext context, IrProgram program) {
		return cubexClass.toIr(context, program);
	}

}