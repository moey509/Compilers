package parsingTokens.program;

import Exception.SemanticException;
import parsingTokens.CubexFunctionDef;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.FunctionContext;


public class CubexProgramFunctionList implements CubexProgramType {
	private CubexList<CubexFunctionDef> functionList;

	public CubexProgramFunctionList(CubexList<CubexFunctionDef> functionList) {
		this.functionList = functionList;
	}

	public String toString() {
		return functionList.toString();
	}

	@Override
	public CubexCompleteContext typeCheck(CubexCompleteContext c) throws SemanticException {
		// Create delta'
		for(int i = 0; i < functionList.size(); i++){
			c.appendFunctionContext(functionList.get(i).name, functionList.get(i).typescheme);
		}
		for(int i = 0; i < functionList.size(); i++){
			//Check to see if function context is valid under the kind context or class context
			//for(CubexTypeGrammar g : c.functionContext.)
			//Check to see if return type is valid under the kind context or class context

			//Check to see if statement is valid under current complete context

			//Check to see if the statement returns the correct type

			//TODO:function typecheck stuff
		}
		
		return c;
	}
}
