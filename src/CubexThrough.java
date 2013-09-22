
public class CubexThrough extends CubexBinaryExpression {
	private boolean includeLeft;
	private boolean includeRight;
	public CubexThrough(CubexExpression l, CubexExpression r, boolean inclL, boolean inclR) {
		super(l, r);
		includeLeft = inclL;
		includeRight = inclR;
	}
	@Override
	protected CubexType calculateType(CubexType left, CubexType right)
			throws NoSuchTypeException {
		return CubexType.getArray(CubexType.getInt());
	}

}
