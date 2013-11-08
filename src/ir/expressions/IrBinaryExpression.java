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
		if (leftExpression.getType().equals(IrMiscFunctions.INTEGER)) {
			if (operator.equals("+"))
				return "Integer_plus(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
			else if (operator.equals("-"))
				return "Integer_subtract(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
			else if (operator.equals("*"))
				return "Integer_multiply(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
			else if (operator.equals("/"))
				return "Integer_divide(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
			else if (operator.equals("%"))
				return "Integer_mod(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
			else if (operator.equals(".."))
				return "Integer_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", new_integer(1), new_integer(1))";
			else if (operator.equals("<."))
				return "Integer_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", new_integer(0), new_integer(1))";
			else if (operator.equals(".<"))
				return "Integer_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", new_integer(1), new_integer(0))";
			else if (operator.equals("<<"))
				return "Integer_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", new_integer(0), new_integer(0))";
			else if (operator.equals("<"))
				return "Integer_lessThan(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", new_integer(1))";
			else if (operator.equals("<="))
				return "Integer_lessThan(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", new_integer(0))";
			else if (operator.equals("=="))
				return "Integer_equals(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
		} else if (leftExpression.getType().equals(IrMiscFunctions.BOOLEAN)) {
			if (operator.equals("&&"))
				return "Boolean_and(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
			else if (operator.equals("||"))
				return "Boolean_or(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
			else if (operator.equals("||"))
				return "Boolean_or(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
			else if (operator.equals(".."))
				return "Boolean_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + "new_integer(1), new_integer(1))";
			else if (operator.equals("<."))
				return "Boolean_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + "new_integer(0), new_integer(1))";
			else if (operator.equals(".<"))
				return "Boolean_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + "new_integer(1), new_integer(0))";
			else if (operator.equals("<<"))
				return "Boolean_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + "new_integer(0), new_integer(0))";
			else if (operator.equals("<"))
				return "Boolean_lessThan(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", new_integer(1))";
			else if (operator.equals("<="))
				return "Boolean_lessThan(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", new_integer(0))";
			else if (operator.equals("=="))
				return "Boolean_equal(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
		} else if (leftExpression.getType().equals(IrMiscFunctions.CHARACTER)) {
			if (operator.equals("=="))
				return "Character_equals(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
		} else if (leftExpression.getType().equals("String")) {
			if (operator.equals("=="))
				return "String_equals(" + leftExpression.toC(context) + ", "
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
