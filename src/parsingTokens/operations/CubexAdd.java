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

public class CubexAdd extends CubexBinaryExpression {
	CubexExpression function;
	
	CubexCompleteContext cubexContext;
	
	public CubexAdd(CubexExpression left, CubexExpression right) {
		super(left, right);
		type = "Integer";
		operator = "+";
	}
	
	public IrBinaryExpression toIr(IrGenerationContext context) {
		return new IrBinaryExpression(getmLeft().toIr(context), getmRight().toIr(context), "+", cubexType);
	}
	
	public String toString(){
		return getmLeft().toString() + " . plus < > ( " + getmRight().toString() + " )";
	}
	
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		l.add(super.getmRight());
		function = new CubexFunctionApp(super.getmLeft(), "plus", new CubexList<CubexTypeGrammar>(), l);
		cubexType = function.typeCheck(c);
		return cubexType;

		//return new CubexTypeClass("Boolean", new CubexList<CubexTypeGrammar>());
	}
	
//	public ArrayList<IrBind> getExpressions(IrGenerationContext context){
//		ArrayList<IrBind> arr = function.getExpressions(context);
//		return arr;
//	}
}