package ir.expressions;

import ir.CGenerationContext;

public final class IrString implements IrExpression {
	private String mValue;

	public IrString(String value) {
		mValue = value;
	}
	
	public String toC(CGenerationContext context) {
		return "\"" + mValue + "\"";
	}
}