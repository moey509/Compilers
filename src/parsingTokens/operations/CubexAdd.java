package parsingTokens.operations;

import parsingTokens.context.CubexExpression;
import parsingTokens.expressions.CubexBinaryExpression;

public class CubexAdd extends CubexBinaryExpression {
	public CubexAdd(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	
	public String toString(){
		return getmLeft().toString() + " . plus < > ( " + getmRight().toString() + " )";
	}
}