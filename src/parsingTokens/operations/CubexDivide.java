package parsingTokens.operations;

import parsingTokens.expressions.CubexBinaryExpression;
import parsingTokens.expressions.CubexExpression;

public class CubexDivide extends CubexBinaryExpression {
	public CubexDivide(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	
	public String toString(){
		return getmLeft().toString() + " . divide < > ( " + getmRight().toString() + " )";
	}
}