package optimization;


import ir.expressions.IrExpression;
import ir.expressions.IrVariableExpression;

import java.util.HashMap;
import java.util.Map;


public class CseContext {
	private Map<String, IrExpression> variableToExpressionMap;
	private Map<IrExpression, String> expressionToVariableMap;

	public CseContext() {
		variableToExpressionMap = new HashMap<String, IrExpression>();
		expressionToVariableMap = new HashMap<IrExpression, String>();
	}
	
	public void putVariable(String variable, IrExpression expr){
		if (!expressionToVariableMap.containsKey(expr))
			expressionToVariableMap.put(expr, variable);
		variableToExpressionMap.put(variable, expr);
	}
	
	public String getVariable(IrExpression expr){
		return expressionToVariableMap.get(expr);
	}
	
	public IrVariableExpression getVariableExpression(IrExpression expr){
		String name = expressionToVariableMap.get(expr);
		return new IrVariableExpression(name, expr.getCType(), expr.getCubexType());
	}
	
	public IrExpression getExpression(String variable){
		return variableToExpressionMap.get(variable);
	}
	
	public boolean containsExpression(IrExpression expr){
		return expressionToVariableMap.containsKey(expr);
	}
	
	public boolean containsVariable(String variable){
		return variableToExpressionMap.containsKey(variable);
	}
	
	public void remove(String variable){
		expressionToVariableMap.remove(variableToExpressionMap.remove(variable));
	}
	
	public void remove(IrExpression expr){
		variableToExpressionMap.remove(expressionToVariableMap.remove(expr));
	}
	
	public CseContext clone(){
		CseContext output = new CseContext();
		
		for (Map.Entry<String, IrExpression> entry : variableToExpressionMap.entrySet()){
			output.putVariable(entry.getKey(), entry.getValue());
		}
		
		return output;
	}
	

	
	public CseContext merge(CseContext context){
		CseContext output = new CseContext();
		
		for (Map.Entry<String, IrExpression> entry : variableToExpressionMap.entrySet()){
			if (context.containsVariable(entry.getKey())){
				if (entry.getValue().equals(context.getExpression(entry.getKey()))){
					output.putVariable(entry.getKey(), entry.getValue());
				}
				else{
					output.putVariable(entry.getKey(), 
							new IrVariableExpression(entry.getKey(), entry.getValue().getCType(), 
									entry.getValue().getCubexType()));
				}
			}
		}	
		return output;
	}
	
	public void printContext(){
		System.out.println("------------");
		System.out.println("CseContext:");
		for (Map.Entry<String, IrExpression> entry : variableToExpressionMap.entrySet()){
			System.out.println(entry.getKey() + " => " + entry.getValue().toString());
		}
		System.out.println(variableToExpressionMap.toString());
		System.out.println(expressionToVariableMap.toString());
		System.out.println("------------");
	}
}
