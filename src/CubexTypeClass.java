public class CubexTypeClass implements CubexTypeGrammar {
	private String name;
	private CubexList<CubexTypeGrammar> typeList;

	public CubexTypeClass(String name, CubexList<CubexTypeGrammar> typeList) {
		this.name = name;
		this.typeList = typeList;
	}

	public String toString() {
		return name.toString() + " < " + typeList.toString(",") + " >";
	}
}
