package ir.expressions;

import ir.IrType;

public class IrExpressionTuple{
	IrType argType;
	public IrExpression expression;
	public IrExpressionTuple(IrType argType, IrExpression expression) {
		//System.out.println("IR: " + argType.type + " " + expression.toString());
		this.argType = argType;
		this.expression = expression;
	}
	public IrType getArgType() {
		return argType;
	}
	public IrExpression getExpression() {
		return expression;
	}	
}
