package parsingTokens.typeGrammar;

import parsingTokens.CubexList;

public abstract class CubexTypeGrammar {
	public String name;
	
	public abstract String getName();
	public CubexList<CubexTypeGrammar> getTypeList(){
		return null;
	}
}
