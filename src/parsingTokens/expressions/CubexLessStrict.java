package parsingTokens.expressions;

import parsingTokens.context.CubexExpression;

public class CubexLessStrict extends CubexBinaryExpression {
	public CubexLessStrict(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	public String toString(){
		return getmLeft().toString() + " . lessThan < > ( " + getmRight().toString() + " , true )";
	}
}