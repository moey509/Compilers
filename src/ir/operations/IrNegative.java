package ir.operations;

import ir.expressions.IrExpression;
import ir.expressions.IrUnaryExpression;


public class IrNegative extends IrUnaryExpression {
	IrExpression function;

	public IrNegative(IrExpression arg) {
		super(arg);
	}
	
	public String toC() {
		return "!" + getmArgument().toC();
	}
}