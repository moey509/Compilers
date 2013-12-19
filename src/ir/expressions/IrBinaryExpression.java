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

		
		if (operator.equals("&&")) {
			System.out.println("lols");
		}
		
//		// logic to determine type:
//		if (operator.equals("+") || operator.equals("&&")
//				|| operator.equals("/") || operator.equals("-")
//				|| operator.equals("%") || operator.equals("*"))
//			type = IrMiscFunctions.INTEGER;
//		else if (operator.equals("||") || operator.equals("==")
//				|| operator.equals("<=") || operator.equals("<"))
//			type = IrMiscFunctions.BOOLEAN;
//		else if (operator.equals("..") || operator.equals(".<")
//				|| operator.equals("<.") || operator.equals("<<")) {
//			type = IrMiscFunctions.ITERABLE;
//		} else {
//			type = null;
//			System.out.println("WARNING! built it type was not found...");
//		}
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

	public String toC(CGenerationContext context) {
		
		// everything else
		//System.out.println("BINOP " + this);
		
		/* Integer cases */
		
		if (operator.equals("+")) {
			return "Integer_plus(" + leftExpression.toC(context) + ", "
					+ rightExpression.toC(context) + ")";
		}
		else if (operator.equals("/")) {
			return "Integer_divide(" + leftExpression.toC(context) + ", "
					+ rightExpression.toC(context) + ")";
		}
		else if (operator.equals("*")) {
			return "Integer_times(" + leftExpression.toC(context) + ", "
					+ rightExpression.toC(context) + ")";
		}
		else if (operator.equals("%")) {
			return "Integer_modulo(" + leftExpression.toC(context) + ", "
					+ rightExpression.toC(context) + ")";
		}
		else if (operator.equals("-")) {
			return "Integer_subtract(" + leftExpression.toC(context) + ", "
					+ rightExpression.toC(context) + ")";
		}
		
		/* Boolean cases */
		else if (operator.equals("||")) {
			return "Boolean_or(" + leftExpression.toC(context) + ", "
					+ rightExpression.toC(context) + ")";
		}
		else if (operator.equals("&&")) {
			return "Boolean_and(" + leftExpression.toC(context) + ", "
					+ rightExpression.toC(context) + ")";
		}
		
		/* General case */
		else if (operator.equals("==")) {
			return "General_equals((General_t)" + leftExpression.toC(context) + ", (General_t)"
					+ rightExpression.toC(context) + ")";
		}
		else if (operator.equals("<")) {
			return "General_lessThan((General_t)" + leftExpression.toC(context) + ", (General_t)"
					+ rightExpression.toC(context) + ", 1)";
		}
		else if (operator.equals("<=")) {
			return "General_lessThan((General_t)" + leftExpression.toC(context) + ", (General_t)"
					+ rightExpression.toC(context) + ", 0)";
		}
		else if (operator.equals("..")) {
			return "General_through((General_t)" + leftExpression.toC(context) + ", (General_t)"
					+ rightExpression.toC(context) + ", 1, 1)";
		}
		else if (operator.equals("<.")) {
			return "General_through((General_t)" + leftExpression.toC(context) + ", (General_t)"
					+ rightExpression.toC(context) + ", 0, 1)";
		}
		else if (operator.equals(".<")) {
			return "General_through((General_t)" + leftExpression.toC(context) + ", (General_t)"
					+ rightExpression.toC(context) + ", 1, 0)";
		}
		else if (operator.equals("<<")) {
			return "General_through((General_t)" + leftExpression.toC(context) + ", (General_t)"
					+ rightExpression.toC(context) + ", 0, 0)";
		}
		else {
			System.out.println("Cubex Type: " + leftExpression.getCubexType());

			throw new RuntimeException("no such operator (" + operator+") with type " + operator +" and cubexType " +
			cubexType);
		}
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
			//System.out.println("BINOP1: " + context.getVariableExpression(expr));
			return context.getVariableExpression(expr);
		} else {
			leftExpression = leftExpression.eliminateSubexpression(context);
			rightExpression = rightExpression.eliminateSubexpression(context);
			//System.out.println("BINOP2: " + this);
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
	
	public IrExpression clone(){
		return new IrBinaryExpression(leftExpression.clone(), rightExpression.clone(), new String(operator), cubexType);
	}
}
