package ir.operations;

import ir.expressions.IrBinaryExpression;
import ir.expressions.IrExpression;


public class IrAdd extends IrBinaryExpression {
	IrExpression function;
	
	public IrAdd(IrExpression left, IrExpression right) {
		super(left, right);
	}
	
	public String toC() {
		return null;
	}
}