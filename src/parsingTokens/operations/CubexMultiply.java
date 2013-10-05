package parsingTokens.operations;

import parsingTokens.expressions.CubexBinaryExpression;
import parsingTokens.expressions.CubexExpression;

public class CubexMultiply extends CubexBinaryExpression {
	public CubexMultiply(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	public String toString(){
		return getmLeft().toString() + " . times < > ( " + getmRight().toString() + " )";
	}
}