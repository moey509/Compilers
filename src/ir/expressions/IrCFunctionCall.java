package ir.expressions;

import ir.CGenerationContext;
import ir.statements.IrBind;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import optimization.CseContext;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public class IrCFunctionCall implements IrExpression {
	private String functionName;
	private String cType;
	private ArrayList<String> parameters;
	private ArrayList<String> parameterTypes;
	private CubexTypeGrammar cubexType;
	
	public IrCFunctionCall(String fName, ArrayList<String> params, ArrayList<String> parameterTypes, String cType) {
		this.functionName = fName;
		this.parameters = params;
		this.cType = cType;
		this.parameterTypes = parameterTypes;
		this.cubexType = null;
	}

	@Override
	public String getCType() {
		// TODO Auto-generated method stub
		return cType;
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

	@Override
	public IrExpression getSubexpressions(CseContext context) {
		IrFunctionCall output = new IrFunctionCall(functionName, cType, cubexType);
		for (int i = 0; i < parameters.size(); i++){
			if (context.containsVariable(parameters.get(i))){
				output.addArgument(parameterTypes.get(i), context.getExpression(parameters.get(i)));
			}
			else {
				output.addArgument(parameterTypes.get(i), new IrVariableExpression(parameters.get(i), parameterTypes.get(i)));
			}
		}
		return output;
	}

	@Override
	public void getVars(Set<String> set, Map<String, Set<String>> map) {
		return; //nothing here needed since they are not variables
	}	
}
