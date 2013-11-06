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
		if (operator.equals("+") || operator.equals("&&")
				|| operator.equals("/") || operator.equals("-")
				|| operator.equals("%") || operator.equals("*"))
			type = IrMiscFunctions.INTEGER;
		else if (operator.equals("||") || operator.equals("==")
				|| operator.equals("<=") || operator.equals("<"))
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
		System.out.println(leftExpression.toC(context) + " " + leftExpression.getType());
		System.out.println(operator);
		if (leftExpression.getType().equals(IrMiscFunctions.INTEGER)) {
			if (operator.equals("+"))
				return "integer_add(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
			else if (operator.equals("-"))
				return "integer_subtract(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
			else if (operator.equals("*"))
				return "integer_multiply(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
			else if (operator.equals("/"))
				return "integer_divide(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
			else if (operator.equals("%"))
				return "integer_mod(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
			else if (operator.equals(".."))
				return "integer_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", 1, 1)";
			else if (operator.equals("<."))
				return "integer_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", 0, 1)";
			else if (operator.equals(".<"))
				return "integer_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", 1, 0)";
			else if (operator.equals("<<"))
				return "integer_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", 0, 0)";
			else if (operator.equals("<"))
				return "integer_lessThan(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", 1)";
			else if (operator.equals("<="))
				return "integer_lessThan(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", 0)";
			else if (operator.equals("=="))
				return "integer_equals(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
		} else if (leftExpression.getType().equals(IrMiscFunctions.BOOLEAN)) {
			if (operator.equals("&&"))
				return "boolean_and(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
			else if (operator.equals("||"))
				return "boolean_or(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
			else if (operator.equals("||"))
				return "boolean_or(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
			else if (operator.equals(".."))
				return "boolean_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + "1, 1)";
			else if (operator.equals("<."))
				return "boolean_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + "0, 1)";
			else if (operator.equals(".<"))
				return "boolean_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + "1, 0)";
			else if (operator.equals("<<"))
				return "boolean_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + "0, 0)";
			else if (operator.equals("<"))
				return "boolean_lessThan(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", 1)";
			else if (operator.equals("<="))
				return "boolean_lessThan(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", 0)";
			else if (operator.equals("=="))
				return "boolean_equal(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
		} else if (leftExpression.getType().equals(IrMiscFunctions.CHARACTER)) {
			if (operator.equals("=="))
				return "character_equals(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
		} else if (leftExpression.getType().equals("String")) {
			if (operator.equals("=="))
				return "string_equals(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
		}
		System.out.println("WARNING: there is no operator in this Binary Expression");
		return operator;
	}

	@Override
	public ArrayList<IrBind> getExpressions(CGenerationContext context) {
		// TODO Auto-generated method stub
		return new ArrayList<IrBind>();
	}
}
