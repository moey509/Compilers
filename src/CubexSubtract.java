public class CubexSubtract extends CubexBinaryExpression {
	public CubexSubtract(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	public String toString(){
		return getmLeft().toString() + " . minus < > ( " + getmRight().toString() + " )";
	}
}