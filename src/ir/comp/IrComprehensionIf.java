package ir.comp;

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
	
	
}
