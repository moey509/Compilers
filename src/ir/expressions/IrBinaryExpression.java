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
	
	public String getOperator() {
		return this.operator;
	}
	
	public IrExpression getLeftExpression() {
		return this.leftExpression;
	}
	
	public IrExpression getRightExpression() {
		return this.rightExpression;
	}


	public String toC(CGenerationContext context) {
		return null;
	}
}