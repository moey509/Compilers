package parsingTokens.expressions;

import context.IrContext;
import ir.expressions.IrLessNotStrict;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import Exception.SemanticException;

public class CubexLessNotStrict extends CubexBinaryExpression {
	public CubexFunctionApp function;

	public CubexLessNotStrict(CubexExpression left, CubexExpression right) {
		super(left, right);
	}

	public IrLessNotStrict toIr(IrContext context) {
		return new IrLessNotStrict(getmLeft().toIr(context), getmRight().toIr(
				context));
	}

	public String toString() {
		return getmLeft().toString() + " . lessThan < > ( "
				+ getmRight().toString() + " , false )";
	}

	
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		l.add(super.getmRight());
		l.add(new CubexBoolean(false));
		function = new CubexFunctionApp(super.getmLeft(), "lessThan",
				new CubexList<CubexTypeGrammar>(), l);
		function.typeCheck(c);
		return function.typeCheck(c);
		// return new CubexTypeClass("Boolean", new
		// CubexList<CubexTypeGrammar>());

	}
}