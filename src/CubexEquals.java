public class CubexEquals extends CubexBinaryExpression {
	public CubexEquals(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	protected CubexType calculateType(CubexType left, CubexType right) throws NoSuchTypeException {
		if (!left.equals(right))
			throw new NoSuchTypeException("Error in CubexEquals");
		return CubexType.getBool();
	}
}