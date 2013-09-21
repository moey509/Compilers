public class CubexAnd extends CubexBinaryExpression {
	public CubexAnd(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	protected CubexType calculateType(CubexType left, CubexType right) throws NoSuchTypeException {
		if (!left.isBool() || !right.isBool())
			throw new NoSuchTypeException();
		return CubexType.getBool();
	}
}