package ir.expressions;

import ir.CGenerationContext;
import ir.IrMiscFunctions;

public final class IrInteger implements IrExpression {
	private int mValue;
	private String type;

	public IrInteger(int value) {
		mValue = value;
		System.out.println(mValue);
		type = IrMiscFunctions.INTEGER;
	}
	
	public String getType(){
		return type;
	}
	
	public String toC(CGenerationContext context) {
		return Integer.toString(mValue);
	}
}