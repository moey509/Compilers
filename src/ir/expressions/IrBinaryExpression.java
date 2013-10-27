package ir.expressions;


public abstract class IrBinaryExpression extends IrExpression {
	private IrExpression mLeft, mRight;
	public IrBinaryExpression(IrExpression left, IrExpression right) {
		setmLeft(left);
		setmRight(right);
	}
	public IrExpression getmLeft() {
		return mLeft;
	}
	public void setmLeft(IrExpression mLeft) {
		this.mLeft = mLeft;
	}
	public IrExpression getmRight() {
		return mRight;
	}
	public void setmRight(IrExpression mRight) {
		this.mRight = mRight;
	}
}