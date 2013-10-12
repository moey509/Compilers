package parsingTokens.operations;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.expressions.CubexUnaryExpression;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public class CubexNegate extends CubexUnaryExpression {
	public CubexNegate(CubexExpression arg) {
		super(arg);
	}
	public String toString(){
		return getmArgument().toString() + " . negate < > ( )";
	}
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		return new CubexTypeClass("Boolean", new CubexList<CubexTypeGrammar>());
	}
}