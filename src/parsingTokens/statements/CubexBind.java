package parsingTokens.statements;

import parsingTokens.expressions.CubexExpression;
import typeChecker.CubexCompleteContext;

public final class CubexBind extends CubexStatement {
	private String classid;

	public CubexBind(String classid, CubexExpression e) {
		this.classid = classid;
		this.e = e;
	}

	public String toString() {
		return classid + " := " + e.toString() + " ;";
	}
	
	public boolean typeCheck(CubexCompleteContext c){
		
		return false;
	}
}