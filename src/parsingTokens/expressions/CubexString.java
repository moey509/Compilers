package parsingTokens.expressions;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public final class CubexString extends CubexExpression {
	private String mValue;

	public CubexString(String value) {
		mValue = value;
	}

	public String toString() {
		return mValue;
	}

	// Check if the expression is of some type
	public CubexTypeGrammar typeCheck(CubexCompleteContext c)
			throws SemanticException {
		return new CubexTypeClass("String", new CubexList<CubexTypeGrammar>());
	}
}