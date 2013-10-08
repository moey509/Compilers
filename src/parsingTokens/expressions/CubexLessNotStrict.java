package parsingTokens.expressions;

import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import Exception.SemanticException;


public class CubexLessNotStrict extends CubexBinaryExpression {
	public CubexLessNotStrict(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	public String toString(){
		return getmLeft().toString() + " . lessThan < > ( " + getmRight().toString() + " , false )";
	}
	
	public CubexTypeGrammar typeCheck(CubexCompleteContext c,
			CubexList<CubexTypeGrammar> t) throws SemanticException {
		return new CubexTypeClass("Boolean", new CubexList<CubexTypeGrammar>());
	}
}