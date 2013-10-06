package parsingTokens.program;

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
	public void typeCheck(CubexCompleteContext c) throws SemanticException {
		// TODO Auto-generated method stub
		throw new SemanticException("");
	}
}