package ir.expressions;

import java.util.ArrayList;
import java.util.Iterator;

import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import ir.CGenerationContext;
import ir.IrMiscFunctions;
import ir.statements.IrBind;

public final class IrInteger implements IrExpression {
	private int mValue;
	private String cType;

	public IrInteger(int value) {
		mValue = value;
		cType = IrMiscFunctions.INTEGER;
	}
	
	public String getCType(){
		return cType;
	}
	
	public String toC(CGenerationContext context) {
		return "new_integer(" + Integer.toString(mValue) + ")";
	}
	
	@Override
	public ArrayList<IrBind> getExpressions(CGenerationContext context) {
		// TODO Auto-generated method stub
		return new ArrayList<IrBind>();
	}
	
	@Override
	public CubexTypeGrammar getCubexType() {
		return new CubexTypeClass("Integer", new CubexList<CubexTypeGrammar>());
	}
	
	public String toString(){
		return Integer.toString(mValue);
	}
	public boolean equals(IrInteger expr){
		return mValue == expr.mValue;
	}
	
	public int hashCode(){
		return toString().hashCode();
	}
}