package parsingTokens.typeGrammar;

import parsingTokens.CubexList;
import typeChecker.CubexCompleteContext;

public abstract class CubexTypeGrammar {
	public String name;
	
	public abstract String getName();
	
	public CubexList<CubexTypeGrammar> getTypeList(){
		return null;
	}
	
	// checks for subtyping equals
	// o.subtype(e) must be true if e is a subtype of o
	public boolean subtype(CubexCompleteContext c, CubexTypeGrammar t) {
		// TODO: IMPLEMENT THIS
		return true;
	}
	
	public CubexTypeGrammar join(CubexCompleteContext c, CubexTypeGrammar t) {
		//TODO: IMPLEMENT THIS
		if (this.subtype(c, t)) return t;
		else return t;
	}
}
