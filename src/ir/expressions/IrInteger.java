package ir.expressions;

import ir.CGenerationContext;

public final class IrInteger implements IrExpression {
	private int mValue;

	public IrInteger(int value) {
		mValue = value;
		System.out.println(mValue);
	}
	
	public String toC(CGenerationContext context) {
		return Integer.toString(mValue);
	}
}