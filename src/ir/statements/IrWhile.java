package ir.statements;

import java.util.ArrayList;
import java.util.List;

import ir.expressions.IrExpression;

public final class IrWhile implements IrStatement {
	private IrExpression condition;
	private List<IrStatement> statements;

	public IrWhile(IrExpression condition) {
		this.condition = condition;
		this.statements = new ArrayList<IrStatement>();
	}
	
	public void addStatement(IrStatement statement){
		statements.add(statement);
	}
	
	public void addStatement(List<IrStatement> statement){
		statements.addAll(statement);
	}

	@Override
	public ArrayList<String> toC() {
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("while(" + condition.toC() + ") {");
		for (IrStatement statement : statements){
			arrList.addAll(statement.toC());
		}
		arrList.add("}");
		return arrList;
	}
}
