
public class CubexOnwards extends CubexUnaryExpression {
	boolean include;
	public CubexOnwards(CubexExpression l, boolean incl) {
		super(l);
		include = incl;
	}
	@Override
	protected CubexType calculateType(CubexType arg) throws NoSuchTypeException {
		return CubexType.getArray(CubexType.getInt());
	}

}
