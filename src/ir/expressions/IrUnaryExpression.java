package ir.expressions;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

import optimization.CseContext;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import ir.CGenerationContext;
import ir.IrMiscFunctions;
import ir.statements.IrBind;

public class IrUnaryExpression implements IrExpression {
	private IrExpression expression;
	private String operator;
	private String cType;
	private CubexTypeGrammar cubexType;

	public IrUnaryExpression(IrExpression expression, String operator, CubexTypeGrammar cubexType) {
		super();
		this.expression = expression;
		this.operator = operator;
		this.cubexType = cubexType;
		
		// logic to determine type:
		if (operator.equals("!"))
			this.cType = IrMiscFunctions.BOOLEAN;
		else if (operator.equals("-"))
			this.cType = IrMiscFunctions.INTEGER;
		else if (operator.equals("...") || operator.equals("<..")) 
			this.cType = IrMiscFunctions.ITERABLE;
		else {
			this.cType = null;
			//System.out.println("unary operator: " + operator + " could not be found....");
		}
	}
	
	public String getCType() {
		return cType;
	}
	
	public IrExpression clone() {
		return new IrUnaryExpression(expression.clone(), new String(operator), cubexType);
	}

	@Override
	public String toC(CGenerationContext context) {
		if (expression.getCType() != null){
			if (expression.getCType().equals("Boolean")) {
				if (operator.equals("!"))
					return "Boolean_negate(" + expression.toC(context) + ")";
				else if (operator.equals("..."))
					return "Boolean_onward(" + expression.toC(context) + ", 1)";
				else if (operator.equals("<.."))
					return "Boolean_onward(" + expression.toC(context) + ", 0)";
			} else if (expression.getCType().equals("Integer")) {
				if (operator.equals("-"))
					return "Integer_negative(" + expression.toC(context) + ")";
				else if (operator.equals("..."))
					return "Integer_onward(" + expression.toC(context) + ", 1)";
				else if (operator.equals("<.."))
					return "Integer_onward(" + expression.toC(context) + ", 0)";
			}
		} else if (expression.getCubexType() != null){
			if (expression.getCubexType().name.equals("Boolean")) {
				if (operator.equals("!"))
					return "Boolean_negate(" + expression.toC(context) + ")";
				else if (operator.equals("..."))
					return "Boolean_onward(" + expression.toC(context) + ", 1)";
				else if (operator.equals("<.."))
					return "Boolean_onward(" + expression.toC(context) + ", 0)";
			} else if (expression.getCubexType().name.equals("Integer")) {
				if (operator.equals("-"))
					return "Integer_negative(" + expression.toC(context) + ")";
				else if (operator.equals("..."))
					return "Integer_onward(" + expression.toC(context) + ", 1)";
				else if (operator.equals("<.."))
					return "Integer_onward(" + expression.toC(context) + ", 0)";
			} else {
				if (operator.equals("!"))
					return "Boolean_negate(" + expression.toC(context) + ")";
				else if (operator.equals("..."))
					return "Boolean_onward(" + expression.toC(context) + ", 1)";
				else if (operator.equals("<.."))
					return "Boolean_onward(" + expression.toC(context) + ", 0)";
				else if (operator.equals("-"))
						return "Integer_negative(" + expression.toC(context) + ")";
				else if (operator.equals("..."))
					return "Integer_onward(" + expression.toC(context) + ", 1)";
				else if (operator.equals("<.."))
					return "Integer_onward(" + expression.toC(context) + ", 0)";
			}
		} 
		System.out.println(toString());
		System.out.println("EXPRESSION " + expression);
		return expression.getCubexType().name;
		//return "Boolean_negate(" + expression.toC(context) + ")";
	}
	
	@Override
	public ArrayList<IrBind> getExpressions(CGenerationContext context) {
		return new ArrayList<IrBind>();
	}

	@Override
	public CubexTypeGrammar getCubexType() {
		return cubexType;
	}
	
	public String toString(){
		return operator + expression.toString();
	}
	
	@Override
	public void getVars(Set<String> set, Map<String, Set<String>> map) {
		expression.getVars(set, map);
	}

	public boolean equals(Object object){
		if (object instanceof IrUnaryExpression){
			IrUnaryExpression expr = (IrUnaryExpression) object;
			return expression.equals(expr.expression) && operator.equals(expr.operator);
		}
		else {
			return false;
		}
	}
	
	public int hashCode(){
		return toString().hashCode();
	}

	@Override
	public IrExpression eliminateSubexpression(CseContext context) {
		IrExpression expr = getSubexpressions(context);
		if (context.containsExpression(expr)){
			return context.getVariableExpression(expr);
		} else {
			expression = expression.eliminateSubexpression(context);
			return this;
		}
	}

	@Override
	public IrExpression getSubexpressions(CseContext context) {
		return new IrUnaryExpression(expression.getSubexpressions(context), operator, cubexType);
	}
}
