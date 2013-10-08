package parsingTokens.typeGrammar;

import parsingTokens.CubexList;

public abstract class CubexTypeGrammar {
	public String name = "";
	
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
