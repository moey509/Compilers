package ir.expressions;

import ir.CGenerationContext;
import ir.IrMiscFunctions;

public class IrAppend implements IrExpression {
	IrExpression e1, e2;
	String type;

	public IrAppend(IrExpression expr1, IrExpression expr2) {
		e1 = expr1;
		e2 = expr2;
		this.type = IrMiscFunctions.ITERABLE;
	}
	
	public String getType() {
		return type;
	}
	
	public String toC(CGenerationContext context) {
		return "iterable_append(" + e1.toC(context) + ", " + e2.toC(context) +" )";
	}
}
