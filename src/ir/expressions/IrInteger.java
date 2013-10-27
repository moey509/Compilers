package ir.expressions;

public final class IrInteger extends IrExpression {
	private int mValue;

	public IrInteger(int value) {
		mValue = value;
	}
	
	public String toC() {
		return null;
	}
}