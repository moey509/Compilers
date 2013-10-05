package parsingTokens.operations;

import parsingTokens.expressions.CubexExpression;
import parsingTokens.expressions.CubexUnaryExpression;

public class CubexNegate extends CubexUnaryExpression {
	public CubexNegate(CubexExpression arg) {
		super(arg);
	}
	public String toString(){
		return getmArgument().toString() + " . negate < > ( )";
	}
}