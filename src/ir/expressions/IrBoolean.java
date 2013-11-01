package ir.expressions;

public final class IrBoolean implements IrExpression {
	private boolean mValue;

	public IrBoolean(boolean value) {
		mValue = value;
	}

	public String toC() {
		return mValue ? "1" : "0";
	}
}