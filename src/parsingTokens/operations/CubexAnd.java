package parsingTokens.operations;

import ir.expressions.IrBinaryExpression;
import ir.program.IrProgramContext;
import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexBinaryExpression;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.expressions.CubexFunctionApp;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public class CubexAnd extends CubexBinaryExpression {
	CubexExpression function;
	
	public CubexAnd(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	
	public IrBinaryExpression toIr(IrProgramContext context) {
		return new IrBinaryExpression(getmLeft().toIr(context), getmRight().toIr(context), "&&");
	}
	
	public String toString(){
		return getmLeft().toString() + " . and < > ( " + getmRight().toString() + " )";
	}
	
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		l.add(super.getmRight());
		function = new CubexFunctionApp(super.getmLeft(), "and",
				new CubexList<CubexTypeGrammar>(), l);
		return function.typeCheck(c);
	}
}