package parsingTokens.statements;

import parsingTokens.CubexListStatement;
import parsingTokens.expressions.CubexExpression;

public final class CubexFor implements CubexStatement {
	private String varfun;
	private CubexExpression e;
	private CubexStatement s;

	public CubexFor(String varfun, CubexExpression e, CubexStatement s) {
		this.varfun = varfun;
		this.e = e;
		this.s = s;
	}

	public String toString() {
		boolean prev = CubexListStatement.flatten;
		CubexListStatement.flatten = false;
		String result = "for ( " + varfun + " in " + e.toString() + " ) " + s.toString();
		CubexListStatement.flatten = prev;
		return result;
	}
}

