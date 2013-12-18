package ir.expressions;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

import optimization.CseContext;
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
	
	public IrExpression clone() {
		return new IrVariableExpression(new String(variableName), new String(cType), cubexType);
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
		ArrayList<IrBind> arr = new ArrayList<IrBind>();
		return arr;
	}

	@Override
	public CubexTypeGrammar getCubexType() {
		return cubexType;
	}

	public String toString(){
		return variableName;
	}

	@Override
	public void getVars(Set<String> set, Map<String, Set<String>> map) {
		set.add(variableName);
	}
	
	public boolean equals(Object object){
		if (object instanceof IrVariableExpression){
			IrVariableExpression expr = (IrVariableExpression) object;
			return variableName.equals(expr.variableName);
		}
		else{
			return false;
		}
	}
	
	public int hashCode(){
		return toString().hashCode();
	}

	@Override
	public IrExpression eliminateSubexpression(CseContext context) {
		IrExpression expr = getSubexpressions(context);
		if (context.containsExpression(expr)){
			if (context.containsUnknownVariable(variableName)){
				return this;
			} else {
				return context.getVariableExpression(expr);
			}
		} else {
			return this;
		}
	}

	@Override
	public IrExpression getSubexpressions(CseContext context) {
		if (context.containsVariable(variableName))
			return context.getExpression(variableName);
		else return this;
	}
}
