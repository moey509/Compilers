public class CubexLessStrict extends CubexBinaryExpression {
	public CubexLessStrict(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	protected CubexType calculateType(CubexType left, CubexType right) throws NoSuchTypeException {
		if (!left.isInt() || !right.isInt())
			throw new NoSuchTypeException();
		return CubexType.getBool();
	}
}