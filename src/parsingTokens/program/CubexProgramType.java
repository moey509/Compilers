package parsingTokens.program;

import Exception.SemanticException;
import typeChecker.CubexCompleteContext;

public interface CubexProgramType {
	public boolean typeCheck(CubexCompleteContext c) throws SemanticException;
}
