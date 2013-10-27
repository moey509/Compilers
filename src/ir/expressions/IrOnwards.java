package ir.expressions;

public class IrOnwards extends IrUnaryExpression {
	boolean include;
	public IrFunctionApp function;

	public IrOnwards(IrExpression l, boolean incl) {
		super(l);
		include = incl;
	}
	
	public String toC() {
		return null;
	}
}
