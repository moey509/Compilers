package parsingTokens.operations;

import parsingTokens.context.CubexExpression;
import parsingTokens.expressions.CubexBinaryExpression;

public class CubexMultiply extends CubexBinaryExpression {
	public CubexMultiply(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	public String toString(){
		return getmLeft().toString() + " . times < > ( " + getmRight().toString() + " )";
	}
}