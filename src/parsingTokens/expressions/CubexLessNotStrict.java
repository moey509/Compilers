package parsingTokens.expressions;

import ir.expressions.IrBinaryExpression;
import ir.statements.IrBind;

import java.util.ArrayList;

import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;
import Exception.SemanticException;

public class CubexLessNotStrict extends CubexBinaryExpression {
	public CubexFunctionApp function;

	CubexCompleteContext cubexContext;

	public CubexLessNotStrict(CubexExpression left, CubexExpression right) {
		super(left, right);
		type = "Integer";
	}

	public IrBinaryExpression toIr(IrGenerationContext context) {
		return new IrBinaryExpression(getmLeft().toIr(context), getmRight().toIr(context), "<=", cubexType);
	}

	public String toString() {
		return getmLeft().toString() + " . lessThan < > ( "
				+ getmRight().toString() + " , false )";
	}

	public CubexTypeGrammar typeCheck(CubexCompleteContext c)
			throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		l.add(super.getmRight());
		l.add(new CubexBoolean(false));
		function = new CubexFunctionApp(super.getmLeft(), "lessThan",
				new CubexList<CubexTypeGrammar>(), l);
		cubexType = function.typeCheck(c);
		return cubexType;
		// return new CubexTypeClass("Boolean", new
		// CubexList<CubexTypeGrammar>());
	}
	public ArrayList<IrBind> getExpressions(IrGenerationContext context){
		ArrayList<IrBind> arr = function.getExpressions(context);
		return arr;
	}
	
}