package ir.program;

import java.util.ArrayList;
import java.util.List;

import ir.CGenerationContext;
import ir.IrType;
import ir.expressions.IrExpression;
import ir.statements.IrBind;
import ir.statements.IrStatement;

public class IrFunction {
	public IrType type;
	public String object;
	public String functionName;
	public List<IrTypeTuple> arguments;
	public List<IrStatement> statements;
	public IrExpression superCall;
	ArrayList<IrBind> tempVariables = new ArrayList<IrBind>();

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
		ArrayList<IrBind> binds = statement.getTemporaryVariables();
		tempVariables.addAll(binds);
		statements.add(statement);
	}
	
	public void addSuperCall(IrExpression expression){
		superCall = expression;
	}
	//TODO: Can structs and functions have the same name
	public ArrayList<String> toC(CGenerationContext context) {
		//Declaration
		ArrayList<String> arr = new ArrayList<String>();
		String s = type.toC() + " " + functionName + "(" + "void** _args" + "){";
		arr.add(s);
		
		//Definition
		for(IrTypeTuple t : arguments){
			s = t.type.toC() + " " + t.variableName + ";";
			arr.add(s);
		}
		//TODO: uhhhh have to know when to reference the struct/
		for(IrBind b : tempVariables){
			arr.add(b.tuple.type.type + " " + b.tuple.variableName + ";");
		}
		for(IrStatement st : statements){
			arr.addAll(st.toC(context));
		}
		if(superCall != null){
			arr.add(superCall.toC(context) + ";");
		}
		arr.add("}");
		return arr;
	}
}
