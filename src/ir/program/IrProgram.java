package ir.program;

import ir.CGenerationContext;
import ir.statements.IrBind;
import ir.statements.IrStatement;

import java.util.ArrayList;
import java.util.List;

import typeChecker.TypeContext;

public class IrProgram {
	public List<IrStruct> structDeclarations;
	public List<IrTypeTuple> globalVariables;
	public List<IrFunction> globalFunctions;
	public List<IrStatement> mainFunctionStatements;
	public ArrayList<String> freeContext; // the immutable variables to be freed at the very end of the program
	
	public IrProgram(){
		structDeclarations = new ArrayList<IrStruct>();
		globalVariables = new ArrayList<IrTypeTuple>();
		globalFunctions = new ArrayList<IrFunction>();
		mainFunctionStatements = new ArrayList<IrStatement>();
	}
	
	public void setFreeContext(ArrayList<String> fc) {
		freeContext = fc;
	}
	
	public void addStruct(IrStruct struct){
		structDeclarations.add(struct);
	}
	
	public void addGlobalVariable(IrBind bind){
		globalVariables.add(bind.tuple);
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
		for (IrTypeTuple tuple : globalVariables){
			if(!context.variablesDeclaredInScope.contains(tuple.variableName)){
				output.add("void* " + tuple.variableName + ";");
				context.variablesDeclaredInScope.add(tuple.variableName);
			}
		}
		output.add("iterator_t _it1;");
		output.add("iterator_t _return;");
		
		for (IrFunction irFunction : globalFunctions){
			output.addAll(irFunction.toC(context));
		}
		output.add("void cubex_main(){");
		output.add("git_t _input = NULL;");
		output.add("_input = get_input(_input);");
		for (IrTypeTuple tuple : globalVariables){
			if(!context.variablesInitializedInScope.contains(tuple.variableName)){
				output.add(tuple.variableName + " = NULL;");
				context.variablesInitializedInScope.add(tuple.variableName);
			}
		}
		for (IrStatement irStatement : mainFunctionStatements){
			output.addAll(irStatement.toMainC(context));
		}
		output.add("}");
		return output;
	}
}
