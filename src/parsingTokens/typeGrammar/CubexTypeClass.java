package parsingTokens.typeGrammar;

import parsingTokens.CubexList;

public class CubexTypeClass extends CubexTypeGrammar {
	public CubexList<CubexTypeGrammar> typeList;

	public CubexTypeClass(String name, CubexList<CubexTypeGrammar> typeList) {
		this.name = name;
		this.typeList = typeList;
	}
	
	public CubexList<CubexTypeGrammar> getTypeList(){
		return typeList;
	}

	public String toString() {
		String rightSpace = typeList.size() == 0 ? "" : " ";
		return name.toString() + " < " + typeList.toString(",") + rightSpace + ">";
	}
}
