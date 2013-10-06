package parsingTokens.program;

import Exception.SemanticException;
import typeChecker.CubexCompleteContext;

public interface CubexProgramType {
	public CubexCompleteContext typeCheck(CubexCompleteContext c) throws SemanticException;
}
