package parsingTokens.typeGrammar;

import ir.IrType;

import java.util.ArrayList;
import java.util.Iterator;

import Exception.SemanticException;
import parsingTokens.CubexList;
import typeChecker.ClassContext;
import typeChecker.ClassContextElement;
import typeChecker.CubexCompleteContext;
import typeChecker.TypeContext;

// Represents any sort of Cubex Type
public abstract class CubexTypeGrammar {
	public String name;

	// always use getName() to get a type's name
	// always check for "Thing" and "Nothing" using getName, because they can
	// either be CubexTypeName or CubexTypeClass

	public abstract String getName() throws SemanticException;

	// only works for CubexTypeIntersection!
	public CubexList<CubexTypeGrammar> getTypeList() throws SemanticException {
		throw new SemanticException("No type list in this type");
	}

	// check that two types are equal
	public abstract boolean equalType(CubexTypeGrammar t)
			throws SemanticException;

	// TODO: when I check for subtypes, should I also check that the types are
	// valid? or is this handled elsewhere
	// o.subtype(c, e) must be true if e is a subtype of o in the context of c
	// e :< o
	public boolean isSuperTypeOf(CubexCompleteContext c, CubexTypeGrammar t)
			throws SemanticException {
		if (equalType(t))
			return true;
		if (getName().equals("Thing"))
			return true; // Thing is a super type of everything
		if (!(t instanceof CubexTypeIntersection)) {
			if (t.getName().equals("Thing"))
				return false; // Thing isn't a subtype of anything
		}
		if (!(t instanceof CubexTypeIntersection)) {
			if (t.getName().equals("Nothing"))
				return true; // Nothing is a subtype of everything
		}
		if (getName().equals("Nothing"))
			return false; // Nothing isn't a super type of anything
		if (t instanceof CubexTypeIntersection) {
			CubexTypeIntersection ti = (CubexTypeIntersection) t;
			return isSuperTypeOf(c, ti.typeGrammar1)
					|| isSuperTypeOf(c, ti.typeGrammar2);
		}
		if (this instanceof CubexTypeIntersection) {
			CubexTypeIntersection ti = (CubexTypeIntersection) this;
			return ti.typeGrammar1.isSuperTypeOf(c, t)
					&& ti.typeGrammar2.isSuperTypeOf(c, t);
		}
		if (this instanceof CubexTypeClass && t instanceof CubexTypeClass
				&& name.equals(t.name)) {
			CubexList<CubexTypeGrammar> superType = ((CubexTypeClass) this).typeList;
			CubexList<CubexTypeGrammar> subType = ((CubexTypeClass) t).typeList;
			if (superType.size() != subType.size())
				return false;
			if (getName().equals("Iterable")) {
				return superType.get(0).isSuperTypeOf(c, subType.get(0));
			}
			boolean equals = true;
			for (int i = 0; i < superType.size(); i++) {
				equals = equals
						&& superType.get(i).isSuperTypeOf(c, subType.get(i))
						&& subType.get(i).isSuperTypeOf(c, superType.get(i));
				if (!equals)
					return false;
			}

			return equals;
		}
		if (t instanceof CubexTypeClass) {
			ClassContext psi = c.classContext;
			ClassContextElement elem = psi.get(t.getName());
			TypeContext replaceCont = new TypeContext();

			if (elem.kindContext.size() != t.getTypeList().size())
				throw new SemanticException(
						"Type check error: # type params different from that of class/interface");
			for (int i = 0; i < elem.kindContext.size(); i++) {
				replaceCont.put(elem.kindContext.contextSet.get(i), t
						.getTypeList().get(i));
			}
			CubexTypeGrammar retype = elem.type.replaceParams(replaceCont);
			return isSuperTypeOf(c, retype);
		}
		if (t instanceof CubexTypeName) {
			return false;
		}
		throw new SemanticException(
				"Type check error: checking different type parameters");
	}

	// convention: clone the ArrayList when passing to multiple different
	// branches
	// only the first element in the ArrayList can be a Class type
	// ("as opposed to interface")
	public abstract ArrayList<CubexTypeClass> joinHelper(
			CubexCompleteContext c, CubexTypeGrammar t,
			ArrayList<CubexTypeClass> a) throws SemanticException;

	// should NOT be called with a that that has generics that haven't already
	// been replaced with real types
	// convention: go to supertype of this until t is a subtype of this
	public CubexTypeGrammar join(CubexCompleteContext c, CubexTypeGrammar t)
			throws SemanticException {
		// If we join with nothing, then return ourself
		if (t == null || this.equalType(t)) {
			return this;
		}
		// Without subtypes, if we join things that are not equal or one is of
		// type Thing, we return Thing,
		// if(getName().equals("Thing") || t.getName().equals("Thing") ||
		// !getName().equals(t.getName())){
		// return new CubexTypeName("Thing");
		// }
		// else {
		// return this;
		// }

		// if one is a subtype of the other, return the supertype
		if (isSuperTypeOf(c, t))
			return this;
		if (t.isSuperTypeOf(c, this))
			return t;

		// make intersection type out of list of types
		ArrayList<CubexTypeClass> a = joinHelper(c, t,
				new ArrayList<CubexTypeClass>());
		if (a.size()!=0) return buildIntersection(a.iterator());
		// if list is empty, thing is the only superclass of both
		return new CubexTypeName("Thing");

	}

	public static CubexTypeGrammar buildIntersection(
			Iterator<CubexTypeClass> iter) {
		if (iter.hasNext()) {
			CubexTypeClass next = iter.next();
			if (iter.hasNext()) {
				return new CubexTypeIntersection(next, buildIntersection(iter));
			} else {
				return next;
			}
		}
		return null;
	}
	
	public IrType toIrType(){
		return new IrType(name);
	}

	// type validation (figure 4)
	// if !canBeClass, the type that is check for must be an interface
	//   otherwise, it can be either an interface or a class
	//   only relevant for CubexTypeClass
	public abstract void validate(CubexCompleteContext c, boolean canBeClass)
			throws SemanticException;

	// replaces generics with non-generic types
	public abstract CubexTypeGrammar replaceParams(TypeContext cont);
}
