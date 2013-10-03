package parsingTokens.operations;

import parsingTokens.context.CubexExpression;
import parsingTokens.expressions.CubexBinaryExpression;

public class CubexDivide extends CubexBinaryExpression {
	public CubexDivide(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	
	public String toString(){
		return getmLeft().toString() + " . divide < > ( " + getmRight().toString() + " )";
	}
}