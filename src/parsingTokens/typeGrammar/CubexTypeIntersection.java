package parsingTokens.typeGrammar;
public class CubexTypeIntersection extends CubexTypeGrammar {
	private CubexTypeGrammar typeGrammar1;
	private CubexTypeGrammar typeGrammar2;

	public CubexTypeIntersection(CubexTypeGrammar typeGrammar1,
			CubexTypeGrammar typeGrammar2) {
		this.typeGrammar1 = typeGrammar1;
		this.typeGrammar2 = typeGrammar2;
	}
	

	@Override
	public String getName() {
		// TODO IMPLEMENT THIS
		return typeGrammar1.getName();
	}

	@Override
	public String toString() {
		return typeGrammar1.toString() + " & " + typeGrammar2.toString();
	}
}
