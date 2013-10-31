package parsingTokens.expressions;

import ir.expressions.IrUnaryExpression;
import context.IrContext;


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
	
	public abstract IrUnaryExpression toIr(IrContext context);
}