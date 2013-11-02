package ir.expressions;

import ir.CGenerationContext;

public class IrAppend implements IrExpression {
	IrExpression e1, e2;

	public IrAppend(IrExpression expr1, IrExpression expr2) {
		e1 = expr1;
		e2 = expr2;
	}
	
	public String toC(CGenerationContext context) {
		return "iterable_append(" + e1.toC(context) + ", " + e2.toC(context) +" )";
	}
}
