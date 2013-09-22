public class CubexMultiply extends CubexBinaryExpression {
	public CubexMultiply(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	public String toString(){
		return getmLeft().toString() + " . multiply < > ( " + getmRight().toString() + " )";
	}
}