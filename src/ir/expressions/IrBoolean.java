package ir.expressions;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import optimization.CseContext;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import ir.CGenerationContext;
import ir.IrMiscFunctions;
import ir.statements.IrBind;

public final class IrBoolean implements IrExpression {
	private boolean mValue;
	private String cType;

	public IrBoolean(boolean value) {
		mValue = value;
		cType = IrMiscFunctions.BOOLEAN;
	}
	
	public String getCType() {
		return cType;
	}

	public String toC(CGenerationContext context) {
		return mValue ? "new_integer(1)" : "new_integer(0)";
	}

	@Override
	public ArrayList<IrBind> getExpressions(CGenerationContext context) {
		// TODO Auto-generated method stub
		return new ArrayList<IrBind>();
	}

	@Override
	public CubexTypeGrammar getCubexType() {
		return new CubexTypeClass("Boolean", new CubexList<CubexTypeGrammar>());
	}
	
	public String toString(){
		return mValue ? "true" : "false";
	}
	
	@Override
	public void getVars(Set<String> set, Map<String, Set<String>> map){
		return;
	}

	public boolean equals(Object object){
		if (object instanceof IrBoolean){
			IrBoolean expr = (IrBoolean) object;
			return mValue == expr.mValue;
		}
		else {
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
			return context.getVariableExpression(expr);
		} else {
			return this;
		}
	}

	@Override
	public IrExpression getSubexpressions(CseContext context) {
		return new IrBoolean(mValue);
	}
}
