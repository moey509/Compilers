package parsingTokens.statements;

import Exception.SemanticException;
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
	public CubexCompleteContext typeCheck(CubexCompleteContext c, boolean bool, CubexTypeClass t) throws SemanticException {
		//7.9
		if(bool){
			return e.typeCheck(c, t);
		}
		return this.typeCheck(c, true, t); //Weakening
	}
}

