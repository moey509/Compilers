package ir.expressions;

import java.util.ArrayList;

import ir.CGenerationContext;
import ir.IrMiscFunctions;
import ir.IrType;
import ir.program.IrTypeTuple;
import ir.statements.IrBind;

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
		if (index == mValue.length() - 2){
			return ("iterable_append(" + mValue.charAt(index) + ", NULL)");
		}
		return ("iterable_append(" + mValue.charAt(index) + ", " + helper(index+1, context) + ")");
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
		// TODO Auto-generated method stub
		ArrayList<IrBind> arr = new ArrayList<IrBind>();
		arr.add(new IrBind(new IrTypeTuple(new IrType("void*"), "_tmp" + context.nextCount()), this));
		return arr;
	}
}