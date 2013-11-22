package ir.expressions;

import java.util.ArrayList;

import parsingTokens.typeGrammar.CubexTypeGrammar;
import ir.CGenerationContext;
import ir.IrMiscFunctions;
import ir.statements.IrBind;

public class IrAppend implements IrExpression {
	private IrExpression e1, e2;
	private String cType;
	private CubexTypeGrammar cubexType;

	public IrAppend(IrExpression expr1, IrExpression expr2, CubexTypeGrammar cubexType) {
		e1 = expr1;
		e2 = expr2;
		this.cType = IrMiscFunctions.ITERABLE;
		this.cubexType = cubexType;
	}
	
	public String getCType() {
		return cType;
	}
	
	public String toC(CGenerationContext context) {
		return "iterable_append(" + e1.toC(context) + ", " + e2.toC(context) +" )";
	}
	
	@Override
	public ArrayList<IrBind> getExpressions(CGenerationContext context) {
		// TODO Auto-generated method stub
		return new ArrayList<IrBind>();
	}

	@Override
	public CubexTypeGrammar getCubexType() {
		return cubexType;
	}
	
	public String toString(){
		return e1.toString() + "::" + e2.toString();
	}
	
	public boolean equals(IrAppend expr){
		return e1.equals(expr.e1) && e2.equals(expr.e2);
	}
	
	public int hashCode(){
		return toString().hashCode();
	}
}
