package ir.expressions;

import ir.expressions.IrExpression;

public class IrVariableExpression implements IrExpression {
	private String variableName;

	public IrVariableExpression(String variableName) {
		this.variableName = variableName;
	}

	@Override
	public String toC() {
		return variableName;
	}

}
