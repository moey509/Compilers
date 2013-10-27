package ir.statements;

import java.util.ArrayList;
import ir.expressions.IrExpression;


public class IrFor extends IrStatement {
	private String varfun;
	private IrStatement s;

	public IrFor(String varfun, IrExpression e, IrStatement s) {
		this.varfun = varfun;
		this.e = e;
		this.s = s;
	}

	@Override
	public ArrayList<String> toC() {
		// TODO Auto-generated method stub
		return null;
	}

}


