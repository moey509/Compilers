package parsingTokens.operations;

import ir.operations.IrOr;
import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexBinaryExpression;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.expressions.CubexFunctionApp;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public class CubexOr extends CubexBinaryExpression {
	CubexExpression function;
	
	public CubexOr(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	
	public IrOr toIr() {
		return new IrOr(getmLeft().toIr(), getmRight().toIr());
	}
	
	public String toString(){
		return getmLeft().toString() + " . or < > ( " + getmRight().toString() + " )";
	}
	
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		l.add(super.getmRight());
		function = new CubexFunctionApp(super.getmLeft(), "or",
				new CubexList<CubexTypeGrammar>(), l);
		return function.typeCheck(c);
	}
}