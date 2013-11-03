package ir.expressions;

import ir.CGenerationContext;
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
	
	public String toC(CGenerationContext context) {
		// int case
		// new_git_int(-1, 5, 0);
		if (expression.getType().equals("integer")) {
			String in;
			if (include)
				in = " + 1";
			else
				in = " + 0";
			return "new_git_int(1, (" + expression.toC(context) + in + "), 0);";
		}
		// boolean case
		else {
			String in;
			if (include)
				in = " + 1";
			else
				in = " + 0";
			return "new_git_int(0, (" + expression.toC(context) + in + "), 1);";
		}
	}
}
