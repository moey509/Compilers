public class CubexNegative extends CubexUnaryExpression {
	public CubexNegative(CubexExpression arg) {
		super(arg);
	}
	protected CubexType calculateType(CubexType arg) throws NoSuchTypeException {
		if (!arg.isInt())
			throw new NoSuchTypeException();
		return CubexType.getInt();
	}
}