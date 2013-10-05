package parsingTokens.operations;

import parsingTokens.expressions.CubexBinaryExpression;
import parsingTokens.expressions.CubexExpression;

public class CubexEquals extends CubexBinaryExpression {
	public CubexEquals(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	public String toString(){
		return getmLeft().toString() + " . equals < > ( " + getmRight().toString() + " )";
	}
}