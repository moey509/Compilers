package parsingTokens.typeGrammar;

import parsingTokens.statements.CubexList;

public class CubexTypeClass extends CubexTypeGrammar {
	public CubexList<CubexTypeGrammar> typeList;

	public CubexTypeClass(String name, CubexList<CubexTypeGrammar> typeList) {
		this.name = name;
		this.typeList = typeList;
	}

	public String toString() {
		String rightSpace = typeList.size() == 0 ? "" : " ";
		return name.toString() + " < " + typeList.toString(",") + rightSpace + ">";
	}
}
