package parsingTokens.comprehension;

import java.util.HashMap;
import java.util.Set;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import parsingTokens.typeGrammar.CubexTypeName;
import typeChecker.CubexCompleteContext;

public class CompFor extends Comp {
	private String v;
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
		if (comp == null)
			throw new SemanticException("Cannot have a null comprehension following a for");
		CubexCompleteContext c1 = c.clone();
		c1.mutableTypeContext.put(v, exprType.getTypeList().get(0));
		return comp.typeCheck(c1);
	}

	@Override
	public void getVars(Set<String> set) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replaceVars(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		
	}
}
