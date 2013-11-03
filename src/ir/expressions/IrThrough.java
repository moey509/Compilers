package ir.expressions;

import ir.IrMiscFunctions;

public class IrThrough extends IrBinaryExpression {
	private boolean includeLeft;
	private boolean includeRight;
	private String type;

	public IrThrough(IrExpression l, IrExpression r, boolean inclL,
			boolean inclR) {
		super(l, r, "");
		includeLeft = inclL;
		includeRight = inclR;
		this.type = IrMiscFunctions.ITERABLE;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String toC() {
		return null;
	}
}
