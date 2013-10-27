package ir.statements;

import java.util.ArrayList;
import ir.expressions.IrExpression;

public final class IrReturn extends IrStatement {

	public IrReturn(IrExpression e) {
		this.e = e;
	}

	@Override
	public ArrayList<String> toC() {
		// TODO Auto-generated method stub
		return null;
	}

}

