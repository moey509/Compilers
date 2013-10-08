package parsingTokens.expressions;

import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import Exception.SemanticException;

public final class CubexInteger extends CubexExpression {
	private int mValue;

	public CubexInteger(int value) {
		mValue = value;
	}

	public String toString() {
		return String.valueOf(mValue);
	}
	
	// Check if the expression is of some type
	public CubexTypeGrammar typeCheck(CubexCompleteContext c)
			throws SemanticException {
		return new CubexTypeClass("Integer", new CubexList<CubexTypeGrammar>());
	}
}