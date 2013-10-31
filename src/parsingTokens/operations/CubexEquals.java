package parsingTokens.operations;

import context.IrContext;
import ir.operations.IrEquals;
import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexBinaryExpression;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.expressions.CubexFunctionApp;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public class CubexEquals extends CubexBinaryExpression {
	CubexExpression function;
	public CubexEquals(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	
	public IrEquals toIr(IrContext context) {
		return new IrEquals(getmLeft().toIr(context), getmRight().toIr(context));
	}
	
	public String toString(){
		return getmLeft().toString() + " . equals < > ( " + getmRight().toString() + " )";
	}
	
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		l.add(super.getmRight());
		function = new CubexFunctionApp(super.getmLeft(), "equals",
				new CubexList<CubexTypeGrammar>(), l);
		return function.typeCheck(c);
	}
}