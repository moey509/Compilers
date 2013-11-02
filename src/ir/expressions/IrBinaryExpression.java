package ir.expressions;

import ir.CGenerationContext;

public class IrBinaryExpression implements IrExpression {
	private IrExpression leftExpression;
	private IrExpression rightExpression;
	private String operator;

	public IrBinaryExpression(IrExpression leftExpression,
			IrExpression rightExpression, String operator) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
		this.operator = operator;
	}

	public String toC(CGenerationContext context) {
		return "(" + leftExpression.toC(context) + ") " + operator + " ("
				+ rightExpression.toC(context) + ")";
	}
}