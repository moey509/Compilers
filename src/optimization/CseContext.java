package optimization;


import ir.expressions.IrExpression;
import ir.expressions.IrVariableExpression;
import ir.statements.IrBind;
import ir.statements.IrFor;
import ir.statements.IrIf;
import ir.statements.IrStatement;
import ir.statements.IrStatementList;
import ir.statements.IrWhile;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class CseContext {
	private Map<String, IrExpression> variableToExpressionMap;
	private Map<IrExpression, String> expressionToVariableMap;
	private Set<String> unknownVariables;


	public CseContext() {
		variableToExpressionMap = new HashMap<String, IrExpression>();
		expressionToVariableMap = new HashMap<IrExpression, String>();
		unknownVariables = new HashSet<String>();
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
		return new IrVariableExpression(name, expr.getCubexType());
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
	
	public boolean containsUnknownVariable(String variable){
		return unknownVariables.contains(variable);
	}
	
	public CseContext clone(){
		CseContext output = new CseContext();
		
		
		for (Map.Entry<String, IrExpression> entry : variableToExpressionMap.entrySet()){
			output.variableToExpressionMap.put(new String(entry.getKey()), entry.getValue().clone());
		}
		for (Map.Entry<IrExpression, String> entry : expressionToVariableMap.entrySet()){
			output.expressionToVariableMap.put(entry.getKey().clone(), new String(entry.getValue()));
		}
		for (String s : unknownVariables){
			output.unknownVariables.add(s);
		}

		return output;
	}
	
	public void setContext(CseContext setContext){
		variableToExpressionMap = setContext.variableToExpressionMap;
		expressionToVariableMap = setContext.expressionToVariableMap;
		unknownVariables = setContext.unknownVariables;
	}
	
	public CseContext merge(CseContext mergedContext){
		CseContext output = new CseContext();
		
		for (Map.Entry<String, IrExpression> entry : variableToExpressionMap.entrySet()){
			if (mergedContext.containsVariable(entry.getKey())){
				if (entry.getValue().equals(mergedContext.getExpression(entry.getKey()))){
					output.putVariable(entry.getKey(), entry.getValue());
				}
				else{
					output.putVariable(entry.getKey(), new IrVariableExpression(entry.getKey(), entry.getValue().getCubexType()));
				}
			}
		}
		for (String s : unknownVariables){
			output.unknownVariables.add(s);
		}
		for (String s : mergedContext.unknownVariables){
			if (!output.unknownVariables.contains(s))
				output.unknownVariables.add(s);
		}
		
		return output;
	}
	
	public void stripBinds(List<IrStatement> lst){
		
		for (IrStatement stmt : lst){
			if (stmt instanceof IrBind){
				IrBind bind = (IrBind) stmt;
				if (variableToExpressionMap.containsKey(bind.getVariableName())){
					IrExpression expr = variableToExpressionMap.get(bind.getVariableName());
					unknownVariables.add(bind.getVariableName());
					putVariable(bind.getVariableName(), new IrVariableExpression(bind.getVariableName(), expr.getCubexType()));
				}
			}
			if (stmt instanceof IrStatementList){
				IrStatementList stmtList = (IrStatementList) stmt;
				stripBinds(stmtList.statementList);
			}
			if (stmt instanceof IrIf){
				IrIf st = (IrIf) stmt;
				stripBinds(st.getAllStatements());
			}
			if (stmt instanceof IrWhile){
				IrWhile st = (IrWhile) stmt;
				stripBinds(st.getAllStatements());
			}
			if (stmt instanceof IrFor){
				IrFor st = (IrFor) stmt;
				stripBinds(st.getAllStatements());
			}
		}
	}
	
	public void printContext(){
		System.out.println("------------");
		System.out.println("CseContext:");
		for (Map.Entry<String, IrExpression> entry : variableToExpressionMap.entrySet()){
			System.out.println(entry.getKey() + " => " + entry.getValue().toString());
		}
//		System.out.println(variableToExpressionMap.toString());
//		System.out.println(expressionToVariableMap.toString());
		System.out.println(unknownVariables.toString());
		System.out.println("------------");
	}
}
