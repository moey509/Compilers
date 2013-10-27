package ir.operations;

import ir.expressions.IrBinaryExpression;
import ir.expressions.IrExpression;


public class IrMultiply extends IrBinaryExpression {
	IrExpression function;

	public IrMultiply(IrExpression left, IrExpression right) {
		super(left, right);
	}
	
	public String toC() {
		return null;
	}
}