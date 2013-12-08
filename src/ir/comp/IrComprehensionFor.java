package ir.comp;

import ir.CGenerationContext;
import ir.expressions.IrExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public class IrComprehensionFor implements IrComprehension{
	public IrComprehension comp;
	public IrExpression expression;
	public String variableName;
	
	public CubexTypeGrammar cubexType;
	public String cType;
	
	public IrComprehensionFor(IrComprehension comp, IrExpression expression,
			String variableName, CubexTypeGrammar cubexType) {
		this.comp = comp;
		this.expression = expression;
		this.variableName = variableName;
		this.cubexType = cubexType;
	}

	@Override
	public String toC(CGenerationContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
