package ir.expressions;

import ir.CGenerationContext;
import ir.statements.IrBind;

import java.util.ArrayList;

import optimization.CseContext;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public class IrPrimitiveInt implements IrExpression {
	private int value;
	
	public IrPrimitiveInt(int value){
		this.value = value;
	}

	@Override
	public String getCType() {
		return "int";
	}

	@Override
	public CubexTypeGrammar getCubexType() {
		return new CubexTypeClass("Integer", new CubexList<CubexTypeGrammar>());
	}

	@Override
	public String toC(CGenerationContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<IrBind> getExpressions(CGenerationContext context) {
		return new ArrayList<IrBind>();
	}

	@Override
	public IrExpression eliminateSubexpression(CseContext context) {
		IrExpression expr = getSubexpressions(context);
		if (context.containsExpression(expr)){
			return context.getVariableExpression(expr);
		} else {
			return this;
		}
	}

	@Override
	public IrExpression getSubexpressions(CseContext context) {
		return new IrPrimitiveInt(value);
	}

}
