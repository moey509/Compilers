package parsingTokens.context;

import parsingTokens.typeGrammar.CubexTypeGrammar;

public class CubexTypeTuple {
	private String name;
	private CubexTypeGrammar typeGrammar;

	public CubexTypeTuple(String name, CubexTypeGrammar typeGrammar) {
		this.name = name;
		this.typeGrammar = typeGrammar;
	}

	public String getName() {
		return name;
	}

	public CubexTypeGrammar getTypeGrammar() {
		return typeGrammar;
	}

	public String toString() {
		return name + " : " + typeGrammar.toString();
	}
}
