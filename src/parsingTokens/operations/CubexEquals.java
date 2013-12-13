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

	CubexCompleteContext cubexContext;
	
	public CubexEquals(CubexExpression left, CubexExpression right) {
		super(left, right);
		type = "Boolean";
		operator = "==";
	}
	
	public IrBinaryExpression toIr(IrGenerationContext context) {
		return new IrBinaryExpression(getmLeft().toIr(context), getmRight().toIr(context), "==", cubexType);
	}
	
	public String toString(){
		return getmLeft().toString() + " . equals < > ( " + getmRight().toString() + " )";
	}
	
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		l.add(super.getmRight());
		function = new CubexFunctionApp(super.getmLeft(), "equals",
				new CubexList<CubexTypeGrammar>(), l);
		this.cubexType = function.typeCheck(c);
		return cubexType;
	}

}