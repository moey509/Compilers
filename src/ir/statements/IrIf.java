package ir.statements;

import java.util.ArrayList;
import java.util.List;

import optimization.CseContext;
import typeChecker.CubexCompleteContext;
import ir.CGenerationContext;
import ir.expressions.IrExpression;

public class IrIf implements IrStatement {

	private ArrayList<String> freeContext; //if block
	private ArrayList<String> freeContext2; // else block
	private IrExpression condition;
	private List<IrStatement> statements1; // { s1 }
	private List<IrStatement> statements2; // else {s2}
	public ArrayList<IrBind> temporaryBinds = new ArrayList<IrBind>();
	public CubexCompleteContext context;
	
	// if there is no else statement, let s2 be null
	public IrIf(IrExpression condition, CubexCompleteContext context) {
		this.condition = condition;
		this.statements1 = new ArrayList<IrStatement>();
		this.statements2 = new ArrayList<IrStatement>();
		this.temporaryBinds = new ArrayList<IrBind>();
		this.context = context;
	}
	
	public void addDeclaration(ArrayList<String> arr, CGenerationContext context){
	}
	public void addInitialization(ArrayList<String> arr, CGenerationContext context){
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
	public ArrayList<String> toC(CGenerationContext context, boolean isMain) {
		ArrayList<String> arrList = new ArrayList<String>();
		for(IrBind b : temporaryBinds){
			context.varDecl.put(b.tuple.variableName, b.tuple.type.toC());
			context.varInit.put(b.tuple.variableName, "NULL");
			arrList.addAll(b.toC(context, isMain));
		}
		arrList.add("if(((Boolean_t)" + condition.toC(context) + ")->value) {");
		for(IrBind b : temporaryBinds){
			arrList.add("ref_decrement((General_t)" + b.tuple.variableName + ");");
		}
		for (IrStatement s1 : statements1) {
			arrList.addAll(s1.toC(context, isMain));
		}
		//ref_decrement the discarded variables
		for (String s : freeContext) {
			arrList.add("ref_decrement((General_t)" + s + ");");
		}
		if (statements2.isEmpty()) {
			arrList.add("}");
		} else {
			arrList.add("} else {");
			for (IrStatement s2 : statements2) {
				arrList.addAll(s2.toC(context, isMain));
			}
			//ref_decrement the else discarded variables
			for (String s : freeContext2) {
				arrList.add("ref_decrement((General_t)" + s + ");");
			}
			arrList.add("}");
		}
		return arrList;
	}
/*
	@Override
	public ArrayList<String> toMainC(CGenerationContext context) {
//		ArrayList<String> arrList = new ArrayList<String>();
//		for (IrBind b : temporaryBinds){
//			arrList.addAll(b.toC(context));
//		}
//		arrList.add("if(" + condition.toC(context) + ") {");
//		for(IrBind b : temporaryBinds){
//			arrList.add("ref_decrement((General_t)" + b.tuple.variableName + ");");
//		}
//		for (IrStatement s1 : statements1) {
//			arrList.addAll(s1.toMainC(context));
//		}
//		//ref_decrement the else discarded variables
//		for (String s : freeContext) {
//			arrList.add("ref_decrement((General_t)" + s + ");");
//		}
		if (statements2.isEmpty()) {
			arrList.add("}");
		} else {
			arrList.add("} else {");
			for (IrStatement s2 : statements2) {
				arrList.addAll(s2.toMainC(context));
			}
			//ref_decrement the else discarded variables
			for (String s : freeContext2) {
				arrList.add("ref_decrement((General_t)" + s + ");");
			}
			arrList.add("}");
		}
		return arrList;
	}
	*/
	public ArrayList<IrBind> getTemporaryVariables(){
		return this.temporaryBinds;
	}

	@Override
	public void removeCommonSubexpressions(CseContext context) {
		// TODO Auto-generated method stub
		
	}
}
