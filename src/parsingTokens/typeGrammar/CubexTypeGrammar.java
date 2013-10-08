package parsingTokens.typeGrammar;

import parsingTokens.CubexList;
import typeChecker.CubexCompleteContext;

public abstract class CubexTypeGrammar {
	public String name = "";
	
	public abstract String getName();
	
	public CubexList<CubexTypeGrammar> getTypeList(){
		return null;
	}
	
	// checks for subtyping equals
	// o.subtype(c, e) must be true if e is a subtype of o in the context of c
	public boolean subtype(CubexCompleteContext c, CubexTypeGrammar t) {
		// TODO: IMPLEMENT THIS
		return true;
	}
	
	public CubexTypeGrammar join(CubexCompleteContext c, CubexTypeGrammar t) {
		//TODO: IMPLEMENT THIS BETTER
		//If we join with nothing, then return ourself
		if(t == null || t.name.equals("")){ 
			return this; 
		}
		//Without subtypes, if we join things that are not equal or one is of type Thing, we return Thing,
		if(name.equals("Thing") || t.name.equals("Thing") || !name.equals(t.name)){
			return new CubexTypeName("Thing");
		}
		else {
			return this;
		}
	}
}
