package parsingTokens.expressions;

import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import Exception.SemanticException;


public class CubexLessStrict extends CubexBinaryExpression {
	public CubexLessStrict(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	public String toString(){
		return getmLeft().toString() + " . lessThan < > ( " + getmRight().toString() + " , true )";
	}
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException{
		return new CubexTypeClass("Boolean", new CubexList<CubexTypeGrammar>());
	}
}