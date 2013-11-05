package ir.expressions;

import java.util.ArrayList;

import ir.CGenerationContext;
import ir.expressions.IrExpression;
import ir.statements.IrBind;


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

	@Override
	public ArrayList<IrBind> getExpressions(CGenerationContext context) {
		// TODO Auto-generated method stub
		ArrayList<IrBind> arr = new ArrayList<IrBind>();
		//arr.add(null);
		return arr;
	}

}
