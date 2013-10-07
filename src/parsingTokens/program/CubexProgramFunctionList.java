package parsingTokens.program;

import Exception.SemanticException;
import parsingTokens.CubexFunctionDef;
import parsingTokens.CubexList;
import typeChecker.CubexCompleteContext;


public class CubexProgramFunctionList implements CubexProgramType {
	private CubexList<CubexFunctionDef> functionList;

	public CubexProgramFunctionList(CubexList<CubexFunctionDef> functionList) {
		this.functionList = functionList;
	}

	public String toString() {
		return functionList.toString();
	}

	@Override
	public void typeCheck(CubexCompleteContext c) throws SemanticException {
		// TODO Auto-generated method stub
		throw new SemanticException("");
	}
}
