package parsingTokens.operations;

import java.util.ArrayList;

import ir.expressions.IrUnaryExpression;
import ir.statements.IrBind;
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
	
	CubexCompleteContext cubexContext;

	public CubexNegative(CubexExpression arg) {
		super(arg);
		type = "Integer";
		operator = "-";
	}
	
	public IrUnaryExpression toIr(IrGenerationContext context) {
		return new IrUnaryExpression(getmArgument().toIr(context), "-", cubexType);
	}

	public String toString() {
		return getmArgument().toString() + " . negative < > ( )";
	}

	public CubexTypeGrammar typeCheck(CubexCompleteContext c)
			throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		function = new CubexFunctionApp(super.getmArgument(), "negative",
				new CubexList<CubexTypeGrammar>(), l);
		cubexType = function.typeCheck(c);
		return cubexType;
	}
	
}