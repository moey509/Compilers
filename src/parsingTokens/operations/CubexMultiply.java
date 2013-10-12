package parsingTokens.operations;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexBinaryExpression;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.expressions.CubexFunctionApp;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public class CubexMultiply extends CubexBinaryExpression {
	CubexExpression function;

	public CubexMultiply(CubexExpression left, CubexExpression right) {
		super(left, right);
	}

	public String toString() {
		return getmLeft().toString() + " . times < > ( "
				+ getmRight().toString() + " )";
	}

	public CubexTypeGrammar typeCheck(CubexCompleteContext c)
			throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		l.add(super.getmRight());
		function = new CubexFunctionApp(super.getmLeft(), "times",
				new CubexList<CubexTypeGrammar>(), l);
		return function.typeCheck(c);
	}
}