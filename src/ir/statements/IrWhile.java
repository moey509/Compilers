package ir.statements;

import java.util.ArrayList;
import java.util.List;

import typeChecker.TypeContext;
import ir.CGenerationContext;
import ir.expressions.IrExpression;

public final class IrWhile implements IrStatement {
	private TypeContext freeContext;
	private IrExpression condition;
	private List<IrStatement> statements;

	public IrWhile(IrExpression condition, TypeContext fc) {
		this.condition = condition;
		this.statements = new ArrayList<IrStatement>();
		this.freeContext = fc;
	}
	
	public void addStatement(IrStatement statement){
		statements.add(statement);
	}
	
	public void addStatement(List<IrStatement> statement){
		statements.addAll(statement);
	}

	@Override
	public ArrayList<String> toC(CGenerationContext context) {
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("while(" + condition.toC(context) + ") {");
		for (IrStatement statement : statements){
			arrList.addAll(statement.toC(context));
		}
		arrList.add("}");
		return arrList;
	}

	@Override
	public ArrayList<String> toMainC(CGenerationContext context) {
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("while(" + condition.toC(context) + ") {");
		for (IrStatement statement : statements){
			arrList.addAll(statement.toMainC(context));
		}
		arrList.add("}");
		return arrList;
	}
}
