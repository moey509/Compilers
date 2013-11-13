package ir.statements;

import java.util.ArrayList;
import java.util.List;

import typeChecker.TypeContext;
import ir.CGenerationContext;
import ir.expressions.IrExpression;

public final class IrWhile implements IrStatement {
	private ArrayList<String> freeContext = new ArrayList<String>();
	private IrExpression condition;
	private List<IrStatement> statements;
	private ArrayList<IrBind> temporaryBinds;

	public IrWhile(IrExpression condition) {
		this.condition = condition;
		this.statements = new ArrayList<IrStatement>();
		temporaryBinds = new ArrayList<IrBind>();
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
		if (isMain) {
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
		}
		for (IrStatement statement : statements){
			arrList.addAll(statement.toC(context, isMain));
		}
		for (String s : freeContext) {
			arrList.add("ref_decrement((General_t)" + s + ");");
		}
		arrList.add("}");
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
