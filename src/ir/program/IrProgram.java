package ir.program;

import ir.statements.IrBind;
import ir.statements.IrStatement;

import java.util.ArrayList;
import java.util.List;

public class IrProgram {
	public List<IrStruct> structDeclarations;
	public List<IrBind> globalVariables;
	public List<IrFunction> globalFunctions;
	public List<IrStatement> mainFunctionStatements;
	
	public IrProgram(){
		structDeclarations = new ArrayList<IrStruct>();
		globalVariables = new ArrayList<IrBind>();
		globalFunctions = new ArrayList<IrFunction>();
		mainFunctionStatements = new ArrayList<IrStatement>();
	}
	
	public void addStruct(IrStruct struct){
		structDeclarations.add(struct);
	}
	
	public void addGlobalVariable(IrBind bind){
		globalVariables.add(bind);
	}
	
	public void addGlobalFunction(IrFunction function){
		globalFunctions.add(function);
	}
	
	public void addMainStatement(IrStatement statement){
		mainFunctionStatements.add(statement);
	}
	
	
	public ArrayList<String> toC(){
		ArrayList<String> newArrList = new ArrayList<String>();
		// TODO: IR to C stuff.
		return newArrList;
	}
}
