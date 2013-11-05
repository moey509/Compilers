package ir.expressions;

import ir.CGenerationContext;
import ir.IrMiscFunctions;

public final class IrString implements IrExpression {
	private String mValue;
	private String type;

	public IrString(String value) {
		mValue = value;
		this.type = IrMiscFunctions.STRING;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String helper(int index, CGenerationContext context) {
		if (index == type.length() - 1)
			return ("iterable_append(" + mValue.charAt(index) + ", NULL)");
		return ("iterable_append(" + mValue.charAt(index) + ", " + helper(index+1, context) + ")");
	}
	
	// NOTE: STRINGS SHOULD BE CONVERTED INTO ITERABLES OF CHARS
	public String toC(CGenerationContext context) {
		//return "\"" + mValue + "\"";
		String temp;
		if (mValue.length() > 0)
			temp = helper(0, context);
		else
			temp = "NULL";
		return temp;
	}
}