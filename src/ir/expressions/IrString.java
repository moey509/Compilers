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
	
	public String toC(CGenerationContext context) {
		return "\"" + mValue + "\"";
	}
}