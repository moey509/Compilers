package parsingTokens.statements;

import parsingTokens.CubexList;


import parsingTokens.statements.CubexStatement;
import typeChecker.CubexCompleteContext;


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