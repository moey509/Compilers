package ir.statements;

import java.util.ArrayList;

import ir.expressions.IrExpression;

public final class IrBind implements IrStatement {
	private String variable;
	private IrExpression expression;

	public IrBind(String variable, IrExpression expression) {
		this.variable = variable;
		this.expression = expression;
	}

	@Override
	public ArrayList<String> toC() {
		ArrayList<String> output = new ArrayList<String>();
		output.add(variable + " = " + expression.toC());
		return output;
	}

}