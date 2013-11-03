package ir.expressions;

import ir.CGenerationContext;
import ir.expressions.IrExpression;


//TODO: currently the type of variables are not clear....


public class IrVariableExpression implements IrExpression {
	private String variableName;
	private String type;

	public IrVariableExpression(String variableName, String type) {
		this.variableName = variableName;
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	@Override
	public String toC(CGenerationContext context) {
		return variableName;
	}

}
