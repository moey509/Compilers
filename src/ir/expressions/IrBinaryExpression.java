package ir.expressions;

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

	public String toC() {
		return "(" + leftExpression.toC() + ") " + operator + " ("
				+ rightExpression.toC() + ")";
	}
}