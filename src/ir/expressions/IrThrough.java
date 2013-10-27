package ir.expressions;

public class IrThrough extends IrBinaryExpression {
	private boolean includeLeft;
	private boolean includeRight;
	public IrFunctionApp function;

	public IrThrough(IrExpression l, IrExpression r, boolean inclL,
			boolean inclR) {
		super(l, r);
		includeLeft = inclL;
		includeRight = inclR;
	}
	
	public String toC() {
		return null;
	}
}
