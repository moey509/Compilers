package parsingTokens.expressions;


public class CubexOnwards extends CubexUnaryExpression {
	boolean include;
	public CubexOnwards(CubexExpression l, boolean incl) {
		super(l);
		include = incl;
	}
	
	public String toString(){
		return getmArgument().toString() + " . onwards < > ( " + (include ? "true" : "false") + " )";
	}
}
