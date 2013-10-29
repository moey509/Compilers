package ir.statements;

import java.util.ArrayList;
import ir.expressions.IrExpression;

public final class IrReturn extends IrStatement {

	public IrReturn(IrExpression e) {
		this.e = e;
	}

	@Override
	public ArrayList<String> toC() {
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("return " + e.toC());
		return arrList;
	}

}

