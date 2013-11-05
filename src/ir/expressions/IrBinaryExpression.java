package ir.expressions;

import java.util.ArrayList;

import ir.CGenerationContext;
import ir.IrMiscFunctions;
import ir.statements.IrBind;

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
		if (operator.equals("+") || operator.equals("&&") || operator.equals("/") || operator.equals("-")
				|| operator.equals("%") || operator.equals("*"))
			type = IrMiscFunctions.INTEGER;
		else if (operator.equals("||") || operator.equals("==") || operator.equals("<=") || operator.equals("<"))
			type = IrMiscFunctions.BOOLEAN;
		else {
			type = null;
			System.out.println("WARNING! built it type was not found...");
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
	
	@Override
	public ArrayList<IrBind> getExpressions(CGenerationContext context) {
		// TODO Auto-generated method stub
		return new ArrayList<IrBind>();
	}
}