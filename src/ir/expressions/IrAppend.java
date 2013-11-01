package ir.expressions;

public class IrAppend implements IrExpression {
	IrExpression e1, e2;

	public IrAppend(IrExpression expr1, IrExpression expr2) {
		e1 = expr1;
		e2 = expr2;
	}
	
	public String toC() {
		return "iterable_append(" + e1.toC() + ", " + e2.toC() +" )";
	}
}
