package ir.expressions;

import ir.CGenerationContext;
import ir.statements.IrBind;

import java.util.ArrayList;

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
				System.out.println("IrCFunctionCall: " + parameterTypes.get(i));
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
				System.out.println("IrCFunctionCall: " + parameterTypes.get(i));
				functionCall.append("(" + parameterTypes.get(i) + ") " + parameterPrefix + parameters.get(i));
			}
			functionCall.append(")");
			return functionCall.toString();
		}
	}

	@Override
	public ArrayList<IrBind> getExpressions(CGenerationContext context) {
		// TODO Auto-generated method stub
		ArrayList<IrBind> arr = new ArrayList<IrBind>();
		//arr.add(null);
		return arr;
	}

	//TODO: MATT FILL THESE IN
	@Override
	public IrExpression eliminateSubexpression(CseContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IrExpression getSubexpressions(CseContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
