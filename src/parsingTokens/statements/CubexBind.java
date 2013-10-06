package parsingTokens.statements;

import Exception.SemanticException;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeClass;
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
	//TODO: handle types that aren't part of the original cubex language
	public CubexCompleteContext typeCheck(CubexCompleteContext c, boolean bool, CubexTypeClass t) throws SemanticException {
		//7.4
		if(!bool){
			return e.typeCheck(c, t);
		}
		throw new SemanticException("");
	}
}