package ir.operations;

import ir.expressions.IrBinaryExpression;
import ir.expressions.IrExpression;


public class IrDivide extends IrBinaryExpression {
	IrExpression function;
	public IrDivide(IrExpression left, IrExpression right) {
		super(left, right);
	}
	
	public String toC() {
		return getmLeft().toC() + " / " + getmRight().toC();
	}
}