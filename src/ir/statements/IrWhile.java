package ir.statements;

import java.util.ArrayList;
import ir.expressions.IrExpression;

public final class IrWhile extends IrStatement {
	private IrStatement s;

	public IrWhile(IrExpression e, IrStatement s) {
		this.e = e;
		this.s = s;
	}

	@Override
	public ArrayList<String> toC() {
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("while(" + e.toC() + ") {");
		arrList.addAll(s.toC());
		arrList.add("}");
		return arrList;
	}

}
