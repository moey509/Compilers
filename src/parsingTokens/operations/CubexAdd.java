package parsingTokens.operations;

import parsingTokens.expressions.CubexBinaryExpression;
import parsingTokens.expressions.CubexExpression;

public class CubexAdd extends CubexBinaryExpression {
	public CubexAdd(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	
	public String toString(){
		return getmLeft().toString() + " . plus < > ( " + getmRight().toString() + " )";
	}
}