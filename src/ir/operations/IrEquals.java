package ir.operations;

import ir.expressions.IrBinaryExpression;
import ir.expressions.IrExpression;


public class IrEquals extends IrBinaryExpression {
	IrExpression function;
	public IrEquals(IrExpression left, IrExpression right) {
		super(left, right);
	}
	
	public String toC() {
		return null;
	}
}