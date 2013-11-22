package optimization;


import java.util.HashMap;
import java.util.Map;

import parsingTokens.expressions.CubexExpression;

public class CseContext {
	private Map<String, CubexExpression> variableToExpressionMap;
	private Map<CubexExpression, String> expressionToVariableMap;

	public CseContext() {
		variableToExpressionMap = new HashMap<String, CubexExpression>();
		expressionToVariableMap = new HashMap<CubexExpression, String>();
	}
	
	public void put(String variable, CubexExpression expr){
		variableToExpressionMap.put(variable, expr);
		expressionToVariableMap.put(expr, variable);
	}
	
	public String getVariable(CubexExpression expr){
		return expressionToVariableMap.get(expr);
	}
	
	public CubexExpression getExpression(String variable){
		return variableToExpressionMap.get(variable);
	}
	
	public void remove(String variable){
		expressionToVariableMap.remove(variableToExpressionMap.remove(variable));
	}
	
	public void remove(CubexExpression expr){
		variableToExpressionMap.remove(expressionToVariableMap.remove(expr));
	}
	
	public CseContext merge(CseContext context){
		CseContext newContext = new CseContext();
		
		for (Map.Entry<String, CubexExpression> entry : variableToExpressionMap.entrySet()){
			if (context.getExpression(entry.getKey()).equals(entry.getValue())){
				newContext.put(entry.getKey(), entry.getValue());
			}
		}	
		return newContext;
	}
}
