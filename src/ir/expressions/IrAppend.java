package ir.expressions;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import optimization.LvaContext;
import optimization.CseContext;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import ir.CGenerationContext;
import ir.IrMiscFunctions;
import ir.statements.IrBind;

public class IrAppend implements IrExpression {
	private IrExpression e1, e2;
	private CubexTypeGrammar cubexType;

	public IrAppend(IrExpression expr1, IrExpression expr2, CubexTypeGrammar cubexType) {
		e1 = expr1;
		e2 = expr2;
		this.cubexType = cubexType;
	}
	
	public String toC(CGenerationContext context, String variableName) {
		StringBuilder s = new StringBuilder();
		if(e1 instanceof IrIterableComp){
			s.append(((IrIterableComp) e1).comprehension.toC(context));
		}
		if(e2 instanceof IrIterableComp){
			s.append(((IrIterableComp) e2).comprehension.toC(context));
		}
		return s.toString() + variableName + " = iterable_append(" + e1.toC(context) + ", " + e2.toC(context) +");";
	}
	
	public String toC(CGenerationContext context) {
		return "iterable_append(" + e1.toC(context) + ", " + e2.toC(context) +")";
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
	
	@Override
	public void getVars(Set<String> set, Map<String, Set<String>> map){
		e1.getVars(set, map);
		e2.getVars(set, map);
	}

	public boolean equals(Object object){
		if (object instanceof IrAppend){
			IrAppend expr = (IrAppend) object;
			return e1.equals(expr.e1) && e2.equals(expr.e2);
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
			e1 = e1.eliminateSubexpression(context);
			e2 = e2.eliminateSubexpression(context);
			return this;
		}
	}

	@Override
	public IrExpression getSubexpressions(CseContext context) {
		return new IrAppend(e1.getSubexpressions(context), e2.getSubexpressions(context), cubexType);
	}
	
	public IrExpression clone(){
		return new IrAppend(e1.clone(), e2.clone(), cubexType);
	}
}
