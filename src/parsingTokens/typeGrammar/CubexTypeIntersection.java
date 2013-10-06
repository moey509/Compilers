package parsingTokens.typeGrammar;
public class CubexTypeIntersection extends CubexTypeGrammar {
	private CubexTypeGrammar name;
	private CubexTypeGrammar name2;

	public CubexTypeIntersection(CubexTypeGrammar typeGrammar1,
			CubexTypeGrammar typeGrammar2) {
		this.name = typeGrammar1;
		this.name2 = typeGrammar2;
	}

	@Override
	public String toString() {
		return name.toString() + " & " + name2.toString();
	}
}
