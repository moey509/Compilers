package ir.expressions;

public final class IrString implements IrExpression {
	private String mValue;

	public IrString(String value) {
		mValue = value;
	}
	
	public String toC() {
		return "\"" + mValue + "\"";
	}
}