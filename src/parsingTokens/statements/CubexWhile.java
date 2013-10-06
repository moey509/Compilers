package parsingTokens.statements;

import parsingTokens.expressions.CubexExpression;
import typeChecker.CubexCompleteContext;

public final class CubexWhile extends CubexStatement {
	private CubexStatement s;

	public CubexWhile(CubexExpression e, CubexStatement s) {
		this.e = e;
		this.s = s;
	}

	public String toString() {
		boolean prev = CubexListStatement.flatten;
		CubexListStatement.flatten = false;
		String s2 = "while ( " + e.toString() + " ) " + s.toString();
		CubexListStatement.flatten = prev;
		return s2;
	}
}
