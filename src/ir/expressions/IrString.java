package ir.expressions;

import ir.CGenerationContext;
import ir.IrMiscFunctions;
import ir.statements.IrBind;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import optimization.CseContext;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public final class IrString implements IrExpression {
	private String mValue;
	private String cType;

	public IrString(String value) {
		mValue = value;
		this.cType = IrMiscFunctions.STRING;
	}
	
	public String getCType() {
		return this.cType;
	}
	
	public IrString clone () {
		return new IrString(new String(mValue));
	}
	
	public String helper(int index, CGenerationContext context) {
		if (index == mValue.length() - 2){
			return ("iterable_append(new_git_obj(new_character(charuni('" + mValue.charAt(index) + "'))), NULL)");
		}
		return ("iterable_append(new_git_obj(new_character(charuni('" + mValue.charAt(index) + "'))), " + helper(index+1, context) + ")");
	}
	
	// NOTE: STRINGS SHOULD BE CONVERTED INTO ITERABLES OF CHARS
	public String toC(CGenerationContext context) {
		//return "\"" + mValue + "\"";
		String temp;
		if (mValue.length()-2 > 0){
			temp = helper(1, context);
		}
		else{
			temp = "NULL";
		}
		return temp;
	}

	@Override
	public ArrayList<IrBind> getExpressions(CGenerationContext context) {
		ArrayList<IrBind> arr = new ArrayList<IrBind>();
		return arr;
	}
	
	@Override
	public CubexTypeGrammar getCubexType() {
		return new CubexTypeClass("String", new CubexList<CubexTypeGrammar>());
	}
	
	public String toString(){
		return mValue;
	}

	@Override
	public void getVars(Set<String> set, Map<String, Set<String>> map) {
		return;
	}
	
	public boolean equals(Object object){
		if (object instanceof IrString) {
			IrString expr = (IrString) object;
			return mValue.equals(expr.mValue);
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
		return new IrString(mValue);
	}
}
