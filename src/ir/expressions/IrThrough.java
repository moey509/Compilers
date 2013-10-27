package ir.expressions;

public class IrThrough extends IrBinaryExpression {
	private boolean includeLeft;
	private boolean includeRight;
	private IrExpression expr;
	public IrFunctionApp function;

	public IrThrough(IrExpression l, IrExpression r, boolean inclL,
			boolean inclR) {
		super(l, r);
		expr = l;
		includeLeft = inclL;
		includeRight = inclR;
	}
	
	public String toC() {
		return null;
	}
}
