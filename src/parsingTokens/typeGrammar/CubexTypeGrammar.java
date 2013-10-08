package parsingTokens.typeGrammar;

import parsingTokens.CubexList;

public abstract class CubexTypeGrammar {
	public String name;
	
	public abstract String getName();
	
	public CubexList<CubexTypeGrammar> getTypeList(){
		return null;
	}
	
	// checks for subtyping equals
	// o.equals(e) must be true if e is a subtype of o
	public boolean equals(Object o) {
		// TODO: IMPLEMENT THIS
		return true;
	}
	
	public CubexTypeGrammar join(CubexTypeGrammar t) {
		//TODO: IMPLEMENT THIS
		if (this.equals(t)) return t;
		else return t;
	}
}
