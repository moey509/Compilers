package ir.expressions;

import ir.CGenerationContext;
import ir.IrMiscFunctions;

public class IrUnaryExpression implements IrExpression {
	private IrExpression expression;
	private String operator;
	private String type;

	public IrUnaryExpression(IrExpression expression, String operator) {
		super();
		this.expression = expression;
		this.operator = operator;
		
		// logic to determine type:
		switch (operator) {
		case "!":
			this.type = IrMiscFunctions.BOOLEAN;
			break;
		case "-":
			this.type = IrMiscFunctions.INTEGER;
			break;
		default:
			this.type = null;
			System.out.println("unary operator: " + operator + " could not be found....");
			break;

		}
	}
	
	public String getType() {
		return type;
	}

	@Override
	public String toC(CGenerationContext context) {
		if (operator == null || operator.equals("")) {
			System.out.println("WARNING: operator for unary expression was null or could not be found");
			return null;
		}
		return operator + " (" + expression.toC(context) + ")";
	}
}