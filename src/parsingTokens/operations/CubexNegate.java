package parsingTokens.operations;

import ir.operations.IrNegate;
import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.expressions.CubexFunctionApp;
import parsingTokens.expressions.CubexUnaryExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public class CubexNegate extends CubexUnaryExpression {
	CubexExpression function;
	public CubexNegate(CubexExpression arg) {
		super(arg);
	}
	
	public IrNegate toIr() {
		return new IrNegate(getmArgument().toIr());
	}

	public String toString(){
		return getmArgument().toString() + " . negate < > ( )";
	}
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		function = new CubexFunctionApp(super.getmArgument(), "negate",
				new CubexList<CubexTypeGrammar>(), l);
		return function.typeCheck(c);
	}
}