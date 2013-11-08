package parsingTokens.expressions;

import java.util.Set;

import typeChecker.IrGenerationContext;
import ir.expressions.IrUnaryExpression;


public abstract class CubexUnaryExpression extends CubexExpression {
	private CubexExpression mArgument;
	public CubexUnaryExpression(CubexExpression arg) {
		setmArgument(arg);
		type = mArgument.type;
	}
	public CubexExpression getmArgument() {
		return mArgument;
	}
	public void setmArgument(CubexExpression mArgument) {
		this.mArgument = mArgument;
	}
	
	public abstract IrUnaryExpression toIr(IrGenerationContext context);
	
	@Override
	public void getVars(Set<String> set) {
		mArgument.getVars(set);
	}
}