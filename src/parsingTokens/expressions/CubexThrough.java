package parsingTokens.expressions;

import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import Exception.SemanticException;

public class CubexThrough extends CubexBinaryExpression {
	private boolean includeLeft;
	private boolean includeRight;
	private CubexExpression expr;

	public CubexThrough(CubexExpression l, CubexExpression r, boolean inclL,
			boolean inclR) {
		super(l, r);
		expr = l;
		includeLeft = inclL;
		includeRight = inclR;
	}

	public String toString() {
		String incL = includeLeft ? "true" : "false";
		String incR = includeRight ? "true" : "false";
		return getmLeft().toString() + " . through < > ( "
				+ getmRight().toString() + " , " + incL + " , " + incR + " )";
	}

	//Returns an Iterable of Integer
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexList<CubexTypeGrammar> l = new CubexList<CubexTypeGrammar>();
		l.add(new CubexTypeClass("Integer", new CubexList<CubexTypeGrammar>()));
		return new CubexTypeClass("Iterable", l);
	}
}
