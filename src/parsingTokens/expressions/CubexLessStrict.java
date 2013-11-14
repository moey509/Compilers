package parsingTokens.expressions;

import java.util.ArrayList;
import ir.expressions.IrBinaryExpression;
import ir.statements.IrBind;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;
import Exception.SemanticException;

public class CubexLessStrict extends CubexBinaryExpression {

	public CubexFunctionApp function;
	
	CubexTypeGrammar cubexType;
	CubexCompleteContext cubexContext;

	public CubexLessStrict(CubexExpression left, CubexExpression right) {
		super(left, right);
		type = "Integer";
	}

	public IrBinaryExpression toIr(IrGenerationContext context) {
		return new IrBinaryExpression(getmLeft().toIr(context), getmRight().toIr(context), "<", cubexType);
	}

	public String toString() {
		return getmLeft().toString() + " . lessThan < > ( "
				+ getmRight().toString() + " , true )";
	}

	public CubexTypeGrammar typeCheck(CubexCompleteContext c)
			throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		l.add(super.getmRight());
		l.add(new CubexBoolean(true));
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