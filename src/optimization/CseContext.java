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
		variableToExpressionMap.put(variable, expr);
		expressionToVariableMap.put(expr, variable);
	}
	
	public void redefineVariable(String variable, IrExpression expr){
		expressionToVariableMap.remove(expr);
		variableToExpressionMap.remove(variable);

		expressionToVariableMap.put(expr, variable);
		variableToExpressionMap.put(variable, expr);
	}
	
	public String getVariable(IrExpression expr){
		return expressionToVariableMap.get(expr);
	}
	
	public IrExpression getExpression(String variable){
		return variableToExpressionMap.get(variable);
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
	
	public CseContext merge(CseContext context){
		CseContext newContext = new CseContext();
		
		for (Map.Entry<String, IrExpression> entry : variableToExpressionMap.entrySet()){
			if (context.containsVariable(entry.getKey())){
				if (entry.getValue().equals(context.getExpression(entry.getKey()))){
					newContext.putVariable(entry.getKey(), entry.getValue());
				}
				else{
					newContext.putVariable(entry.getKey(), 
							new IrVariableExpression(entry.getKey(), entry.getValue().getCType(), 
									entry.getValue().getCubexType()));
				}
			}
		}	
		return newContext;
	}
}
