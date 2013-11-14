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

public class CubexMultiply extends CubexBinaryExpression {
	CubexExpression function;

	CubexTypeGrammar cubexType;
	CubexCompleteContext cubexContext;
	
	public CubexMultiply(CubexExpression left, CubexExpression right) {
		super(left, right);
		type = "Integer";
	}
	
	public IrBinaryExpression toIr(IrGenerationContext context) {
		return new IrBinaryExpression(getmLeft().toIr(context), getmRight().toIr(context), "*", cubexType);
	}

	public String toString() {
		return getmLeft().toString() + " . times < > ( "
				+ getmRight().toString() + " )";
	}

	public CubexTypeGrammar typeCheck(CubexCompleteContext c)
			throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		l.add(super.getmRight());
		function = new CubexFunctionApp(super.getmLeft(), "times",
				new CubexList<CubexTypeGrammar>(), l);
		cubexType = function.typeCheck(c);
		return cubexType;
	}
	
	public ArrayList<IrBind> getExpressions(IrGenerationContext context){
		ArrayList<IrBind> arr = function.getExpressions(context);
		return arr;
	}
}