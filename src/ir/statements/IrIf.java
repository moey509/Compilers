package ir.statements;

import java.util.ArrayList;
import java.util.List;

import typeChecker.TypeContext;
import ir.CGenerationContext;
import ir.expressions.IrExpression;

public class IrIf implements IrStatement {

	private ArrayList<String> freeContext; //if block
	private ArrayList<String> freeContext2; // else block
	private IrExpression condition;
	private List<IrStatement> statements1; // { s1 }
	private List<IrStatement> statements2; // else {s2}
	private ArrayList<IrBind> temporaryBinds = new ArrayList<IrBind>();
	
	// if there is no else statement, let s2 be null
	public IrIf(IrExpression condition) {
		this.condition = condition;
		this.statements1 = new ArrayList<IrStatement>();
		this.statements2 = new ArrayList<IrStatement>();
	}
	
	public void setFreeContext(ArrayList<String> fc, ArrayList<String> fc2) {
		freeContext = fc;
		freeContext2 = fc2;
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
	public ArrayList<String> toC(CGenerationContext context) {
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("if(" + condition.toC(context) + ") {");
		for (IrStatement s1 : statements1) {
			arrList.addAll(s1.toC(context));
		}
		if (statements2.isEmpty()) {
			arrList.add("}");
		} else {
			arrList.add("} else {");
			for (IrStatement s2 : statements2) {
				arrList.addAll(s2.toC(context));
			}
			arrList.add("}");
		}
		return arrList;
	}

	@Override
	public ArrayList<String> toMainC(CGenerationContext context) {
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("if(" + condition.toC(context) + ") {");
		for (IrStatement s1 : statements1) {
			arrList.addAll(s1.toMainC(context));
		}
		if (statements2.isEmpty()) {
			arrList.add("}");
		} else {
			arrList.add("} else {");
			for (IrStatement s2 : statements2) {
				arrList.addAll(s2.toMainC(context));
			}
			arrList.add("}");
		}
		return arrList;
	}
	public ArrayList<IrBind> getTemporaryVariables(){
		return this.temporaryBinds;
	}
}
