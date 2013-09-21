public abstract class CubexUnaryExpression extends CubexExpression {
	private CubexExpression mArgument;
	public CubexUnaryExpression(CubexExpression arg) {
		mArgument = arg;
	}
	protected CubexType calculateType(CubexContext context) throws NoSuchTypeException {
		return calculateType(mArgument.getType(context));
	}
	protected abstract CubexType calculateType(CubexType arg) throws NoSuchTypeException;
}