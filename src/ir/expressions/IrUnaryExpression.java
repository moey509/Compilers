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
		if (operator == null || operator.equals("")) {
			System.out.println("WARNING: operator for unary expression was null or could not be found");
			return null;
		}
		return operator + " (" + expression.toC(context) + ")";
	}
	
	@Override
	public ArrayList<IrBind> getExpressions(CGenerationContext context) {
		// TODO Auto-generated method stub
		return new ArrayList<IrBind>();
	}
}