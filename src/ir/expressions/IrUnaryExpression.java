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
	private CubexTypeGrammar cubexType;

	public IrUnaryExpression(IrExpression expression, String operator, CubexTypeGrammar cubexType) {
		super();
		this.expression = expression;
		this.operator = operator;
		this.cubexType = cubexType;
		
	}
	
	public IrExpression clone() {
		return new IrUnaryExpression(expression.clone(), new String(operator), cubexType);
	}

	@Override
	public String toC(CGenerationContext context) {

		/* Boolean case */
		if (operator.equals("!")) {
			return "Boolean_negate(" + expression.toC(context) + ")";
		}
		
		/* Integer Case */
		else if (operator.equals("-")) {
			return "Integer_negative(" + expression.toC(context) + ")";
		}
		
		/* General Case */
		else if (operator.equals("...")) {
			return "General_onwards((General_t)" + expression.toC(context) + ", 1)";
		}
		else if (operator.equals("<..")) {
			return "General_onwards((General_t)" + expression.toC(context) + ", 0)";
		}
		else {
			
			throw new RuntimeException("no such operator (" + operator+")");
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
