package parsingTokens.operations;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexBinaryExpression;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public class CubexAnd extends CubexBinaryExpression {
	public CubexAnd(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	
	public String toString(){
		return getmLeft().toString() + " . and < > ( " + getmRight().toString() + " )";
	}
	
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		return new CubexTypeClass("Boolean", new CubexList<CubexTypeGrammar>());
	}
}