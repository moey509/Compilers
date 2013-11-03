package ir.expressions;

import ir.IrMiscFunctions;

public class IrOnwards extends IrUnaryExpression {
	boolean include;
	public IrExpression expression;
	private String type;

	public IrOnwards(IrExpression expression, boolean incl) {
		super(expression, "");
		include = incl;
		this.type = IrMiscFunctions.ITERABLE;
	}
	
	public String getType() {
		return type;
	}
	
	public String toC() {
		return null;
	}
}
