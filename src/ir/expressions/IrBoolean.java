package ir.expressions;

public final class IrBoolean extends IrExpression {
	private boolean mValue;
	public IrBoolean(boolean value) { mValue = value; }
	
	public String toC() {
		return null;
	}
}