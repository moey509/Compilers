package ir.statements;

import ir.CGenerationContext;

import java.util.ArrayList;
import java.util.List;

public class IrStatementList implements IrStatement{
	private List<IrStatement> statementList;
	
	public IrStatementList(){
		this.statementList = new ArrayList<IrStatement>();
	}
	
	public IrStatementList(List<IrStatement> statementList) {
		this.statementList = statementList;
	}

	public void addStatement(IrStatement stmt){
		this.statementList.add(stmt);
	}

	@Override
	public ArrayList<String> toC(CGenerationContext context) {
		ArrayList<String> output = new ArrayList<String>();
		for (IrStatement stmt : statementList){
			output.addAll(stmt.toC(context));
		}
		return output;
	}
}
