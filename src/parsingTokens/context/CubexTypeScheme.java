package parsingTokens.context;

import parsingTokens.statements.CubexList;
import parsingTokens.typeGrammar.CubexTypeGrammar;

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

	public String toString() {
		return this.toString(" ");
	}
	
	public String toString(String separator) {
		String rightSpace1 = kindContext.size() == 0 ? "" : " ";
		String rightSpace2 = typeContext.size() == 0 ? "" : " ";
		return "< " + kindContext.toString(separator) + rightSpace1 + "> ( "
				+ typeContext.toString(separator) + rightSpace2 + ") : " + typeGrammar;
	}
}