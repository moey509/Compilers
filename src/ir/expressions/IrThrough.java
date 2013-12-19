package ir.expressions;

import parsingTokens.typeGrammar.CubexTypeGrammar;
import ir.CGenerationContext;
import ir.IrMiscFunctions;

public class IrThrough extends IrBinaryExpression {
	private boolean includeLeft;
	private boolean includeRight;

	public IrThrough(IrExpression l, IrExpression r, boolean inclL,
			boolean inclR, CubexTypeGrammar cubexType) {
		super(l, r, "", cubexType);
		includeLeft = inclL;
		includeRight = inclR;
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
		return "new_git_int(0, (" + getLeftExpression().toC(context) + inL + "), (" + getRightExpression().toC(context) + inR + "))";			
	}
}
