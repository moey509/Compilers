package ir.expressions;

import parsingTokens.typeGrammar.CubexTypeGrammar;
import ir.CGenerationContext;
import ir.IrMiscFunctions;

public class IrOnwards extends IrUnaryExpression {
	boolean include;
	public IrExpression expression;
	private String cType;

	public IrOnwards(IrExpression expression, boolean incl, CubexTypeGrammar cubexType) {
		super(expression, "", cubexType);
		include = incl;
		this.cType = IrMiscFunctions.ITERABLE;
	}
	
	public String getCType() {
		return cType;
	}
	
	public String toC(CGenerationContext context) {
		// int case
		// new_git_int(-1, 5, 0);
		if (expression.getCType().equals("integer")) {
			String in;
			if (include)
				in = " + 1";
			else
				in = " + 0";
			return "new_git_int(1, (" + expression.toC(context) + in + "), 0)";
		}
		// boolean case
		else {
			String in;
			if (include)
				in = " + 1";
			else
				in = " + 0";
			return "new_git_int(0, (" + expression.toC(context) + in + "), 1)";
		}
	}
}
