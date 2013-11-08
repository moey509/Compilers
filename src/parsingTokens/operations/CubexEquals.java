package parsingTokens.operations;

import java.util.ArrayList;

import ir.expressions.IrBinaryExpression;
import ir.statements.IrBind;
import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexBinaryExpression;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.expressions.CubexFunctionApp;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;

public class CubexEquals extends CubexBinaryExpression {
	CubexExpression function;
	public CubexEquals(CubexExpression left, CubexExpression right) {
		super(left, right);
		type = left.type;
	}
	
	public IrBinaryExpression toIr(IrGenerationContext context) {
		return new IrBinaryExpression(getmLeft().toIr(context), getmRight().toIr(context), "==");
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
	public ArrayList<IrBind> getExpressions(IrGenerationContext context){
		ArrayList<IrBind> arr = function.getExpressions(context);
		return arr;
	}
}