package ir.program;

import java.util.ArrayList;
import java.util.List;

import ir.IrType;
import ir.statements.IrStatement;

public class IrFunction {
	public IrType type;
	public String object;
	public String functionName;
	public List<IrTypeTuple> arguments;
	public List<IrStatement> statements;

	public IrFunction(IrType type, String object, String functionName) {
		this.type = type;
		this.object = (object == null) ? "" : object;
		this.functionName = functionName;
		this.arguments = new ArrayList<IrTypeTuple>();
		this.statements = new ArrayList<IrStatement>();
	}

	public IrFunction(IrType type, String functionName) {
		this.type = type;
		this.object = "";
		this.functionName = functionName;
		this.arguments = new ArrayList<IrTypeTuple>();
		this.statements = new ArrayList<IrStatement>();
	}

	public void addFunctionArgument(IrTypeTuple argument) {
		arguments.add(argument);
	}

	public void addStatement(IrStatement statement) {
		statements.add(statement);
	}

	public ArrayList<String> toC() {
		return null;
	}
}
