package ir.operations;

import parsingTokens.expressions.CubexBinaryExpression;
import parsingTokens.expressions.CubexExpression;

public class IrSubtract extends CubexBinaryExpression {
	CubexExpression function;
	
	public IrSubtract(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	
	public String toC() {
		return null;
	}
}