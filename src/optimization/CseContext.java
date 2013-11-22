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
}
