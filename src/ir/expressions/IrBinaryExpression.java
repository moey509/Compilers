package ir.expressions;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import optimization.CseContext;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import ir.CGenerationContext;
import ir.IrMiscFunctions;
import ir.statements.IrBind;

public class IrBinaryExpression implements IrExpression {
	private IrExpression leftExpression;
	private IrExpression rightExpression;
	private String operator;
	private String type;
	private CubexTypeGrammar cubexType;

	public IrBinaryExpression(IrExpression leftExpression,
			IrExpression rightExpression, String operator,
			CubexTypeGrammar cubexType) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
		this.operator = operator;
		this.cubexType = cubexType;

		//System.out.println("___=> " + operator);

		// logic to determine type:
		if (operator.equals("+") || operator.equals("&&")
				|| operator.equals("/") || operator.equals("-")
				|| operator.equals("%") || operator.equals("*"))
			type = IrMiscFunctions.INTEGER;
		else if (operator.equals("||") || operator.equals("==")
				|| operator.equals("<=") || operator.equals("<"))
			type = IrMiscFunctions.BOOLEAN;
		else if (operator.equals("..") || operator.equals(".<")
				|| operator.equals("<.") || operator.equals("<<")) {
			type = IrMiscFunctions.ITERABLE;
		} else {
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

	public String getCType() {
		return type;
	}

	public String toC(CGenerationContext context) {
		/*
		 * // case for iterables: if (type.equals(IrMiscFunctions.ITERABLE)) {
		 * // integer case: if
		 * (leftExpression.getCType().equals(IrMiscFunctions.INTEGER)) { String
		 * base = "Integer_through(" + leftExpression.toC(context) + ", " +
		 * rightExpression.toC(context) + ", "; if (operator.equals("..")) {
		 * return base + "new_integer(1), new_integer(1))"; } else if
		 * (operator.equals(".<")) { return base +
		 * "new_integer(1), new_integer(0))"; } else if (operator.equals("<.")){
		 * return base + "new_integer(0), new_integer(1))"; } else if
		 * (operator.equals("<<")) { return base +
		 * "new_integer(0), new_integer(0))"; } else {
		 * System.out.println("WARNING! THIS ITERABLE TYPE NO EXIST"); return
		 * null; } } // boolean case else if
		 * (leftExpression.getCType().equals(IrMiscFunctions.BOOLEAN)) { String
		 * base = "Integer_through(" + leftExpression.toC(context) + ", " +
		 * rightExpression.toC(context) + ", "; if (operator.equals("..")) {
		 * return base + "new_integer(1), new_integer(1))"; } else if
		 * (operator.equals(".<")) { return base +
		 * "new_integer(1), new_integer(0))"; } else if (operator.equals("<.")){
		 * return base + "new_integer(0), new_integer(1))"; } else if
		 * (operator.equals("<<")) { return base +
		 * "new_integer(0), new_integer(0))"; } else {
		 * System.out.println("WARNING! THIS ITERABLE TYPE NO EXIST"); return
		 * null; } } else {
		 * System.out.println("WARNING! THRU-WARDS ON WRONG TYPE"); return null;
		 * } }
		 */
		// everything else
		if (leftExpression.getCubexType().name.equals("Integer")) {
			if (operator.equals("+"))
				return "Integer_plus(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
			else if (operator.equals("-"))
				return "Integer_subtract(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
			else if (operator.equals("*"))
				return "Integer_times(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
			else if (operator.equals("/"))
				return "Integer_divide(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
			else if (operator.equals("%"))
				return "Integer_modulo(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
			else if (operator.equals(".."))
				return "Integer_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", 1, 1)";
			else if (operator.equals("<."))
				return "Integer_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", 0, 1)";
			else if (operator.equals(".<"))
				return "Integer_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", 1, 0)";
			else if (operator.equals("<<"))
				return "Integer_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", 0, 0)";
			else if (operator.equals("<"))
				return "Integer_lessThan(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", 1)";
			else if (operator.equals("<="))
				return "Integer_lessThan(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", 0)";
			else if (operator.equals("=="))
				return "Integer_equals(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
		} else if (leftExpression.getCubexType().name.equals("Boolean"))  {
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
						+ rightExpression.toC(context) + "1, 1)";
			else if (operator.equals("<."))
				return "Boolean_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + "0, 1)";
			else if (operator.equals(".<"))
				return "Boolean_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + "1, 0)";
			else if (operator.equals("<<"))
				return "Boolean_through(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + "0, 0)";
			else if (operator.equals("<"))
				return "Boolean_lessThan(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", 1)";
			else if (operator.equals("<="))
				return "Boolean_lessThan(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ", 0)";
			else if (operator.equals("=="))
				return "Boolean_equal(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
		} else if (leftExpression.getCubexType().name.equals("Character"))  {
			if (operator.equals("=="))
				return "Character_equals(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
		} else if (leftExpression.getCubexType().name.equals("String")) {
			if (operator.equals("=="))
				return "String_equals(" + leftExpression.toC(context) + ", "
						+ rightExpression.toC(context) + ")";
		}
		System.out
				.println("WARNING: there is no operator in this Binary Expression");
		return operator;
	}

	@Override
	public ArrayList<IrBind> getExpressions(CGenerationContext context) {
		return new ArrayList<IrBind>();
	}

	@Override
	public CubexTypeGrammar getCubexType() {
		return cubexType;
	}

	public String toString() {
		return leftExpression.toString() + operator
				+ rightExpression.toString();
	}

	public boolean equals(Object object) {
		if (object instanceof IrBinaryExpression){
			IrBinaryExpression expr = (IrBinaryExpression)object;
			return leftExpression.equals(expr.leftExpression)
					&& rightExpression.equals(expr.rightExpression)
					&& operator.equals(expr.operator);
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public IrExpression eliminateSubexpression(CseContext context) {
		IrExpression expr = getSubexpressions(context);
		if (context.containsExpression(expr)){
			return context.getVariableExpression(expr);
		} else {
			leftExpression = leftExpression.eliminateSubexpression(context);
			rightExpression = rightExpression.eliminateSubexpression(context);
			return this;
		}
	}

	@Override
	public IrExpression getSubexpressions(CseContext context) {
		return new IrBinaryExpression(leftExpression.getSubexpressions(context), 
				rightExpression.getSubexpressions(context), operator, cubexType);
	}
	
	@Override
	public void getVars(Set<String> set, Map<String, Set<String>> map) {
		leftExpression.getVars(set, map);
		rightExpression.getVars(set, map);
	}
}
