package ir.statements;

import java.util.ArrayList;
import java.util.List;

import ir.expressions.IrExpression;


public class IrFor implements IrStatement {
	private IrExpression condition;
	private List<IrStatement> statements;

	public IrFor(IrExpression condition) {
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
		// TODO TOSHI DO SOMETHING HERE
		return null;
	}

}


