package ir.expressions;

import ir.CGenerationContext;

import java.util.ArrayList;
import java.util.List;


public final class IrFunctionCall implements IrExpression {
	private String functionName;
	private List<IrExpression> arguments;
	private String type;
	
	public IrFunctionCall(String functionName, String type) {
		this.functionName = functionName;
		this.arguments = new ArrayList<IrExpression>();
		this.type = type;
	}

	public void addArgument(IrExpression argument){
		this.arguments.add(argument);
	}

	public String getType () {
		return type;
	}

	public String toC(CGenerationContext context) {
		boolean firstTime = true;
		StringBuilder sb = new StringBuilder();
		for (IrExpression e : arguments){
			if(firstTime){
				firstTime = false;
				sb.append(e.toC(context));
			}
			else{
				sb.append(", " + e.toC(context));
			}
		}
		return functionName + "(" + sb.toString() + ")" ;
	}
}