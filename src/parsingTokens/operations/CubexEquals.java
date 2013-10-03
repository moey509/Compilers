package parsingTokens.operations;

import parsingTokens.context.CubexExpression;
import parsingTokens.expressions.CubexBinaryExpression;

public class CubexEquals extends CubexBinaryExpression {
	public CubexEquals(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	public String toString(){
		return getmLeft().toString() + " . equals < > ( " + getmRight().toString() + " )";
	}
}