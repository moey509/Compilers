package ir.expressions;

public final class IrInteger implements IrExpression {
	private int mValue;

	public IrInteger(int value) {
		mValue = value;
	}
	
	public String toC() {
		return Integer.toString(mValue);
	}
}