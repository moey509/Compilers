package parsingTokens.statements;

import parsingTokens.CubexListStatement;
import parsingTokens.expressions.CubexExpression;

public final class CubexWhile implements CubexStatement {
	private CubexExpression e;
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
