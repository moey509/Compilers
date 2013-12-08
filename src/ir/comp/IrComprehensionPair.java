package ir.comp;


import ir.CGenerationContext;
import ir.expressions.IrExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public class IrComprehensionPair implements IrComprehension{
	public IrComprehension comp;
	public IrExpression expr;
	
	public CubexTypeGrammar cubexType;
	public String cType;
	
	public IrComprehensionPair(IrComprehension comp, IrExpression expr,
			CubexTypeGrammar cubexType) {
		this.comp = comp;
		this.expr = expr;
		this.cubexType = cubexType;
	}

	@Override
	public String toC(CGenerationContext context) {
		// This should be similar to iterable append. 
		//Make a git_t of expr
		//Make a git_t of comp
		//return iterable_append(empr, comp);
		//Need to know how to do this with Toshi's code
		return null;
	}
	
}
