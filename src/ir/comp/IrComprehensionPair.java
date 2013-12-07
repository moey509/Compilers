package ir.comp;


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
	
}
