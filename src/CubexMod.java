public class CubexMod extends CubexBinaryExpression {
	public CubexMod(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	public String toString(){
		return getmLeft().toString() + " . modulo < > ( " + getmRight().toString() + " )";
	}
}