package ir.expressions;

import java.util.ArrayList;

import ir.CGenerationContext;
import ir.IrMiscFunctions;
import ir.statements.IrBind;

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

	@Override
	public ArrayList<IrBind> getExpressions(CGenerationContext context) {
		// TODO Auto-generated method stub
		return new ArrayList<IrBind>();
	}
}