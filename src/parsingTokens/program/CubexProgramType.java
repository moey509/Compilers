package parsingTokens.program;

import ir.program.IrProgram;
import ir.program.IrProgramContext;
import Exception.SemanticException;
import typeChecker.CubexCompleteContext;

public interface CubexProgramType {
	public CubexCompleteContext typeCheck(CubexCompleteContext c)
			throws SemanticException;

	public IrProgram toIr(IrProgramContext context, IrProgram program);
}
