public class CubexTypeScheme {
	private CubexList<String> kindContext;
	private CubexList<CubexTypeTuple> typeContext;
	private CubexTypeGrammar typeGrammar;

	public CubexTypeScheme(CubexList<String> kindContext,
			CubexList<CubexTypeTuple> typeContext, CubexTypeGrammar typeGrammar) {
		this.kindContext = kindContext;
		this.typeContext = typeContext;
		this.typeGrammar = typeGrammar;
	}

	public String toString(String separator) {
		return "<" + kindContext.toString(separator) + ">("
				+ typeContext.toString(separator) + ") : " + typeGrammar;
	}
}
