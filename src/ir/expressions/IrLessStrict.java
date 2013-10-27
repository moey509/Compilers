package ir.expressions;

public class IrLessStrict extends IrBinaryExpression {

	public IrFunctionApp function;

	public IrLessStrict(IrExpression left, IrExpression right) {
		super(left, right);
	}
	
	public String toC() {
		return null;
	}
}