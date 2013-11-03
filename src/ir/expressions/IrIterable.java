package ir.expressions;

import ir.CGenerationContext;
import parsingTokens.CubexList;

public class IrIterable implements IrExpression {
	CubexList<IrExpression> list;

	public IrIterable(CubexList<IrExpression> listIn) {
		list = listIn;
	}

	//git_t i6 = iterable_append(i1, iterable_append(i2, iterable_append(i3, iterable_append(i4, iterable_append(i5, iterable_append(i6, NULL)))));
	public String helper(int index, CGenerationContext context) {
		if (index == list.size()-1) 
			return ("iterable_append("+list.get(index).toC(context) +", NULL)");
		return ("iterable_append(" + list.get(index).toC(context) + ", " + helper(index+1, context) + ")");
	}

	
	public String toC(CGenerationContext context) {
		String temp;
		if (list.size() > 0)
			temp = helper(0, context);
		else 
			temp = "NULL";
		return temp;
	}
}
