package parsingTokens.operations;

import ir.operations.IrAdd;
import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexBinaryExpression;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.expressions.CubexFunctionApp;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public class CubexAdd extends CubexBinaryExpression {
	CubexExpression function;
	
	public CubexAdd(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	
	public IrAdd toIr() {
		return new IrAdd(getmLeft().toIr(), getmRight().toIr());
	}
	
	public String toString(){
		return getmLeft().toString() + " . plus < > ( " + getmRight().toString() + " )";
	}
	
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		l.add(super.getmRight());
		function = new CubexFunctionApp(super.getmLeft(), "plus",
				new CubexList<CubexTypeGrammar>(), l);
		return function.typeCheck(c);

		//return new CubexTypeClass("Boolean", new CubexList<CubexTypeGrammar>());
	}
}