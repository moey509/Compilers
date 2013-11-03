package ir.expressions;

import ir.CGenerationContext;
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
	
	// new_git_int(0, 3, 5);
	public String toC(CGenerationContext context) {
		String inL;
		String inR;
		if (includeLeft)
			inL = " + 1";
		else
			inL = " + 0";
		if (includeRight)
			inR = " + 1";
		else
			inR = " + 0";
		return "new_git_int(0, (" + getLeftExpression().toC(context) + inL + "), (" + getRightExpression().toC(context) + inR + "));";
		 
			
	}
}
