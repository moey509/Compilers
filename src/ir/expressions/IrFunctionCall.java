package ir.expressions;

import ir.CGenerationContext;
import ir.statements.IrBind;

import java.util.ArrayList;
import java.util.List;


public final class IrFunctionCall implements IrExpression {
	private String functionName;
	private List<IrExpression> arguments;
	private String type;
	public ArrayList<IrExpression> functions = new ArrayList<IrExpression>();
	
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
	
	public ArrayList<IrBind> getExpressions(CGenerationContext context){
		ArrayList<IrBind> arr = new ArrayList<IrBind>();
		for(IrExpression e : arguments){
			arr.addAll(e.getExpressions(context));
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
		for(IrExpression e :functions){
			System.out.println("FUNCTIONS THAT I JUST ADDED" + e.toC(context));
		}
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