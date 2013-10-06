package parsingTokens.expressions;

import Exception.SemanticException;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public final class CubexString extends CubexExpression {
	private String mValue;

	public CubexString(String value) { mValue = value; }
	public String toString(){
		return mValue;
	}

	/*public boolean typeCheck(CubexCompleteContext c, CubexTypeGrammar t) throws SemanticException{
		throw new SemanticException("");
	}*/
}