package parsingTokens.expressions;


public class CubexThrough extends CubexBinaryExpression {
	private boolean includeLeft;
	private boolean includeRight;
	public CubexThrough(CubexExpression l, CubexExpression r, boolean inclL, boolean inclR) {
		super(l, r);
		includeLeft = inclL;
		includeRight = inclR;
	}
	public String toString(){
		String incL = includeLeft ? "true" : "false";
		String incR = includeRight ? "true" : "false";
		return getmLeft().toString() + " . through < > ( " + getmRight().toString() + " , " + incL + " , " + incR + " )";
	}
}
