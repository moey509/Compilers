package ir.expressions;

import java.util.ArrayList;

import ir.CGenerationContext;
import ir.IrMiscFunctions;
import ir.statements.IrBind;
import parsingTokens.CubexList;
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
			return ("iterable_append(new_git_obj("+list.get(index).toC(context) +"), NULL)");
		return ("iterable_append(new_git_obj(" + list.get(index).toC(context) + "), " + helper(index+1, context) + ")");
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
}
