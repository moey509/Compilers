package ir.expressions;

public class IrOnwards extends IrUnaryExpression {
	boolean include;
	public IrExpression expression;

	public IrOnwards(IrExpression expression, boolean incl) {
		super(expression, "");
		include = incl;
	}
	
	public String toC() {
		return null;
	}
}
