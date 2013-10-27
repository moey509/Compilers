package ir.statements;

import java.util.ArrayList;
import ir.expressions.IrExpression;


public final class IrBind extends IrStatement {
	private String classid;
//	CubexExpression e;

	public IrBind(String classid, IrExpression e) {
		this.classid = classid;
		this.e = e;
	}

	@Override
	public ArrayList<String> toC() {
		// TODO Auto-generated method stub
		return null;
	}

	
}