package ir.expressions;

import ir.CGenerationContext;

public class IrUnaryExpression implements IrExpression {
	private IrExpression expression;
	private String operator;

	public IrUnaryExpression(IrExpression expression, String operator) {
		super();
		this.expression = expression;
		this.operator = operator;
	}

	@Override
	public String toC(CGenerationContext context) {
		return operator + " (" + expression.toC(context) + ")";
	}
}