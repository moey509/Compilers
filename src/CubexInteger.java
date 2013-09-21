public final class CubexInteger extends CubexExpression {
	private int mValue;
	public CubexInteger(int value) {mvalue = value;}
	protected CubexType calculateType(CubexContext context) {
		return CubexType.getInt();
	}
}