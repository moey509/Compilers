public class CubexAdd extends CubexBinaryExpression {
	public CubexAdd(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	protected CubexType calculateType(CubexType left, CubexType right) throws NoSuchTypeException {
		if (!left.isInt() || !right.isInt())
			throw new NoSuchTypeException("Error in CubexAdd");
		return CubexType.getInt();
	}
}