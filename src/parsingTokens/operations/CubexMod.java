package parsingTokens.operations;

import context.IrContext;
import ir.operations.IrMod;
import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexBinaryExpression;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.expressions.CubexFunctionApp;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public class CubexMod extends CubexBinaryExpression {
	CubexExpression function;
	public CubexMod(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	
	public IrMod toIr(IrContext context) {
		return new IrMod(getmLeft().toIr(context), getmRight().toIr(context));
	}

	public String toString(){
		return getmLeft().toString() + " . modulo < > ( " + getmRight().toString() + " )";
	}
	
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		l.add(super.getmRight());
		function = new CubexFunctionApp(super.getmLeft(), "modulo",
				new CubexList<CubexTypeGrammar>(), l);
		return function.typeCheck(c);
	}
}