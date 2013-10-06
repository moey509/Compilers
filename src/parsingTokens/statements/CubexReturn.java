package parsingTokens.statements;

import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeClass;
import typeChecker.CubexCompleteContext;

public final class CubexReturn extends CubexStatement {
	private CubexExpression e;

	public CubexReturn(CubexExpression e) {
		this.e = e;
	}

	public String toString() {
		return "return " + e.toString() + " ;";
	}
	public boolean typeCheck(CubexCompleteContext c, boolean bool, CubexTypeClass t) {
		//7.9
		if(bool){
			return e.typeCheck(c, t);
		}
		return false;
	}
}

