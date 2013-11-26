package optimization;


import ir.expressions.IrExpression;
import ir.expressions.IrVariableExpression;
import ir.statements.IrBind;
import ir.statements.IrStatement;
import ir.statements.IrStatementList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CseContext {
	private Map<String, IrExpression> variableToExpressionMap;
	private Map<IrExpression, String> expressionToVariableMap;


	public CseContext() {
		variableToExpressionMap = new HashMap<String, IrExpression>();
		expressionToVariableMap = new HashMap<IrExpression, String>();
	}
	
	
	public void putVariable(String variable, IrExpression expr){
		if (variableToExpressionMap.containsKey(variable)){
			IrExpression oldExpr = variableToExpressionMap.get(variable);
			if (expressionToVariableMap.get(oldExpr).equals(variable)){
				
				for (Map.Entry<String, IrExpression> entry : variableToExpressionMap.entrySet()){
					if (entry.getValue().equals(oldExpr)){
						expressionToVariableMap.put(oldExpr, entry.getKey());
					}
				}
			}
		}
		if (!expressionToVariableMap.containsKey(expr))
			expressionToVariableMap.put(expr, variable);
		variableToExpressionMap.put(variable, expr);
	}
	
	public String getVariable(IrExpression expr){
		return expressionToVariableMap.get(expr);
	}
	
	public IrVariableExpression getVariableExpression(IrExpression expr){
		String name = expressionToVariableMap.get(expr);
//		System.out.println(expr);
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
	
	public CseContext clone(){
		CseContext output = new CseContext();
		
		for (Map.Entry<String, IrExpression> entry : variableToExpressionMap.entrySet()){
			output.variableToExpressionMap.put(new String(entry.getKey()), entry.getValue().clone());
		}
		for (Map.Entry<IrExpression, String> entry : expressionToVariableMap.entrySet()){
			output.expressionToVariableMap.put(entry.getKey().clone(), new String(entry.getValue()));
		}
		
		return output;
	}
	
	public void setContext(CseContext setContext){
		variableToExpressionMap = setContext.variableToExpressionMap;
		expressionToVariableMap = setContext.expressionToVariableMap;
	}
	
	public CseContext merge(CseContext mergedContext){
		CseContext output = new CseContext();
		
		for (Map.Entry<String, IrExpression> entry : variableToExpressionMap.entrySet()){
			if (mergedContext.containsVariable(entry.getKey())){
				if (entry.getValue().equals(mergedContext.getExpression(entry.getKey()))){
					output.putVariable(entry.getKey(), entry.getValue());
				}
				else{
					output.putVariable(entry.getKey(),
							new IrVariableExpression(entry.getKey(), entry.getValue().getCType(), 
									entry.getValue().getCubexType()));
				}
			}
		}
		for (Map.Entry<IrExpression, String> entry : expressionToVariableMap.entrySet()){
			
		}
		return output;
	}
	
	public void stripBinds(List<IrStatement> lst){
		
		for (IrStatement stmt : lst){
			if (stmt instanceof IrStatementList){
				IrStatementList stmtList = (IrStatementList) stmt;
				stripBinds(stmtList.statementList);
			}
			if (stmt instanceof IrBind){
				IrBind bind = (IrBind) stmt;
				if (variableToExpressionMap.containsKey(bind.getVariableName())){
					IrExpression expr = variableToExpressionMap.get(bind.getVariableName());
					putVariable(bind.getVariableName(), new IrVariableExpression(bind.getVariableName(), expr.getCType(), expr.getCubexType()));
				}
			}
		}
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
