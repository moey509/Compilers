package ir.expressions;

import java.util.ArrayList;

import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import ir.CGenerationContext;
import ir.IrMiscFunctions;
import ir.IrType;
import ir.program.IrTypeTuple;
import ir.statements.IrBind;

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
		// TODO Fix this to take in a context
		//arr.add(new IrBind(new IrTypeTuple(new IrType("void*"), "_tmp" + context.nextCount()), this));
		return arr;
	}
	
	@Override
	public CubexTypeGrammar getCubexType() {
		return new CubexTypeClass("String", new CubexList<CubexTypeGrammar>());
	}
}