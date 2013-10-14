package parsingTokens.statements;

import Exception.SemanticException;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;

public final class CubexReturn extends CubexStatement {

	public CubexReturn(CubexExpression e) {
		this.e = e;
	}

	public String toString() {
		return "return " + e.toString() + " ;";
	}
//	public CubexCompleteContext typeCheck(CubexCompleteContext c, boolean bool, CubexTypeClass t) throws SemanticException {
//		//7.9
//		if(bool){
//			return e.typeCheck(c, t);
//		}
//		return this.typeCheck(c, true, t); //Weakening
//	}
	
	public TypeContextReturn typeCheckReturn(CubexCompleteContext c) throws SemanticException {
		CubexCompleteContext copy0 = c.clone();
		copy0.typeContext.noConflictMerge(copy0.mutableTypeContext);
		CubexTypeGrammar etype = e.typeCheck(copy0);

		return new TypeContextReturn(c.mutableTypeContext.clone(), true, etype);
	}
}

