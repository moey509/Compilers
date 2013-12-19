package ir.program;

import ir.CGenerationContext;
import ir.statements.IrStatement;
import ir.statements.IrStatementList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import optimization.LvaContext;
import typeChecker.TypeContext;
import optimization.CseContext;

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
	
	public void addComprehensionStruct(IrComprehensionStruct struct) {
		// TODO Auto-generated method stub
		programElementList.add(struct);
	}
	
	public void addGlobalFunction(IrFunction function){
		programElementList.add(function);
	}
	
	public void addMainStatement(IrStatement statement){
		programElementList.add(statement);
	}
	
	
	public ArrayList<String> toC(CGenerationContext context){
//		CGenerationContext context = new CGenerationContext();
		
		// The value of this boolean depends on whether lva is turned off or on.
//		context.lva = true;
		ArrayList<String> output = new ArrayList<String>();
		ArrayList<String> preOut = new ArrayList<String>();
		ArrayList<String> postOut = new ArrayList<String>();
		ArrayList<String> declarations = new ArrayList<String>();

		ArrayList<IrFunction> functions = new ArrayList<IrFunction>();
		ArrayList<IrStatement> statements = new ArrayList<IrStatement>();
		ArrayList<IrStruct> structs = new ArrayList<IrStruct>();
		ArrayList<IrComprehensionStruct> comprehensionStructs = new ArrayList<IrComprehensionStruct>();
		
		for (IrProgramElem i : programElementList) {
			if (i instanceof IrStruct) {
				IrStruct struct = (IrStruct) i;
				structs.add(struct);
			} else if(i instanceof IrComprehensionStruct){
				IrComprehensionStruct struct = (IrComprehensionStruct) i;
				comprehensionStructs.add(struct);
			} else if (i instanceof IrFunction) {
				IrFunction func = (IrFunction) i;
				functions.add(func);
			} else if (i instanceof IrStatement) {
				IrStatement st = (IrStatement) i;
				statements.add(st);
			} else {
//				System.out.println("IrProgram dun goofd");
			}
		}
		
		for (IrStruct irStruct : structs){
			declarations.addAll(irStruct.toC(context, false, null));
		}
		for (IrComprehensionStruct struct : comprehensionStructs){
			declarations.addAll(struct.toC(context, false, null));
		}
		for (IrFunction irFunction : functions){
			declarations.add(irFunction.topDeclaration());
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
			output.addAll(irFunction.toC(context, false, null));
		}
		
		// CUT HERE
		
		
		//CUBEX_MAIN
		output.add("");
		output.add("void cubex_main(){");

		output.add("input = get_input();");
		output.add("ref_increment((General_t)input);");

		
//		for (IrTypeTuple tuple : variables){
//			if(!context.variablesInitializedInScope.contains(tuple.variableName)){
//				postout.add(tuple.variableName + " = NULL;");
//				context.variablesInitializedInScope.add(tuple.variableName);
//			}
//		}

		// use a new varDecl so that population by function statements are not included
		context.varDecl = new HashMap<String, String>();
		context.varInit = new HashMap<String, String>();
		for (IrStatement irStatement : statements){
			postOut.addAll(irStatement.toC(context, true, null));
		}
		
		// put struct and function headers on the top
		preOut.addAll(declarations);
		
		// declare variables at the top
		for (String s : context.varDecl.keySet()) {
			preOut.add(context.varDecl.get(s) + " " + s + ";");
		}
		preOut.add("git_t input = NULL;");
		// initialize variables at the beginning of cubexMain
		for (String s : context.varInit.keySet()) {
			output.add(s + " = " + context.varInit.get(s) + ";");
		}
		//add all statements after the initializations
		output.addAll(postOut);
		output.add("}");
		preOut.addAll(context.comprehensionFunctions);
		preOut.addAll(output);
		return preOut;
	}
	
	public void lva(boolean d) {
		boolean debug = d;
		
		LvaContext c0 = new LvaContext();
		c0.doNotDecrement.add("input");
		HashSet<String> topLevelVarsSoFar = new HashSet<String>();
		ArrayList<IrStatement> statements = new ArrayList<IrStatement>();

		for (IrProgramElem i : programElementList) {
			if (i instanceof IrStatement) {
				IrStatement s = (IrStatement) i;
				topLevelVarsSoFar.addAll(((IrStatement) i).defSet);
				statements.add(s);

			} else if (i instanceof IrFunction) {
				IrFunction f = (IrFunction) i;
				if (f.isToplevel) { // only do if function is not a class method
					// add mapping for the toplevel variables used by this function
					LvaContext c = new LvaContext();
//					c.functionUse.putAll(c0.functionUse);
					c.doNotDecrement = topLevelVarsSoFar;
					
					ArrayList<IrStatement> fcnstatements = new ArrayList<IrStatement>();
					if (f.statements.size() >0) {
						IrStatement statement = f.statements.get(0);
						if (statement instanceof IrStatementList) {
							IrStatementList list = (IrStatementList) statement;
//							fcnstatements.addAll(list.temporaryBinds);
							fcnstatements.addAll(list.statementList);
						} else {
							fcnstatements.addAll(f.statements);
						}
					}

					c.nextList.addAll(fcnstatements);
					c.nextList.removeFirst().topAccessed = true;
					
					for (IrStatement s : fcnstatements) {
						s.populateSets(c);
					}
					
					HashSet<String> topLevelVarsUsed = new HashSet<String>();
					for (IrStatement s : fcnstatements) {
						topLevelVarsUsed.addAll(s.useSet);
					}
					topLevelVarsUsed.retainAll(topLevelVarsSoFar);
					c0.functionUse.put("_" + f.functionName, topLevelVarsUsed);
					
					
					while (c.changed) {
						c.changed = false;
						// lva all function statements
						for (IrStatement s : fcnstatements) {
							s.lva(c);
						}
					}
					
					if (debug) {
						//DEBUG STATEMENTS
						c.debug = true;
						System.out.println(">>>> BEGIN FUNCTION LOOP");
						System.out.println(f.functionName);
						// lva all function statements
						for (IrStatement s : fcnstatements) {
							s.lva(c);
						}
						System.out.println("END FUNCTION LOOP <<<<");
						System.out.println("");
					}
				}
			} // else IrProgramElem is struct, in which case we do nothing
		}
		c0.nextList.addAll(statements);
		c0.nextList.removeFirst().topAccessed = true;
		for (IrStatement s : statements) {
			s.populateSets(c0);
		}
		while (c0.changed) {
			c0.changed = false;
			for (IrStatement s : statements) {
				s.lva(c0);
			}
		}
		
		if (debug) {
			c0.debug = true;
			// DEBUG STATEMENTS
			System.out.println(">>>> BEGIN STATEMENT LOOP");
			for (IrStatement s : statements) {
				s.lva(c0);
			}
			System.out.println("END STATEMENT LOOP <<<<");
			System.out.println("");
		}
	}

	public void removeCommonSubexpressions() {
		CseContext context = new CseContext();
		for (IrProgramElem programElem : programElementList){
			programElem.removeCommonSubexpressions(context);
		}
		context.printContext();
	}

}
