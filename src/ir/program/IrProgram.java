package ir.program;

import ir.CGenerationContext;
import ir.statements.IrBind;
import ir.statements.IrStatement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import typeChecker.TypeContext;

public class IrProgram {
	public List<IrProgramElem> programElementList;
	public ArrayList<String> freeContext; // the immutable variables to be freed at the very end of the program
	
	public IrProgram(){
		programElementList = new ArrayList<IrProgramElem>();
	}
	
	public void setFreeContext(ArrayList<String> fc) {
		freeContext = fc;
	}
	
	public void addStruct(IrStruct struct){
		programElementList.add(struct);
	}
	
	public void addGlobalVariable(IrBind bind){
		programElementList.add(bind);
	}
	
	public void addGlobalFunction(IrFunction function){
		programElementList.add(function);
	}
	
	public void addMainStatement(IrStatement statement){
		programElementList.add(statement);
	}
	
	
	public ArrayList<String> toC(){
		CGenerationContext context = new CGenerationContext();
		ArrayList<String> output = new ArrayList<String>();

		ArrayList<IrFunction> functions = new ArrayList<IrFunction>();
		ArrayList<IrStatement> statements = new ArrayList<IrStatement>();
		ArrayList<IrStruct> structs = new ArrayList<IrStruct>();
		
		for (IrProgramElem i : programElementList) {
			if (i instanceof IrStruct) {
				IrStruct struct = (IrStruct) i;
				structs.add(struct);
			} else if (i instanceof IrFunction) {
				IrFunction func = (IrFunction) i;
				functions.add(func);
			} else if (i instanceof IrStatement) {
				IrStatement st = (IrStatement) i;
				statements.add(st);
			} else {
				System.out.println("IrProgram dun goofd");
			}
		}
		

		for (IrStruct irStruct : structs){
			output.addAll(irStruct.toC(context, false));
		}
//		for (IrTypeTuple tuple : variables){
//			if(!context.variablesDeclaredInScope.contains(tuple.variableName)){
//				output.add("void* " + tuple.variableName + ";");
//				context.variablesDeclaredInScope.add(tuple.variableName);
//			}
//		}
		output.add("iterator_t __it1;");
		output.add("git_t _return;");
		
		for (IrFunction irFunction : functions){
			output.addAll(irFunction.toC(context, false));
		}
		//CUBEX_MAIN
		output.add("void cubex_main(){");
		ArrayList<String> preOut = new ArrayList<String>();
//		for (IrTypeTuple tuple : variables){
//			if(!context.variablesInitializedInScope.contains(tuple.variableName)){
//				postout.add(tuple.variableName + " = NULL;");
//				context.variablesInitializedInScope.add(tuple.variableName);
//			}
//		}

		// use a new varDecl so that population by function statements are not included
		context.varDecl = new HashMap<String, String>();
		for (IrStatement irStatement : statements){
			output.addAll(irStatement.toC(context, true));
		}
		// declare variables here
		for (String s : context.varDecl.keySet()) {
			preOut.add(context.varDecl.get(s) + " " + s + ";");
		}
		output.add("git_t _input = NULL;");
		output.add("_input = get_input();");
		output.add("}");
		preOut.addAll(output);
		return preOut;
	}
}
