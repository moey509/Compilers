package parsingTokens.expressions;

import typeChecker.IrGenerationContext;
import ir.expressions.IrUnaryExpression;


public abstract class CubexUnaryExpression extends CubexExpression {
	private CubexExpression mArgument;
	public CubexUnaryExpression(CubexExpression arg) {
		setmArgument(arg);
	}
	public CubexExpression getmArgument() {
		return mArgument;
	}
	public void setmArgument(CubexExpression mArgument) {
		this.mArgument = mArgument;
	}
	
	public abstract IrUnaryExpression toIr(IrGenerationContext context);
}