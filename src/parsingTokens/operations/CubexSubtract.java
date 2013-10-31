package parsingTokens.operations;

import context.IrContext;
import ir.operations.IrSubtract;
import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexBinaryExpression;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.expressions.CubexFunctionApp;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public class CubexSubtract extends CubexBinaryExpression {
	CubexExpression function;
	
	public CubexSubtract(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	
	public IrSubtract toIr(IrContext context) {
		return new IrSubtract(getmLeft().toIr(context), getmRight().toIr(context));
	}
	
	public String toString(){
		return getmLeft().toString() + " . minus < > ( " + getmRight().toString() + " )";
	}
	
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		l.add(super.getmRight());
		function = new CubexFunctionApp(super.getmLeft(), "minus",
				new CubexList<CubexTypeGrammar>(), l);
		return function.typeCheck(c);
	}
}