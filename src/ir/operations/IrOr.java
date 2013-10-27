package ir.operations;

import ir.expressions.IrBinaryExpression;
import ir.expressions.IrExpression;


public class IrOr extends IrBinaryExpression {
	IrExpression function;
	
	public IrOr(IrExpression left, IrExpression right) {
		super(left, right);
	}
	
	public String toC() {
		return null;
	}
}