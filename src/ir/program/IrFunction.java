package ir.program;

import java.util.ArrayList;
import java.util.List;

import ir.statements.IrStatement;

public class IrFunction{
	public String object;
	public String functionName;
	public List<IrTypeTuple> arguments;
	public List<IrStatement> statements;

	public IrFunction(String object, String functionName){
		this.object = (object == null) ? "" : object;
		this.functionName = functionName;
		this.arguments = new ArrayList<IrTypeTuple>();
		this.statements = new ArrayList<IrStatement>();
	}
	
	public IrFunction(String functionName){
		this.object = "";
		this.functionName = functionName;
		this.arguments = new ArrayList<IrTypeTuple>();
		this.statements = new ArrayList<IrStatement>();
	}
	
	public void addFunctionArgument(IrTypeTuple argument){
		arguments.add(argument);
	}
	
	public void addStatement(IrStatement statement){
		statements.add(statement);
	}

	public ArrayList<String> toC() {
		return null;
	}
}
