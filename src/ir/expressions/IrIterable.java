package ir.expressions;

import parsingTokens.CubexList;

public class IrIterable extends IrExpression {
	CubexList<IrExpression> list;

	public IrIterable(CubexList<IrExpression> listIn) {
		list = listIn;
	}
	
	public String toC() {
		return null;
	}
}
