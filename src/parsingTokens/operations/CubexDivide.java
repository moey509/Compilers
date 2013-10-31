package parsingTokens.operations;

import context.IrContext;
import ir.operations.IrDivide;
import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexBinaryExpression;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.expressions.CubexFunctionApp;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public class CubexDivide extends CubexBinaryExpression {
	CubexExpression function;
	public CubexDivide(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	
	public IrDivide toIr(IrContext context) {
		return new IrDivide(getmLeft().toIr(context), getmRight().toIr(context));
	}
	
	public String toString(){
		return getmLeft().toString() + " . divide < > ( " + getmRight().toString() + " )";
	}
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		l.add(super.getmRight());
		function = new CubexFunctionApp(super.getmLeft(), "divide",
				new CubexList<CubexTypeGrammar>(), l);
		return function.typeCheck(c);
	}
}