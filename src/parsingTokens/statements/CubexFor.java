package parsingTokens.statements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import ir.expressions.IrVariableExpression;
import ir.program.IrTypeTuple;
import ir.statements.IrBind;
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
	private Set<String> freeContext;
	
	CubexCompleteContext cubexContext;

	public CubexFor(String varfun, CubexExpression e, CubexStatement s) {
		this.varfun = varfun;
		this.e = e;
		this.s = new CubexListStatement(s.flatten());
	}
	
	public IrFor toIr(IrGenerationContext context) {
		ArrayList<IrBind> arr = e.getExpressions(context);
		if(arr.size() == 0){
			IrFor ir = new IrFor(varfun, e.toIr(context), cubexContext);
			ir.addStatement(s.toIr(context));
			ir.setFreeContext(new ArrayList<String>(freeContext));
			ir.temporaryBinds.addAll(arr);
			return ir;
		}
		else{
			IrBind b = arr.get(arr.size()-1);
			IrFor ir = new IrFor(varfun, new IrVariableExpression(b.tuple.variableName, b.tuple.type.type), cubexContext);
			ir.temporaryBinds.addAll(arr);
			ir.addStatement(s.toIr(context));
			ir.setFreeContext(new ArrayList<String>(freeContext));
			return ir;
		}
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
		freeContext = gamma.keySet();
		freeContext.remove(varfun);
		freeContext.removeAll(c.mutableTypeContext.keySet());
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
		freeContext = gamma.typeContext.keySet();
		freeContext.remove(varfun);
		freeContext.removeAll(c.mutableTypeContext.keySet());
		
		TypeContextReturn temp = new TypeContextReturn(ret, false, gamma.retType);
		cubexContext = c.clone();
		return temp;
				
		
	}

	@Override
	public void replaceVars(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		
	}
}


