package parsingTokens.expressions;

import ir.expressions.IrBinaryExpression;
import ir.program.IrProgramContext;


public abstract class CubexBinaryExpression extends CubexExpression {
	private CubexExpression mLeft, mRight;
	public CubexBinaryExpression(CubexExpression left, CubexExpression right) {
		setmLeft(left);
		setmRight(right);
	}
	public CubexExpression getmLeft() {
		return mLeft;
	}
	public void setmLeft(CubexExpression mLeft) {
		this.mLeft = mLeft;
	}
	public CubexExpression getmRight() {
		return mRight;
	}
	public void setmRight(CubexExpression mRight) {
		this.mRight = mRight;
	}
	
	public abstract IrBinaryExpression toIr(IrProgramContext context);
}