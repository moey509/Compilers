public class CubexOr extends CubexBinaryExpression {
	public CubexOr(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	public String toString(){
		return getmLeft().toString() + " . or < > ( " + getmRight().toString() + " )";
	}
}