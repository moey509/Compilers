package ir.expressions;

import ir.CGenerationContext;
import ir.IrType;
import ir.statements.IrBind;

import java.util.ArrayList;
import java.util.List;


public final class IrFunctionCall implements IrExpression {
	private String functionName;	
	private List<IrExpressionTuple> arguments;
	private String type;	
	
	public ArrayList<IrExpression> functions = new ArrayList<IrExpression>();
	
	public IrFunctionCall(String functionName, String type) {
		this.functionName = functionName;
		this.arguments = new ArrayList<IrExpressionTuple>();
		this.type = type;
	}

	public void addArgument(IrType argType, IrExpression argument){
		this.arguments.add(new IrExpressionTuple(argType, argument));
	}
	
	public void addArgument(String argType, IrExpression argument){
		this.arguments.add(new IrExpressionTuple(new IrType(argType), argument));
	}

	public String getType () {
		return type;
	}
	
	public ArrayList<IrBind> getExpressions(CGenerationContext context){
		ArrayList<IrBind> arr = new ArrayList<IrBind>();
		for(IrExpressionTuple tuple : arguments){
			arr.addAll(tuple.expression.getExpressions(context));
		}
		return arr;
	}
	
	public String toC(CGenerationContext context) {
		boolean firstTime = true;
		StringBuilder sb = new StringBuilder();
		ArrayList<IrBind> arr = getExpressions(context);
		for(int i = 0; i < arr.size(); i++){
			if(arr.get(i) != null){
				//System.out.println(arr.get(i).toC(context));
			}
		}
		for (IrExpressionTuple tuple : arguments){
			if(firstTime){
				firstTime = false;
				sb.append(tuple.expression.toC(context));
			}
			else{
				sb.append(", " + tuple.expression.toC(context));
			}
		}
		
		return functionName + "(" + sb.toString() + ")" ;
	}
}

class IrExpressionTuple{
	IrType argType;
	IrExpression expression;
	public IrExpressionTuple(IrType argType, IrExpression expression) {
		this.argType = argType;
		this.expression = expression;
	}	
}
