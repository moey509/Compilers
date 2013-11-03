package ir.expressions;

import ir.CGenerationContext;
import ir.IrMiscFunctions;

public final class IrBoolean implements IrExpression {
	private boolean mValue;
	private String type;

	public IrBoolean(boolean value) {
		mValue = value;
		type = IrMiscFunctions.BOOLEAN;
	}
	
	public String getType() {
		return type;
	}

	public String toC(CGenerationContext context) {
		return mValue ? "1" : "0";
	}
}