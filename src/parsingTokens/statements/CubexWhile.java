package parsingTokens.statements;

import ir.statements.IrWhile;
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
		this.s = new CubexListStatement(s.flatten());
	}
	
	public IrWhile toIr() {
		return new IrWhile(e.toIr(), s.toIr());
	}

	public String toString() {
		String s2 = "while ( " + e.toString() + " ) " + s.toString();
		return s2;
	}
	
	public TypeContext typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexCompleteContext copy0 = c.clone();
		copy0.typeContext.noConflictMerge(copy0.mutableTypeContext);
		CubexTypeGrammar etype = e.typeCheck(copy0);
		if (!etype.getName().equals("Boolean")) throw new SemanticException("CubexIf: e is not a boolean");

		TypeContext t = s.typeCheck(c);
		if (!t.entrySet().containsAll(c.mutableTypeContext.entrySet())) {
			throw new SemanticException("CubexWhile: Resultant context does not contain initial context");
		}
		return c.mutableTypeContext.clone();
		
		
	}
	
	public TypeContextReturn typeCheckReturn(CubexCompleteContext c) throws SemanticException {
		CubexCompleteContext copy0 = c.clone();
		copy0.typeContext.noConflictMerge(copy0.mutableTypeContext);
		CubexTypeGrammar etype = e.typeCheck(copy0);
		if (!etype.getName().equals("Boolean")) throw new SemanticException("CubexIf: e is not a boolean");

		TypeContextReturn t = s.typeCheckReturn(c);
		if (!t.typeContext.containsAll(c, c.mutableTypeContext)) {
			throw new SemanticException("CubexWhile: Resultant context does not contain initial context");
		}
		return new TypeContextReturn(c.mutableTypeContext.clone(), false, t.retType);
		
	}
}
