public class CubexNegative extends CubexUnaryExpression {
	public CubexNegative(CubexExpression arg) {
		super(arg);
	}
	public String toString(){
		return getmArgument().toString() + " . negative < > ( )";
	}
}