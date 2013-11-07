package ir.expressions;

import java.util.ArrayList;

import ir.CGenerationContext;
import ir.statements.IrBind;

public interface IrExpression {
	
	public String getType();
	
	public String toC(CGenerationContext context);

	public ArrayList<IrBind> getExpressions(CGenerationContext context);
	
	public String toString();
}