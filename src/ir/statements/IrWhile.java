package ir.statements;

import ir.CGenerationContext;
import ir.expressions.IrExpression;

import java.util.ArrayList;
import java.util.List;

import typeChecker.CubexCompleteContext;

public final class IrWhile implements IrStatement {
	private ArrayList<String> freeContext = new ArrayList<String>();
	private IrExpression condition;
	private List<IrStatement> statements;
	private ArrayList<IrBind> temporaryBinds;
	public CubexCompleteContext context;

	public IrWhile(IrExpression condition, CubexCompleteContext context) {
		this.condition = condition;
		this.statements = new ArrayList<IrStatement>();
		this.temporaryBinds = new ArrayList<IrBind>();
		this.context = context;
	}
	
	public void addDeclaration(ArrayList<String> arr, CGenerationContext context){
	}
	public void addInitialization(ArrayList<String> arr, CGenerationContext context){
	}
	
	public void setFreeContext(ArrayList<String> fc) {
		freeContext = fc;
	}
	
	public void addStatement(IrStatement statement){
		statements.add(statement);
	}
	
	public void addStatement(List<IrStatement> statement){
		statements.addAll(statement);
	}

	@Override
	public ArrayList<String> toC(CGenerationContext context, boolean isMain) {
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("while(" + condition.toC(context) + ") {");
		for (IrBind i : temporaryBinds) {
			context.varDecl.put(i.tuple.variableName, i.tuple.type.toC());
			context.varInit.put(i.tuple.variableName, "NULL");
		}
		if (isMain) {
			for(IrStatement s : statements){
				for(IrBind b : s.getTemporaryVariables()){
					b.addDeclaration(arrList, context);
					b.addInitialization(arrList, context);
				}
				s.addDeclaration(arrList, context);
				s.addInitialization(arrList, context);
			}
		}
		for (IrStatement statement : statements){
			arrList.addAll(statement.toC(context, isMain));
		}
		arrList.add("}");

		for (String s : freeContext) {
			arrList.add("ref_decrement((General_t)" + s + ");");
		}

		return arrList;
	}
/*
	@Override
	public ArrayList<String> toMainC(CGenerationContext context) {
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("while(" + condition.toC(context) + ") {");
		
		for(IrStatement s : statements){
			for(IrBind b : s.getTemporaryVariables()){
				b.addDeclaration(arrList, context);
			}
			s.addDeclaration(arrList, context);
		}
		for(IrStatement s : statements){
			for(IrBind b : s.getTemporaryVariables()){
				b.addInitialization(arrList, context);
			}
			s.addInitialization(arrList, context);
		}

//		for (IrStatement statement : statements){
//			arrList.addAll(statement.toMainC(context));
//		}
//		for (String s : freeContext) {
//			arrList.add("ref_decrement((General_t)" + s + ");");
//		}
		//arrList.add("}");
		//return arrList;
	}
	*/
	public ArrayList<IrBind> getTemporaryVariables(){
		return this.temporaryBinds;
	}
}
