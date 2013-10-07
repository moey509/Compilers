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

	// Check if the expression is of some type
	public CubexTypeGrammar typeCheck(CubexCompleteContext c, CubexTypeGrammar t)
			throws SemanticException {
		
		
		return new CubexTypeClass("Boolean", new CubexList<CubexTypeGrammar>());
	}

	public CubexTypeGrammar typeCheck(CubexCompleteContext c, CubexTypeClass t)
			throws SemanticException {
		
		
		return new CubexTypeClass("Boolean", new CubexList<CubexTypeGrammar>());
	}

	// Check if the expression is of some list of types
	public CubexTypeGrammar typeCheck(CubexCompleteContext c,
			CubexList<CubexTypeGrammar> t) throws SemanticException {
		return new CubexTypeClass("Boolean", new CubexList<CubexTypeGrammar>());
	}
}
