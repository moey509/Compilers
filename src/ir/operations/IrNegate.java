package ir.operations;

import ir.expressions.IrExpression;
import ir.expressions.IrUnaryExpression;


public class IrNegate extends IrUnaryExpression {
	IrExpression function;
	public IrNegate(IrExpression arg) {
		super(arg);
	}
	
	public String toC() {
		return "!" + getmArgument().toC();
	}
}