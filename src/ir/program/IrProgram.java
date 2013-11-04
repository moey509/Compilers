package ir.program;

import ir.CGenerationContext;
import ir.statements.IrBind;
import ir.statements.IrStatement;

import java.util.ArrayList;
import java.util.List;

public class IrProgram {
	public List<IrStruct> structDeclarations;
	public List<String> globalVariables;
	public List<IrFunction> globalFunctions;
	public List<IrStatement> mainFunctionStatements;
	
	public IrProgram(){
		structDeclarations = new ArrayList<IrStruct>();
		globalVariables = new ArrayList<String>();
		globalFunctions = new ArrayList<IrFunction>();
		mainFunctionStatements = new ArrayList<IrStatement>();
	}
	
	public void addStruct(IrStruct struct){
		structDeclarations.add(struct);
	}
	
	public void addGlobalVariable(IrBind bind){
		globalVariables.add("void* _" + bind.tuple.variableName + ";");
	}
	
	public void addGlobalFunction(IrFunction function){
		globalFunctions.add(function);
	}
	
	public void addMainStatement(IrStatement statement){
		mainFunctionStatements.add(statement);
	}
	
	
	public ArrayList<String> toC(){
		CGenerationContext context = new CGenerationContext();
		ArrayList<String> output = new ArrayList<String>();
		for (IrStruct irStruct : structDeclarations){
			output.addAll(irStruct.toC(context));
		}
		for (String irBind : globalVariables){
			output.add(irBind);
		}
		for (IrFunction irFunction : globalFunctions){
			output.addAll(irFunction.toC(context));
		}
		output.add("int main(){");
		for (IrStatement irStatement : mainFunctionStatements){
			output.addAll(irStatement.toC(context));
		}
		output.add("}");
		return output;
	}
}
