public abstract class CubexBinaryExpression extends CubexExpression {
	private CubexExpression mLeft, mRight;
	public CubexBinaryExpression(CubexExpression left, CubexExpression right) {
		mLeft = left;
		mRight = right;
	}
	protected CubexType calculateType(CubexContext context) throws NoSuchTypeException {
		return calculateType(mLeft.getType(context), mRight.getType(context));
	}
	protected abstract CubexType calculateType(CubexType left, CubexType right) throws NoSuchTypeException;
}