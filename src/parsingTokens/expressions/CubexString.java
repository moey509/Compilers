package parsingTokens.expressions;

import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public final class CubexString extends CubexExpression {
	private String mValue;
	public CubexString(String value) { mValue = value; }
	public String toString(){
		return mValue;
	}
	public boolean typeCheck(CubexCompleteContext c, CubexTypeGrammar t){
		return t.name.equals("String");
	}
}