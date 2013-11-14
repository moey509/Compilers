package ir.statements;

import ir.CGenerationContext;

import java.util.ArrayList;
import java.util.List;

import typeChecker.CubexCompleteContext;

public class IrStatementList implements IrStatement{
	private List<IrStatement> statementList;
	private ArrayList<IrBind> temporaryBinds = new ArrayList<IrBind>();
	public CubexCompleteContext context;
	
	public IrStatementList(CubexCompleteContext context){
		this.statementList = new ArrayList<IrStatement>();
		this.context = context;
	}
	
	public IrStatementList(List<IrStatement> statementList, CubexCompleteContext context) {
		this.statementList = statementList;
		this.context = context;
	}

	public void addStatement(IrStatement stmt){
		this.statementList.add(stmt);
	}

	public void addDeclaration(ArrayList<String> arr, CGenerationContext context){
		for(IrStatement s : statementList){
			s.addDeclaration(arr, context);
		}
	}
	public void addInitialization(ArrayList<String> arr, CGenerationContext context){
		for(IrStatement s : statementList){
			s.addInitialization(arr, context);
		}
	}
	
	@Override
	public ArrayList<String> toC(CGenerationContext context) {
		ArrayList<String> output = new ArrayList<String>();
		for (IrStatement stmt : statementList){
			output.addAll(stmt.toC(context));
		}
		return output;
	}

	@Override
	public ArrayList<String> toMainC(CGenerationContext context) {
		ArrayList<String> output = new ArrayList<String>();
		for (IrStatement stmt : statementList){
			output.addAll(stmt.toMainC(context));
		}
		return output;
	}
	
	public ArrayList<IrBind> getTemporaryVariables(){
		for(IrStatement s : statementList){
			this.temporaryBinds.addAll(s.getTemporaryVariables());
		}
		return this.temporaryBinds;
	}
}
