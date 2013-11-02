package ir.expressions;

import ir.CGenerationContext;

public final class IrBoolean implements IrExpression {
	private boolean mValue;

	public IrBoolean(boolean value) {
		mValue = value;
	}

	public String toC(CGenerationContext context) {
		return mValue ? "1" : "0";
	}
}