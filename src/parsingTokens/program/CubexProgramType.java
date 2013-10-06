package parsingTokens.program;

import Exception.SemanticException;
import typeChecker.CubexCompleteContext;

public interface CubexProgramType {
	public void typeCheck(CubexCompleteContext c) throws SemanticException;
}
