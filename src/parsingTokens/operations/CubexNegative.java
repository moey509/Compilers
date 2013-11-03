package parsingTokens.operations;

import ir.expressions.IrUnaryExpression;
import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.expressions.CubexFunctionApp;
import parsingTokens.expressions.CubexUnaryExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;

public class CubexNegative extends CubexUnaryExpression {
	CubexExpression function;

	public CubexNegative(CubexExpression arg) {
		super(arg);
	}
	
	public IrUnaryExpression toIr(IrGenerationContext context) {
		return new IrUnaryExpression(getmArgument().toIr(context), "-");
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