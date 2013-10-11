package parsingTokens.typeGrammar;

import Exception.SemanticException;
import parsingTokens.CubexList;
import typeChecker.CubexCompleteContext;

public abstract class CubexTypeGrammar {
	public String name = "";
	
	public abstract String getName() throws SemanticException;
	
	public CubexList<CubexTypeGrammar> getTypeList(){
		return null;
	}
	
	public boolean equalType(CubexTypeGrammar t) {
		// TODO: IMPLEMENT THIS
		return true;
		
	}
	
	// o.subtype(c, e) must be true if e is a subtype of o in the context of c
	// e :< o
	public boolean subtype(CubexCompleteContext c, CubexTypeGrammar t) throws SemanticException {
		// TODO: IMPLEMENT THIS
		if (equalType(t)) return true;
		if (getName().equals("Thing")) return true;
		if (t.getName().equals("Nothing")) return true;
		if (t instanceof CubexTypeIntersection) {
			CubexTypeIntersection ti = (CubexTypeIntersection) t;
			return subtype(c, ti.typeGrammar1) && subtype(c, ti.typeGrammar2);
		}
		if (this instanceof CubexTypeIntersection) {
			CubexTypeIntersection ti = (CubexTypeIntersection) this;
			return ti.typeGrammar1.subtype(c, t) && ti.typeGrammar2.subtype(c, t);
		}
		if (this instanceof CubexTypeClass && t instanceof CubexTypeClass && name.equals(t.name)) {
			CubexList<CubexTypeGrammar> left = ((CubexTypeClass) this).typeList;
			CubexList<CubexTypeGrammar> right = ((CubexTypeClass) t).typeList;
			if (right.size() != left.size()) return false;
			if (getName().equals("Iterable")) {
				return right.get(0).subtype(c, left.get(0));
			}
			boolean equals = true;
			for (int i=0; i<right.size(); i++) {
				equals = equals && right.get(i).subtype(c, left.get(i)) && left.get(i).subtype(c, right.get(i));
				if (!equals) return false;
			}

			return equals;
		}
		if (t instanceof CubexTypeClass) {
			return true;
		}
		throw new SemanticException("Type check error: checking different type parameters");
	}
	
	public CubexTypeGrammar join(CubexCompleteContext c, CubexTypeGrammar t) throws SemanticException {
		//TODO: IMPLEMENT THIS BETTER
		//If we join with nothing, then return ourself
		if(t == null || t.name.equals("")){ 
			return this; 
		}
		//Without subtypes, if we join things that are not equal or one is of type Thing, we return Thing,
		if(getName().equals("Thing") || t.getName().equals("Thing") || !getName().equals(t.getName())){
			return new CubexTypeName("Thing");
		}
		else {
			return this;
		}
	}
	
	public abstract void validate(CubexCompleteContext c) throws SemanticException;
}
