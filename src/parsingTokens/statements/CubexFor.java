package parsingTokens.statements;

import context.IrContext;
import ir.statements.IrFor;
import Exception.SemanticException;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;

public final class CubexFor extends CubexStatement {
	private String varfun;
	private CubexStatement s;

	public CubexFor(String varfun, CubexExpression e, CubexStatement s) {
		this.varfun = varfun;
		this.e = e;
		this.s = new CubexListStatement(s.flatten());
	}
	
	public IrFor toIr(IrContext context) {
		return new IrFor(varfun, e.toIr(context), s.toIr(context));
	}

	public String toString() {
		String result = "for ( " + varfun + " in " + e.toString() + " ) " + s.toString();
		return result;
	}
	
	public TypeContext typeCheck(CubexCompleteContext c) throws SemanticException {
		// check that varfun is not in scope
		if (c.mutableTypeContext.containsKey(varfun) || c.typeContext.containsKey(varfun))
			throw new SemanticException("CubexFor: varfun exists in scope");

		// check that e returns an Iterable<tau>
		CubexCompleteContext copy0 = c.clone();
		copy0.typeContext.noConflictMerge(copy0.mutableTypeContext);
		CubexTypeGrammar etype = e.typeCheck(copy0);
		if (!etype.getName().equals("Iterable")) throw new SemanticException("CubexFor: e is not an Iterable");

		CubexCompleteContext copy1 = c.clone();
		copy1.mutableTypeContext.put(varfun, etype.getTypeList().get(0));
		TypeContext gamma = s.typeCheck(copy1);
		//if (!gamma.containsAll(copy1, c.mutableTypeContext))
			//throw new SemanticException("CubexFor: Initial content is not a subset of context returned by s");

		if (!gamma.keySet().containsAll(c.mutableTypeContext.keySet())) {
			throw new SemanticException("CubexFor: TypeContexts are not subtypes");
		}
		return c.mutableTypeContext.clone();
		
		
	}
	
	public TypeContextReturn typeCheckReturn(CubexCompleteContext c) throws SemanticException {
		// check that varfun is not in scope
		if (c.mutableTypeContext.containsKey(varfun) || c.typeContext.containsKey(varfun))
			throw new SemanticException("CubexFor: varfun exists in scope");

		// check that e returns an Iterable<tau>
		CubexCompleteContext copy0 = c.clone();
		copy0.typeContext.noConflictMerge(copy0.mutableTypeContext);
		CubexTypeGrammar etype = e.typeCheck(copy0);
		if (!etype.getName().equals("Iterable")) throw new SemanticException("CubexFor: e is not an Iterable");

		CubexCompleteContext copy1 = c.clone();
		copy1.mutableTypeContext.put(varfun, etype.getTypeList().get(0));

		TypeContextReturn gamma = s.typeCheckReturn(copy1);
		//if (!gamma.typeContext.containsAll(copy1, c.mutableTypeContext)){
			//throw new SemanticException("CubexFor: Initial content is not a subset of context returned by s");
		//}
		TypeContext ret = gamma.typeContext.containsAll(copy1, c.mutableTypeContext);
		return new TypeContextReturn(ret, false, gamma.retType);
				
		
	}
}


