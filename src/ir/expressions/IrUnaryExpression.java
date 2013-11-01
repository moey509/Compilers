package ir.expressions;

public class IrUnaryExpression implements IrExpression {
	private IrExpression expression;
	private String operator;

	public IrUnaryExpression(IrExpression expression, String operator) {
		super();
		this.expression = expression;
		this.operator = operator;
	}

	@Override
	public String toC() {
		return operator + " (" + expression.toC() + ")";
	}
}