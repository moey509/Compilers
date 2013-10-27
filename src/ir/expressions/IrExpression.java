package ir.expressions;


public class IrExpression {
	String name;
	
	public IrExpression() {}

	public IrExpression(String vp) {
		name = vp;
	}
	
	public String toC() {
		return null;
	}
	
}