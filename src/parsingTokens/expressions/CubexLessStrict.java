package parsingTokens.expressions;

import ir.expressions.IrLessStrict;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import Exception.SemanticException;

public class CubexLessStrict extends CubexBinaryExpression {

	public CubexFunctionApp function;

	public CubexLessStrict(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	
	public IrLessStrict toIr() {
		return new IrLessStrict(getmLeft().toIr(), getmRight().toIr());
	}

	public String toString() {
		return getmLeft().toString() + " . lessThan < > ( "
				+ getmRight().toString() + " , true )";
	}

	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		l.add(super.getmRight());
		l.add(new CubexBoolean(true));
		function = new CubexFunctionApp(super.getmLeft(), "lessThan",
				new CubexList<CubexTypeGrammar>(), l);
		return function.typeCheck(c);

		//return new CubexTypeClass("Boolean", new CubexList<CubexTypeGrammar>());
	}
}