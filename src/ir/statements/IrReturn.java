package ir.statements;

import java.util.ArrayList;
import ir.expressions.IrExpression;

public final class IrReturn implements IrStatement {
	private IrExpression expression;
	
	public IrReturn(IrExpression expression) {
		this.expression = expression;
	}

	@Override
	public ArrayList<String> toC() {
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("return " + expression.toC() + ";");
		return arrList;
	}

}

