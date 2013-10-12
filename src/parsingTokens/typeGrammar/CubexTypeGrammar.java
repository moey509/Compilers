package parsingTokens.typeGrammar;

import Exception.SemanticException;
import parsingTokens.CubexList;
import typeChecker.ClassContext;
import typeChecker.ClassContextElement;
import typeChecker.CubexCompleteContext;
import typeChecker.TypeContext;

public abstract class CubexTypeGrammar {
	protected String name;
	
	public abstract String getName() throws SemanticException;
	
	public CubexList<CubexTypeGrammar> getTypeList() throws SemanticException {
		throw new SemanticException("No type list in this type");
	}
	
	public abstract boolean equalType(CubexTypeGrammar t) throws SemanticException;
	
	// o.subtype(c, e) must be true if e is a subtype of o in the context of c
	// e :< o
	public boolean subtype(CubexCompleteContext c, CubexTypeGrammar t) throws SemanticException {
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
			ClassContext psi = c.classContext;
			ClassContextElement elem = psi.get(t.getName());
			TypeContext replaceCont = new TypeContext();
			if (elem.kindContext.size() != t.getTypeList().size())
				throw new SemanticException("Type check error: # type params different from that of class/interface");
			for (int i = 0; i<elem.kindContext.size(); i++) {
				replaceCont.put(elem.kindContext.contextSet.get(i), t.getTypeList().get(i));
			}
			
			CubexTypeGrammar retype = elem.type.replaceParams(replaceCont);
			return subtype(c, retype);
		}
		throw new SemanticException("Type check error: checking different type parameters");
	}
	
	
	public CubexTypeGrammar join(CubexCompleteContext c, CubexTypeGrammar t) throws SemanticException {
		//TODO: IMPLEMENT THIS BETTER
		//If we join with nothing, then return ourself
		if(t == null || this.equalType(t)){ 
			return this; 
		}
		//Without subtypes, if we join things that are not equal or one is of type Thing, we return Thing,
//		if(getName().equals("Thing") || t.getName().equals("Thing") || !getName().equals(t.getName())){
//			return new CubexTypeName("Thing");
//		}
//		else {
//			return this;
//		}
		if (subtype(c, t)) return this;
		if (t.subtype(c, this)) return t;

		return null;

	}
	
	public abstract void validate(CubexCompleteContext c) throws SemanticException;

	public abstract CubexTypeGrammar replaceParams(TypeContext cont);
}
