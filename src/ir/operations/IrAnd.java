package ir.operations;

import ir.expressions.IrBinaryExpression;
import ir.expressions.IrExpression;


public class IrAnd extends IrBinaryExpression {
	IrExpression function;
	
	public IrAnd(IrExpression left, IrExpression right) {
		super(left, right);
	}
	
	public String toC() {
		return getmLeft().toC() + " && " + getmRight().toC();
	}
}