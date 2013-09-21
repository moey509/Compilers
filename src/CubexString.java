public final class CubexString extends CubexExpression {
	private String mValue;
	public CubexString(String value) { mValue = value; }
	protected CubexType calculateType(CubexContext context) {
		return CubexType.getArray(CubexType.getInt());
	}
}