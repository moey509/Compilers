package parsingTokens.program;

import parsingTokens.CubexList;
import parsingTokens.expressions.CubexFunctionDef;
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
	public boolean typeCheck(CubexCompleteContext c) {
		// TODO Auto-generated method stub
		return false;
	}
}
