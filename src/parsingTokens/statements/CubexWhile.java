package parsingTokens.statements;

import ir.statements.IrWhile;
import Exception.SemanticException;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;

public final class CubexWhile extends CubexStatement {
	private CubexStatement s;
	private TypeContext freeContext;

	public CubexWhile(CubexExpression e, CubexStatement s) {
		this.e = e;
		this.s = new CubexListStatement(s.flatten());
	}
	
	public IrWhile toIr(IrGenerationContext context) {
		IrWhile ir = new IrWhile(e.toIr(context), freeContext);
		ir.addStatement(s.toIr(context));
		return ir;
	}

	public String toString() {
		String s2 = "while ( " + e.toString() + " ) " + s.toString();
		return s2;
	}
	
	public TypeContext typeCheck(CubexCompleteContext c) throws SemanticException {
		freeContext = c.mutableTypeContext;
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
		freeContext = c.mutableTypeContext;
		CubexCompleteContext copy0 = c.clone();
		copy0.typeContext.noConflictMerge(copy0.mutableTypeContext);
		CubexTypeGrammar etype = e.typeCheck(copy0);
		if (!etype.getName().equals("Boolean")) throw new SemanticException("CubexIf: e is not a boolean");

		TypeContextReturn t = s.typeCheckReturn(c);
//		if (!t.typeContext.containsAll(c, c.mutableTypeContext)) {
//			throw new SemanticException("CubexWhile: Resultant context does not contain initial context");
//		}
		TypeContext ret = t.typeContext.containsAll(c, c.mutableTypeContext);
		return new TypeContextReturn(ret, false, t.retType);
		
	}
}
