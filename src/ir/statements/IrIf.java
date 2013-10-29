package ir.statements;

import java.util.ArrayList;
import ir.expressions.IrExpression;

public class IrIf extends IrStatement {
	private IrStatement s1;	//{	s1 }
	private IrStatement s2;	// else {s2}

	// if there is no else statement, let s2 be null
	public IrIf(IrExpression e, IrStatement s1, IrStatement s2) {
		super();
		this.e = e;
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public ArrayList<String> toC() {
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("if(" + e.toC() + ") {");
		arrList.addAll(s1.toC());
		if (s2 == null){
			arrList.add("}");
		}
		else {
			arrList.add("} else {");
			arrList.addAll(s2.toC());
			arrList.add("}");
		}
		return arrList;
	}

}
