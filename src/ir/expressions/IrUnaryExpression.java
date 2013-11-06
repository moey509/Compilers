package ir.expressions;

import java.util.ArrayList;

import ir.CGenerationContext;
import ir.IrMiscFunctions;
import ir.statements.IrBind;

public class IrUnaryExpression implements IrExpression {
	private IrExpression expression;
	private String operator;
	private String type;

	public IrUnaryExpression(IrExpression expression, String operator) {
		super();
		this.expression = expression;
		this.operator = operator;
		
		// logic to determine type:
		if (operator.equals("!"))
			this.type = IrMiscFunctions.BOOLEAN;
		else if (operator.equals("-"))
			this.type = IrMiscFunctions.INTEGER;
		else {
			this.type = null;
			System.out.println("unary operator: " + operator + " could not be found....");
		}
	}
	
	public String getType() {
		return type;
	}

	@Override
	public String toC(CGenerationContext context) {
		if (expression.getType() == "Boolean") {
			if (operator == "!")
				return "boolean_negate(" + expression.toC(context) + ")";
			else if (operator == "...")
				return "boolean_onward(" + expression.toC(context) + ", 1)";
			else if (operator == "<..")
				return "boolean_onward(" + expression.toC(context) + ", 0)";
		} else if (expression.getType() == "Integer") {
			if (operator == "-")
				return "integer_negate(" + expression.toC(context) + ")";
			else if (operator == "...")
				return "integer_onward(" + expression.toC(context) + ", 1)";
			else if (operator == "<..")
				return "integer_onward(" + expression.toC(context) + ", 0)";
		}
			System.out.println("WARNING: operator for unary expression was null or could not be found");
			return null;
	}
	
	@Override
	public ArrayList<IrBind> getExpressions(CGenerationContext context) {
		// TODO Auto-generated method stub
		return new ArrayList<IrBind>();
	}
}