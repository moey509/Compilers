package parsingTokens.expressions;

import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import Exception.SemanticException;


public class CubexLessNotStrict extends CubexBinaryExpression {
	public CubexFunctionApp function;
	
	public CubexLessNotStrict(CubexExpression left, CubexExpression right) {
		super(left, right);

	}
	public String toString(){
		return getmLeft().toString() + " . lessThan < > ( " + getmRight().toString() + " , false )";
	}
	
	public CubexTypeGrammar typeCheck(CubexCompleteContext c,
			CubexList<CubexTypeGrammar> t) throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		l.add(super.getmRight());
		function = new CubexFunctionApp(super.getmLeft(), "lessThan", new CubexList<CubexTypeGrammar>(), l);
		function.typeCheck(c);
		return function.typeCheck(c);
		//return new CubexTypeClass("Boolean", new CubexList<CubexTypeGrammar>());

	}
}