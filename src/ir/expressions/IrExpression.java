package ir.expressions;

import ir.CGenerationContext;

public interface IrExpression {
	
	public String getType();
	
	public String toC(CGenerationContext context);

}