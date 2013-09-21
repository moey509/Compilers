public final class CubexBoolean extends CubexExpression {
	private boolean mValue;
	public CubexBoolean(boolean value) { mValue = value; }
	protected CubexType calculateType(CubexContext context) {
		return CubexType.getBool();
	}
}