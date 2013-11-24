package ir.expressions;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

import optimization.CseContext;
import ir.CGenerationContext;
import ir.IrMiscFunctions;
import ir.statements.IrBind;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public class IrIterable implements IrExpression {
	CubexList<IrExpression> list;
	private String cType;
	private CubexTypeGrammar cubexType;

	public IrIterable(CubexList<IrExpression> listIn, CubexTypeGrammar cubexType) {
		list = listIn;
		this.cType = IrMiscFunctions.ITERABLE;
		this.cubexType = cubexType;
	}

	//git_t i6 = iterable_append(i1, iterable_append(i2, iterable_append(i3, iterable_append(i4, iterable_append(i5, iterable_append(i6, NULL)))));
	public String helper(int index, CGenerationContext context) {
		if (index == list.size()-1) 
			return ("iterable_append("+list.get(index).toC(context) +", NULL)");
		return ("iterable_append(" + list.get(index).toC(context) + ", " + helper(index+1, context) + ")");
	}

	public String getCType() {
		return cType;
	}
	
	public String toC(CGenerationContext context) {
		String temp;
		if (list.size() > 0)
			temp = helper(0, context);
		else 
			temp = "NULL";
		return temp;
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
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (IrExpression expr : list.iterable()){
			if (first){
				first = false;
				sb.append(expr.toString());
			}
			else{
				sb.append(", " + expr.toString());
			}
		}
		return "[" + sb.toString() + "]";
	}
	
	public boolean equals(Object object){
		if (object instanceof IrIterable){
			IrIterable expr = (IrIterable)object;
			Iterator<IrExpression> iter1 = list.iterable().iterator();
			Iterator<IrExpression> iter2 = expr.list.iterable().iterator();
			while (iter1.hasNext() && iter2.hasNext()){
				if (!iter1.next().equals(iter2.next())){
					return false;
				}
			}
			return true;
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
			for (IrExpression expr1 : list.iterable()){
				expr1 = expr1.eliminateSubexpression(context);
			}
			return this;
		}
	}

	@Override
	public IrExpression getSubexpressions(CseContext context) {
		CubexList<IrExpression> lst = new CubexList<IrExpression>();
		for (IrExpression expr : list.iterable()){
			lst.add(expr.getSubexpressions(context));
		}
		return new IrIterable(lst, cubexType);
	}
	
	@Override
	public void getVars(Set<String> set, Map<String, Set<String>> map){
		for (IrExpression e : list.contextCollection) {
			e.getVars(set, map);
		}
	}
}
