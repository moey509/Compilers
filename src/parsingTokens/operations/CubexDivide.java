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

public class CubexDivide extends CubexBinaryExpression {
	CubexExpression function;

	CubexCompleteContext cubexContext;
	
	public CubexDivide(CubexExpression left, CubexExpression right) {
		super(left, right);
		type = "Integer";
		operator = "/";
	}
	
	public IrBinaryExpression toIr(IrGenerationContext context) {
		return new IrBinaryExpression(getmLeft().toIr(context), getmRight().toIr(context), "/", cubexType);
	}
	
	public String toString(){
		return getmLeft().toString() + " . divide < > ( " + getmRight().toString() + " )";
	}
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		l.add(super.getmRight());
		function = new CubexFunctionApp(super.getmLeft(), "divide",
				new CubexList<CubexTypeGrammar>(), l);
		cubexType = function.typeCheck(c);
		return cubexType;
	}

}