package ir.statements;

import java.util.ArrayList;
import java.util.List;

import ir.expressions.IrExpression;

public class IrIf implements IrStatement {

	private IrExpression condition;
	private List<IrStatement> statements1; // { s1 }
	private List<IrStatement> statements2; // else {s2}

	// if there is no else statement, let s2 be null
	public IrIf(IrExpression condition) {
		this.condition = condition;
		this.statements1 = new ArrayList<IrStatement>();
		this.statements2 = new ArrayList<IrStatement>();
	}

	public void addStatement1(List<IrStatement> statement) {
		statements1.addAll(statement);
	}

	public void addStatement1(IrStatement statement) {
		statements1.add(statement);
	}

	public void addStatement2(List<IrStatement> statement) {
		statements2.addAll(statement);
	}

	public void addStatement2(IrStatement statement) {
		statements2.add(statement);
	}

	@Override
	public ArrayList<String> toC() {
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("if(" + condition.toC() + ") {");
		for (IrStatement s1 : statements1) {
			arrList.addAll(s1.toC());
		}
		if (statements2.isEmpty()) {
			arrList.add("}");
		} else {
			arrList.add("} else {");
			for (IrStatement s2 : statements2) {
				arrList.addAll(s2.toC());
			}
			arrList.add("}");
		}
		return arrList;
	}

}
