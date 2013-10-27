package ir.expressions;


public abstract class IrUnaryExpression extends IrExpression {
	private IrExpression mArgument;
	public IrUnaryExpression(IrExpression arg) {
		setmArgument(arg);
	}
	public IrExpression getmArgument() {
		return mArgument;
	}
	public void setmArgument(IrExpression mArgument) {
		this.mArgument = mArgument;
	}
}