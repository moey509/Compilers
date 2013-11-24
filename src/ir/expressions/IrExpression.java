package ir.expressions;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

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
	
	// LvaContext is used to determine what toplevel variables are being used by a function call
	public void getVars(Set<String> set, Map<String, Set<String>> map);
	public IrExpression eliminateSubexpression(CseContext context);
	
	public IrExpression getSubexpressions(CseContext context);
}
