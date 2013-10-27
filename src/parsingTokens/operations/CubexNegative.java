package parsingTokens.operations;

import ir.operations.IrNegative;
import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.expressions.CubexFunctionApp;
import parsingTokens.expressions.CubexUnaryExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public class CubexNegative extends CubexUnaryExpression {
	CubexExpression function;

	public CubexNegative(CubexExpression arg) {
		super(arg);
	}
	
	public IrNegative toIr() {
		return new IrNegative(getmArgument().toIr());
	}

	public String toString() {
		return getmArgument().toString() + " . negative < > ( )";
	}

	public CubexTypeGrammar typeCheck(CubexCompleteContext c)
			throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		function = new CubexFunctionApp(super.getmArgument(), "negative",
				new CubexList<CubexTypeGrammar>(), l);
		return function.typeCheck(c);
	}
}