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
		// TODO Auto-generated method stub
		return null;
	}

}
