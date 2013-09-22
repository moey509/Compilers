public class CubexLessNotStrict extends CubexBinaryExpression {
	public CubexLessNotStrict(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	public String toString(){
		return getmLeft().toString() + " . lessThan < > ( " + getmRight().toString() + " , false )";
	}
}