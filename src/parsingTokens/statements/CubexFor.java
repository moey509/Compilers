package parsingTokens.statements;

import ir.statements.IrFor;
import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import parsingTokens.typeGrammar.CubexTypeName;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;

public final class CubexFor extends CubexStatement {
	private String varfun;
	private CubexStatement s;
	private TypeContext freeContext;

	public CubexFor(String varfun, CubexExpression e, CubexStatement s) {
		this.varfun = varfun;
		this.e = e;
		this.s = new CubexListStatement(s.flatten());
	}
	
	public IrFor toIr(IrGenerationContext context) {
		IrFor ir = new IrFor(e.toIr(context), varfun);
		ir.addStatement(s.toIr(context));
		return ir;
	}

	public String toString() {
		String result = "for ( " + varfun + " in " + e.toString() + " ) " + s.toString();
		return result;
	}
	
	public TypeContext typeCheck(CubexCompleteContext c) throws SemanticException {
		freeContext = c.mutableTypeContext;
		// check that varfun is not in scope
		if (c.mutableTypeContext.containsKey(varfun) || c.typeContext.containsKey(varfun))
			throw new SemanticException("CubexFor: varfun exists in scope");

		// check that e returns an Iterable<tau>
		CubexCompleteContext copy0 = c.clone();
		copy0.typeContext.noConflictMerge(copy0.mutableTypeContext);
		CubexTypeGrammar etype = e.typeCheck(copy0);
//		if (!etype.getName().equals("Iterable")) throw new SemanticException("CubexFor: e is not an Iterable");
		CubexList<CubexTypeGrammar> ilist = new CubexList<CubexTypeGrammar>();
		ilist.add(new CubexTypeName("Thing"));
		if (!(new CubexTypeClass("Iterable", ilist)).isSuperTypeOf(copy0, etype)) 
			throw new SemanticException("CubexFor: e is not an Iterable");

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
		freeContext = c.mutableTypeContext;
		// check that varfun is not in scope
		if (c.mutableTypeContext.containsKey(varfun) || c.typeContext.containsKey(varfun))
			throw new SemanticException("CubexFor: varfun exists in scope");

		// check that e returns an Iterable<tau>
		CubexCompleteContext copy0 = c.clone();
		copy0.typeContext.noConflictMerge(copy0.mutableTypeContext);
		CubexTypeGrammar etype = e.typeCheck(copy0);
//		if (!etype.getName().equals("Iterable")) throw new SemanticException("CubexFor: e is not an Iterable");
		CubexList<CubexTypeGrammar> nlist = new CubexList<CubexTypeGrammar>();
		nlist.add(new CubexTypeName("Nothing"));
		CubexTypeClass nclass = new CubexTypeClass("Iterable", nlist);

		CubexList<CubexTypeGrammar> tlist = new CubexList<CubexTypeGrammar>();
		tlist.add(new CubexTypeName("Thing"));
		CubexTypeClass tclass = new CubexTypeClass("Iterable", tlist);
		if (!tclass.isSuperTypeOf(copy0, etype)) 
			throw new SemanticException("CubexFor: e is not an Iterable");


		CubexCompleteContext copy1 = c.clone();
		CubexTypeGrammar vtype = nclass.join(copy1, etype);
		if (etype.getName().equals("String")) vtype = tclass.join(copy1, etype);
		copy1.mutableTypeContext.put(varfun, vtype.getTypeList().get(0));

		TypeContextReturn gamma = s.typeCheckReturn(copy1);
		//if (!gamma.typeContext.containsAll(copy1, c.mutableTypeContext)){
			//throw new SemanticException("CubexFor: Initial content is not a subset of context returned by s");
		//}
		TypeContext ret = gamma.typeContext.containsAll(copy1, c.mutableTypeContext);
		return new TypeContextReturn(ret, false, gamma.retType);
				
		
	}
}


