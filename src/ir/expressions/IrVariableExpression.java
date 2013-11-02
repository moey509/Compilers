package ir.expressions;

import ir.CGenerationContext;
import ir.expressions.IrExpression;

public class IrVariableExpression implements IrExpression {
	private String variableName;

	public IrVariableExpression(String variableName) {
		this.variableName = variableName;
	}

	@Override
	public String toC(CGenerationContext context) {
		return variableName;
	}

}
