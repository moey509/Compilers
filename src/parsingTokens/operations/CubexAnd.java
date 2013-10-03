package parsingTokens.operations;

import parsingTokens.context.CubexExpression;
import parsingTokens.expressions.CubexBinaryExpression;

public class CubexAnd extends CubexBinaryExpression {
	public CubexAnd(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	
	public String toString(){
		return getmLeft().toString() + " . and < > ( " + getmRight().toString() + " )";
	}
}