package parsingTokens.program;

import ir.IrGenerationContext;
import ir.program.IrProgram;
import Exception.SemanticException;
import typeChecker.CubexCompleteContext;

public interface CubexProgramType {
	public CubexCompleteContext typeCheck(CubexCompleteContext c)
			throws SemanticException;

	public IrProgram toIr(IrGenerationContext context, IrProgram program);
}
