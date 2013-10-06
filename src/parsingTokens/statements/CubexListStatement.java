package parsingTokens.statements;

import parsingTokens.CubexList;

<<<<<<< HEAD:src/parsingTokens/statements/CubexListStatement.java
=======
import parsingTokens.statements.CubexList;
import parsingTokens.statements.CubexStatement;
import typeChecker.CubexCompleteContext;
<<<<<<< HEAD:src/parsingTokens/statements/CubexListStatement.java
>>>>>>> 5832f6138642e0af48d3b41f9a0774ef5499e82f:src/parsingTokens/CubexListStatement.java
=======
>>>>>>> 5832f6138642e0af48d3b41f9a0774ef5499e82f:src/parsingTokens/CubexListStatement.java

public final class CubexListStatement extends CubexStatement {
	private CubexList<CubexStatement> cList;
	public static boolean flatten = false;

	public CubexListStatement(){
		cList = new CubexList<CubexStatement>();
	}
	
	public CubexListStatement(CubexList<CubexStatement> cList) {
		this.cList = cList;
	}

	public String toString() {
		String rightSpace = cList.size() == 0 ? "" : " ";
		if(flatten || (cList.size() == 1)){
			return cList.toString(" ");
		}
		else{
			boolean prev = flatten;
			flatten = true;
			String s = "{ " + cList.toString(" ") + rightSpace + "}";
			flatten = prev;
			return s;
		}
	}

	@Override
	public boolean typeCheck(CubexCompleteContext c) {
		// TODO Auto-generated method stub
		return false;
	}
}