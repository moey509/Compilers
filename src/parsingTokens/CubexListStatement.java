package parsingTokens;

import parsingTokens.statements.CubexList;
import parsingTokens.statements.CubexStatement;

public final class CubexListStatement implements CubexStatement {
	private CubexList<CubexStatement> cList;
	public static boolean flatten = false;

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
}