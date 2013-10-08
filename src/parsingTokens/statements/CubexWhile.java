package parsingTokens.statements;

import Exception.SemanticException;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;

public final class CubexWhile extends CubexStatement {
	private CubexStatement s;

	public CubexWhile(CubexExpression e, CubexStatement s) {
		this.e = e;
		this.s = s;
	}

	public String toString() {
		boolean prev = CubexListStatement.flatten;
		CubexListStatement.flatten = false;
		String s2 = "while ( " + e.toString() + " ) " + s.toString();
		CubexListStatement.flatten = prev;
		return s2;
	}
	
	public TypeContext typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexCompleteContext copy0 = c.clone();
		copy0.typeContext.noConflictMerge(copy0.mutableTypeContext);
		CubexTypeGrammar etype = e.typeCheck(copy0);
		if (!etype.name.equals("Boolean")) throw new SemanticException("CubexIf: e is not a boolean");

		TypeContext t = s.typeCheck(c);
		if (!t.entrySet().containsAll(c.mutableTypeContext.entrySet())) {
			throw new SemanticException("CubexWhile: Resultant context does not contain initial context");
		}
		return c.typeContext.clone();
		
		
	}
	
	public TypeContextReturn typeCheckReturn(CubexCompleteContext c) throws SemanticException {
		CubexCompleteContext copy0 = c.clone();
		copy0.typeContext.noConflictMerge(copy0.mutableTypeContext);
		CubexTypeGrammar etype = e.typeCheck(copy0);
		if (!etype.name.equals("Boolean")) throw new SemanticException("CubexIf: e is not a boolean");

		TypeContextReturn t = s.typeCheckReturn(c);
		if (!t.typeContext.containsAll(c, c.mutableTypeContext)) {
			throw new SemanticException("CubexWhile: Resultant context does not contain initial context");
		}
		return new TypeContextReturn(c.typeContext.clone(), false, t.retType);
		
	}
}
