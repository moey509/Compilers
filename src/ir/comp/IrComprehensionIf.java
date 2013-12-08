package ir.comp;

import ir.CGenerationContext;
import ir.expressions.IrExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public class IrComprehensionIf implements IrComprehension{
	public IrComprehension comp;
	public IrExpression expression;
	
	public CubexTypeGrammar cubexType;
	public String cType;
	
	public IrComprehensionIf(IrComprehension comp, IrExpression expression,
			CubexTypeGrammar cubexType) {
		this.comp = comp;
		this.expression = expression;
		this.cubexType = cubexType;
	}

	@Override
	public String toC(CGenerationContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
