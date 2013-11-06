package parsingTokens.expressions;

import java.util.Set;

import typeChecker.IrGenerationContext;
import ir.expressions.IrBinaryExpression;


public abstract class CubexBinaryExpression extends CubexExpression {
	private CubexExpression mLeft, mRight;
	
	public 
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
	
	public abstract IrBinaryExpression toIr(IrGenerationContext context);
	
	public void getVars(Set<String> s) {
		mLeft.getVars(s);
		mRight.getVars(s);
	}
}