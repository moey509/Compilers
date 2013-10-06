package parsingTokens.program;

import parsingTokens.CubexList;
import parsingTokens.expressions.CubexFunctionDef;
<<<<<<< HEAD
=======
import parsingTokens.statements.CubexList;
import typeChecker.CubexCompleteContext;
>>>>>>> 5832f6138642e0af48d3b41f9a0774ef5499e82f

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
