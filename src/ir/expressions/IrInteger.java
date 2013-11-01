package ir.expressions;

public final class IrInteger implements IrExpression {
	private int mValue;

	public IrInteger(int value) {
		mValue = value;
		System.out.println(mValue);
	}
	
	public String toC() {
		return Integer.toString(mValue);
	}
}