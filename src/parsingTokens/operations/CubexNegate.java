package parsingTokens.operations;

import parsingTokens.CubexUnaryExpression;
import parsingTokens.context.CubexExpression;

public class CubexNegate extends CubexUnaryExpression {
	public CubexNegate(CubexExpression arg) {
		super(arg);
	}
	public String toString(){
		return getmArgument().toString() + " . negate < > ( )";
	}
}