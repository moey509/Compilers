package parsingTokens.program;

import java.util.HashMap;

import ir.program.IrProgram;
import Exception.SemanticException;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;

public interface CubexProgramType {
	public CubexCompleteContext typeCheck(CubexCompleteContext c)
			throws SemanticException;

	public IrProgram toIr(IrGenerationContext context, IrProgram program);
	
	public void replaceVars(HashMap<String, String> map);
}
