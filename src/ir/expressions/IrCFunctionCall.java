package ir.expressions;

import ir.CGenerationContext;
import ir.statements.IrBind;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import optimization.CseContext;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public class IrCFunctionCall implements IrExpression {
	private String functionName;
	private ArrayList<String> parameters;
	private ArrayList<String> parameterTypes;
	private CubexTypeGrammar cubexType;
	public ArrayList<String> input = new ArrayList<String>();
	
	public IrCFunctionCall(String fName, ArrayList<String> params, ArrayList<String> parameterTypes) {
		this.functionName = fName;
		this.parameters = params;
		this.parameterTypes = parameterTypes;
		this.cubexType = null;
	}

	@Override
	public CubexTypeGrammar getCubexType() {
		// TODO Auto-generated method stub
		return cubexType;
	}

	@Override
	public String toC(CGenerationContext context) {
		// TODO Auto-generated method stub
		if (!context.objectToDataMap.containsKey(context.currentObject)){
			StringBuilder functionCall = new StringBuilder(functionName + "(");
			for(int i = 0; i < parameters.size(); i++){
				if(i != 0){
					functionCall.append(",");
				}
				String parameterPrefix = "";
				functionCall.append("(" + parameterTypes.get(i) + ") " + parameterPrefix + parameters.get(i));
			}
			functionCall.append(")");
			return functionCall.toString();
		}
		else {
			StringBuilder functionCall = new StringBuilder(functionName + "(");
			for(int i = 0; i < parameters.size(); i++){
				if(i != 0){
					functionCall.append(",");
				}
				String parameterPrefix = (context.objectToDataMap.get(context.currentObject).contains(parameters.get(i))) ? "__struct->" : "";
				functionCall.append("(" + parameterTypes.get(i) + ") " + parameterPrefix + parameters.get(i));
			}
			functionCall.append(")");
			return functionCall.toString();
		}
	}

	@Override
	public ArrayList<IrBind> getExpressions(CGenerationContext context) {
		ArrayList<IrBind> arr = new ArrayList<IrBind>();
		return arr;
	}

	@Override
	public void getVars(Set<String> set, Map<String, Set<String>> map) {
		for (String s : input) {
			set.add(s);
		}
	}	
	
	public String toString() {
		String str = "C-" + functionName + " ( ";
		for (String s : input) {
			str = str + " , " + s;
		}
		return str + " )";
	}
	
	@Override
	public IrExpression eliminateSubexpression(CseContext context) {
		IrExpression expr = getSubexpressions(context);
		if (context.containsExpression(expr)){
			return context.getVariableExpression(expr);
		} else {
			for (String s : parameters){
				if (context.containsVariable(s)){
					s = context.getVariable(context.getExpression(s));
				}
			}
			return this;
		}
	}
	
	public boolean equals(Object object){
		if (object instanceof IrCFunctionCall){
			IrCFunctionCall expr = (IrCFunctionCall) object;
			if (!functionName.equals(expr.functionName)){
				return false;
			}
			Iterator<String> iter1 = parameters.iterator();
			Iterator<String> iter2 = expr.parameters.iterator();
			while (iter1.hasNext() && iter2.hasNext()){
				if (!iter1.next().equals(iter2.next())){
					return false;
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public IrExpression getSubexpressions(CseContext context) {
		IrFunctionCall output = new IrFunctionCall(functionName, cubexType);
		for (int i = 0; i < parameters.size(); i++){
			if (context.containsVariable(parameters.get(i))){
				output.addArgument(parameterTypes.get(i), context.getExpression(parameters.get(i)));
			}
			else {
				output.addArgument(parameterTypes.get(i), new IrVariableExpression(parameters.get(i)));
			}
		}
		return output;
	}
	
	public IrExpression clone(){
		ArrayList<String> newParams = new ArrayList<String>();
		for (String s : parameters){
			newParams.add(new String(s));
		}
		ArrayList<String> newParamTypes = new ArrayList<String>();
		for (String s : parameterTypes){
			newParamTypes.add(new String(s));
		}
		return new IrCFunctionCall(new String(functionName), newParams, newParamTypes);
	}
}
