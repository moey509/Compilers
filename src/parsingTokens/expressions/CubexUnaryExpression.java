package parsingTokens.expressions;


public class CubexUnaryExpression extends CubexExpression {
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
}