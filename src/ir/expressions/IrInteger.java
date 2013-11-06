package ir.expressions;

import java.util.ArrayList;

import ir.CGenerationContext;
import ir.IrMiscFunctions;
import ir.statements.IrBind;

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
		return "new_integer(" + Integer.toString(mValue) + ")";
	}
	
	@Override
	public ArrayList<IrBind> getExpressions(CGenerationContext context) {
		// TODO Auto-generated method stub
		return new ArrayList<IrBind>();
	}
}