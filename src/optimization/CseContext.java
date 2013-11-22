package optimization;


import ir.expressions.IrExpression;

import java.util.HashMap;
import java.util.Map;


public class CseContext {
	private Map<String, IrExpression> variableToExpressionMap;
	private Map<IrExpression, String> expressionToVariableMap;

	public CseContext() {
		variableToExpressionMap = new HashMap<String, IrExpression>();
		expressionToVariableMap = new HashMap<IrExpression, String>();
	}
	
	public void put(String variable, IrExpression expr){
		variableToExpressionMap.put(variable, expr);
		expressionToVariableMap.put(expr, variable);
	}
	
	public String getVariable(IrExpression expr){
		return expressionToVariableMap.get(expr);
	}
	
	public IrExpression getExpression(String variable){
		return variableToExpressionMap.get(variable);
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
			if (context.getExpression(entry.getKey()).equals(entry.getValue())){
				newContext.put(entry.getKey(), entry.getValue());
			}
		}	
		return newContext;
	}
}
