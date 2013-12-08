package parsingTokens.comprehension;

import ir.comp.IrComprehension;
import ir.comp.IrComprehensionFor;

import java.util.HashMap;
import java.util.Set;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import parsingTokens.typeGrammar.CubexTypeName;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;

public class CompFor extends Comp {
	private String v;
	
	CubexTypeGrammar cubexType;
//	private Set<String> freeContext;
	
	public CompFor(String v, CubexExpression e, Comp c) {
		this.v = v;
		this.e = e;
		this.comp = c;
	}

	public String toString() {
		return "for ( " + v + " in " + e.toString() + " ) " + comp.toString();
	}

	@Override
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexTypeGrammar exprType = e.typeCheck(c);
		CubexList<CubexTypeGrammar> tempList = new CubexList<CubexTypeGrammar>();
		tempList.add(new CubexTypeName("Thing"));
		if (!(new CubexTypeClass("Iterable", tempList)).isSuperTypeOf(c, exprType)) 
			throw new SemanticException(e.toString() + " must be of type Iterable");
		if (c.containsTypeVariableInMutableTypeContext(v))
			throw new SemanticException(v + " is a variable that has already been declared");
		CubexCompleteContext c1 = c.clone();
		c1.mutableTypeContext.put(v, exprType.getTypeList().get(0));
		//System.out.println(c1.toString());
		cubexType = comp.typeCheck(c1);
		return cubexType;
	}

	@Override
	public void getVars(Set<String> set) {
		set.add(v);
		e.getVars(set);
		if (comp!=null) {
			comp.getVars(set);
		}
	}

	@Override
	public void replaceVars(HashMap<String, String> map) {
		if (map.containsKey(v)) {
			v = map.get(v);
		}
		e.replaceVars(map);
		if (comp!=null) {
			comp.replaceVars(map);
		}
	}

	@Override
	public IrComprehension toIr(IrGenerationContext context) {
		return new IrComprehensionFor(comp.toIr(context), e.toIr(context), v, cubexType);
	}
}
