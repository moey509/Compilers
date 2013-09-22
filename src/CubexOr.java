public class CubexOr extends CubexBinaryExpression {
	public CubexOr(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	protected CubexType calculateType(CubexType left, CubexType right) throws NoSuchTypeException {
		if (!left.isBool() || !right.isBool())
			throw new NoSuchTypeException("Error in CubexOr");
		return CubexType.getBool();
	}
}