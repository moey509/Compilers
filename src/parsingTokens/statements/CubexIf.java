package parsingTokens.statements;

import parsingTokens.CubexListStatement;
import parsingTokens.expressions.CubexExpression;

public final class CubexIf implements CubexStatement {
	private CubexExpression e;  // if e:
	private CubexStatement s1;	//{	s1 }
	private CubexStatement s2;	// else {s2}

	// if there is no else statement, let s2 be null
	public CubexIf(CubexExpression e, CubexStatement s1, CubexStatement s2) {
		this.e = e;
		this.s1 = s1;
		this.s2 = s2;
	}

	public String toString() {
		String temp;
		if (s2 != null) {
			temp = s2.toString();
		}
		else{
			temp = "{ }";
		}
		boolean prev = CubexListStatement.flatten;
		CubexListStatement.flatten = false;
		String newString = "if ( " + e.toString() + " ) " + s1.toString() + " else " + temp;
		CubexListStatement.flatten = prev;
		return newString;
	}

}
