public class CubexTypeTuple {
	private String name;
	private CubexTypeGrammar typeGrammar;

	public CubexTypeTuple(String name, CubexTypeGrammar typeGrammar) {
		this.name = name;
		this.typeGrammar = typeGrammar;
	}

	public String toString() {
		return name + " : " + typeGrammar.toString();
	}
}
