package parsingTokens.statements;

import parsingTokens.expressions.CubexExpression;

public final class CubexReturn implements CubexStatement {
	private CubexExpression e;

	public CubexReturn(CubexExpression e) {
		this.e = e;
	}

	public String toString() {
		return "return " + e.toString() + " ;";
	}
}

