package ir.expressions;


public class IrLessNotStrict extends IrBinaryExpression {
	public IrFunctionApp function;
	
	public IrLessNotStrict(IrExpression left, IrExpression right) {
		super(left, right);

	}
	
	public String toC() {
		return getmLeft().toC() + " <= " + getmRight().toC();
	}
}