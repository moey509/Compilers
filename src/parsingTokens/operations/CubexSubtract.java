package parsingTokens.operations;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexBinaryExpression;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public class CubexSubtract extends CubexBinaryExpression {
	public CubexSubtract(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	public String toString(){
		return getmLeft().toString() + " . minus < > ( " + getmRight().toString() + " )";
	}
	
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		return new CubexTypeClass("Integer", new CubexList<CubexTypeGrammar>());
	}
}