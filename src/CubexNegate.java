public class CubexNegate extends CubexUnaryExpression {
	public CubexNegate(CubexExpression arg) {
		super(arg);
	}
	protected CubexType calculateType(CubexType arg) throws NoSuchTypeException {
		if (!arg.isBool())
			throw new NoSuchTypeException("Error in CubexNegate");
		return CubexType.getBool();
	}
}