public class CubexAnd extends CubexBinaryExpression {
	public CubexAnd(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	
	public String toString(){
		return getmLeft().toString() + " . and < > ( " + getmRight().toString() + " )";
	}
}