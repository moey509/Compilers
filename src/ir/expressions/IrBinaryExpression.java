package ir.expressions;

import ir.CGenerationContext;
import ir.IrMiscFunctions;

public class IrBinaryExpression implements IrExpression {
	private IrExpression leftExpression;
	private IrExpression rightExpression;
	private String operator;
	private String type;

	public IrBinaryExpression(IrExpression leftExpression,
			IrExpression rightExpression, String operator) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
		this.operator = operator;

		// logic to determine type:
		switch (operator) {
			case "+":
				type = IrMiscFunctions.INTEGER;
				break;
			case "&&":
				type = IrMiscFunctions.INTEGER;
				break;
			case "/":
				type = IrMiscFunctions.INTEGER;
				break;
			case "-":
				type = IrMiscFunctions.INTEGER;
				break;			
			case "%":
				type = IrMiscFunctions.INTEGER;
				break;
			case "*": 
				type = IrMiscFunctions.INTEGER;
				break;
			case "||":
				type = IrMiscFunctions.BOOLEAN;
				break;
			case "==":
				type = IrMiscFunctions.BOOLEAN;
				break;
			case "<=":
				type = IrMiscFunctions.BOOLEAN;
				break;
			case "<":
				type = IrMiscFunctions.BOOLEAN;
				break;
			default: 
				type = null;
				System.out.println("WARNING! built it type was not found...");
				break;
			
		}
	}

	public String getOperator() {
		return this.operator;
	}

	public IrExpression getLeftExpression() {
		return this.leftExpression;
	}

	public IrExpression getRightExpression() {
		return this.rightExpression;
	}

	public String getType() {
		return type;
	}

	public String toC(CGenerationContext context) {
		if (operator == null || operator.equals("")) {
			System.out.println("WARNING: there is no operator in this Binary Expression");
			return null;
		}
		return "(" + leftExpression.toC(context) + ") " + operator + " (" + rightExpression.toC(context) + ")";
	}
}