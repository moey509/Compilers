package ir.expressions;

import java.util.ArrayList;
import java.util.List;


public final class IrFunctionCall implements IrExpression {
	private String functionName;
	private List<IrExpression> arguments;
	
	public IrFunctionCall(String functionName) {
		this.functionName = functionName;
		this.arguments = new ArrayList<IrExpression>();
	}

	public void addArgument(IrExpression argument){
		this.arguments.add(argument);
	}


	public String toC() {
		boolean firstTime = true;
		StringBuilder sb = new StringBuilder();
		for (IrExpression e : arguments){
			if(firstTime){
				firstTime = false;
				sb.append(e.toC());
			}
			else{
				sb.append(", " + e.toC());
			}
		}
		return functionName + "(" + sb.toString() + ")" ;
	}
}