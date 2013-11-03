package ir.statements;

import java.util.ArrayList;

import ir.CGenerationContext;
import ir.expressions.IrExpression;

public final class IrReturn implements IrStatement {
	private IrExpression expression;
	
	public IrReturn(IrExpression expression) {
		this.expression = expression;
	}

	@Override
	public ArrayList<String> toC(CGenerationContext context) {
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("return " + expression.toC(context) + ";");
		return arrList;
	}

}

