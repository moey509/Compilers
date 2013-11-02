package ir.statements;

import java.util.ArrayList;

import ir.CGenerationContext;
import ir.expressions.IrExpression;
import ir.program.IrTypeTuple;

public final class IrBind implements IrStatement {
	private IrTypeTuple tuple;
	private IrExpression expression;

	public IrBind(IrTypeTuple tuple, IrExpression expression) {
		this.tuple = tuple;
		this.expression = expression;
		System.out.println();
	}

	@Override
	public ArrayList<String> toC(CGenerationContext context) {
		ArrayList<String> output = new ArrayList<String>();
		output.add(tuple.type.toC() + " " + tuple.variableName + " = " + expression.toC(context) + ";");
		return output;
	}

}