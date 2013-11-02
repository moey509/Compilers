package ir.expressions;

import ir.CGenerationContext;

public interface IrExpression {

	public String toC(CGenerationContext context);

}