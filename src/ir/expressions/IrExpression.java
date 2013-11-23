package ir.expressions;

import java.util.ArrayList;

import optimization.CseContext;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import ir.CGenerationContext;
import ir.statements.IrBind;

public interface IrExpression {
	
	public String getCType();
	
	public CubexTypeGrammar getCubexType();
	
	public String toC(CGenerationContext context);

	public ArrayList<IrBind> getExpressions(CGenerationContext context);
	
	public String toString();
	
	public IrExpression eliminateSubexpression(CseContext context);
	
	public IrExpression getSubexpressions(CseContext context);
}