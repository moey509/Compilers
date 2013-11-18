package ir.expressions;

import java.util.ArrayList;

import parsingTokens.typeGrammar.CubexTypeGrammar;
import ir.CGenerationContext;
import ir.expressions.IrExpression;
import ir.statements.IrBind;


//TODO: currently the type of variables are not clear....


public class IrVariableExpression implements IrExpression {
	private String variableName;
	private String cType;
	private CubexTypeGrammar cubexType;
	
	public IrVariableExpression(String variableName, String cType) {
		this.variableName = variableName;
		this.cType = cType;
		this.cubexType = null;
	}

	public IrVariableExpression(String variableName, String cType, CubexTypeGrammar cubexType) {
		this.variableName = variableName;
		this.cType = cType;
		this.cubexType = cubexType;
	}
	
	public String getCType() {
		return cType;
	}

	@Override
	public String toC(CGenerationContext context) {
		if (!context.objectToDataMap.containsKey(context.currentObject)){
			if (variableName.equals("input"))
				return "_input";
			return variableName;
		}
		else {
			if (context.objectToDataMap.get(context.currentObject).contains(variableName)){
				return "__struct->" + variableName;
			}
			else return variableName;
		}
	}

	@Override
	public ArrayList<IrBind> getExpressions(CGenerationContext context) {
		// TODO Auto-generated method stub
		ArrayList<IrBind> arr = new ArrayList<IrBind>();
		//arr.add(null);
		return arr;
	}

	@Override
	public CubexTypeGrammar getCubexType() {
		return cubexType;
	}

}
