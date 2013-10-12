package parsingTokens.typeGrammar;

import typeChecker.CubexCompleteContext;
import typeChecker.TypeContext;
import Exception.SemanticException;

public class CubexTypeIntersection extends CubexTypeGrammar {
	CubexTypeGrammar typeGrammar1;
	CubexTypeGrammar typeGrammar2;

	public CubexTypeIntersection(CubexTypeGrammar typeGrammar1,
			CubexTypeGrammar typeGrammar2) {
		this.typeGrammar1 = typeGrammar1;
		this.typeGrammar2 = typeGrammar2;
	}
	

	@Override
	public String getName() throws SemanticException {
		throw new SemanticException("CubexTypeIntersection does not have name");
	}

	@Override
	public String toString() {
		return typeGrammar1.toString() + " & " + typeGrammar2.toString();
	}
	
	@Override
	public void validate(CubexCompleteContext c) throws SemanticException {
		// TODO: Might need to change later
		throw new SemanticException("CubexTypeIntersection does not implement validate");
	}
	
	public CubexTypeGrammar replaceParams(TypeContext cont) {
		CubexTypeGrammar t1 = typeGrammar1.replaceParams(cont);
		CubexTypeGrammar t2 = typeGrammar2.replaceParams(cont);
		return new CubexTypeIntersection(t1, t2);
	}
	
	public boolean equalType(CubexTypeGrammar t) throws SemanticException {
		if (t instanceof CubexTypeIntersection) {
			CubexTypeIntersection t1 = (CubexTypeIntersection) t;
			return typeGrammar1.equalType(t1.typeGrammar1) && typeGrammar2.equalType(t1.typeGrammar2);
		}
		return false;
	}
}
