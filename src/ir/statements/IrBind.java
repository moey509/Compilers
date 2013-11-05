package ir.statements;

import java.util.ArrayList;

import ir.CGenerationContext;
import ir.expressions.IrExpression;
import ir.program.IrTypeTuple;

public final class IrBind implements IrStatement {
	public IrTypeTuple tuple;
	public IrExpression expression;
	public ArrayList<IrBind> temporaryBinds;

	public IrBind(IrTypeTuple tuple, IrExpression expression) {
		this.tuple = tuple;
		this.expression = expression;
		this.temporaryBinds = new ArrayList<IrBind>();
	}

	@Override
	public ArrayList<String> toC(CGenerationContext context) {
		ArrayList<String> output = new ArrayList<String>();
		//output.add(tuple.type.toC() + " " + tuple.variableName + " = " + expression.toC(context) + ";");
		for(IrBind b : temporaryBinds){
			output.addAll(b.toC(context));
		}
		if(temporaryBinds.size() > 0){
			String s = temporaryBinds.get(temporaryBinds.size()-1).tuple.variableName;
			output.add(tuple.variableName + " = " + s + ";");
		}
		else{
			output.add(tuple.variableName + " = " + expression.toC(context) + ";");
		}
		return output;
	}

	@Override
	public ArrayList<String> toMainC(CGenerationContext context) {
		return toC(context);
	}

}