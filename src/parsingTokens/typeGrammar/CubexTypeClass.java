package parsingTokens.typeGrammar;

import java.util.ArrayList;

import Exception.SemanticException;
import parsingTokens.CubexList;
import typeChecker.ClassContextElement;
import typeChecker.CubexCompleteContext;
import typeChecker.TypeContext;

public class CubexTypeClass extends CubexTypeGrammar {
	public CubexList<CubexTypeGrammar> typeList;

	public CubexTypeClass(String name, CubexList<CubexTypeGrammar> typeList) {
		this.name = name;
		this.typeList = typeList;
	}
	
	public String getName(){
		return this.name;
	}
	
	public CubexList<CubexTypeGrammar> getTypeList(){
		return typeList;
	}

	public String toString() {
		String rightSpace = typeList.size() == 0 ? "" : " ";
		return getName().toString() + " < " + typeList.toString(",") + rightSpace + ">";
	}

	public void validate(CubexCompleteContext c) throws SemanticException{
		if (!c.containsClassName(getName())){
			throw new SemanticException("");
		}
	}
	
	public CubexTypeGrammar replaceParams(TypeContext cont){
		CubexList<CubexTypeGrammar> list = new CubexList<CubexTypeGrammar>();
		for (CubexTypeGrammar i : typeList.contextCollection) {
			list.add(i.replaceParams(cont));
		}
		return new CubexTypeClass(getName(), list);
	}
	
	public boolean equalType(CubexTypeGrammar t) throws SemanticException  {
		if (getName().equals("Thing") && t.getName().equals("Thing")) return true;
		if (getName().equals("Nothing") && t.getName().equals("Nothing")) return true;

		if (t instanceof CubexTypeClass) {
			if (!getName().equals(t.getName())) return false;
			CubexList<CubexTypeGrammar> thislist = getTypeList();
			CubexList<CubexTypeGrammar> tlist = t.getTypeList();
			if (thislist.size() != tlist.size()) return false;
			for (int i=0; i<thislist.size(); i++) {
				boolean equals = thislist.get(i).equalType(tlist.get(i));
				if (!equals) return false;
			}
			return true;
		}
		return false;
	}
	
	public ArrayList<CubexTypeClass> joinHelper(CubexCompleteContext c, CubexTypeGrammar t,
		ArrayList<CubexTypeClass> a) throws SemanticException {
		// check for subtyping
		if (isSuperTypeOf(c, t) && !getName().equals("Thing")) {
			a.add(this);
			return a;
		}

		//recursive call
		String nom = getName();
		ClassContextElement elem = c.classContext.get(nom);
		return elem.type.joinHelper(c, t, a);
	}

	

}
