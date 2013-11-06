package ir.statements;

import ir.CGenerationContext;

import java.util.ArrayList;
import java.util.List;

public class IrStatementList implements IrStatement{
	private List<IrStatement> statementList;
	private ArrayList<IrBind> temporaryBinds = new ArrayList<IrBind>();
	
	public IrStatementList(){
		this.statementList = new ArrayList<IrStatement>();
	}
	
	public IrStatementList(List<IrStatement> statementList) {
		this.statementList = statementList;
	}

	public void addStatement(IrStatement stmt){
		this.statementList.add(stmt);
	}

	public void addDeclaration(ArrayList<String> arr, CGenerationContext context){
		for(IrStatement s : statementList){
			s.addDeclaration(arr, context);
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
