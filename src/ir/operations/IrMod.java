package ir.operations;

import ir.expressions.IrBinaryExpression;
import ir.expressions.IrExpression;

public class IrMod extends IrBinaryExpression {
	IrExpression function;
	public IrMod(IrExpression left, IrExpression right) {
		super(left, right);
	}
	
	public String toC() {
		return null;
	}
}