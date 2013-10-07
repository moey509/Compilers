package parsingTokens.typeGrammar;

import Exception.SemanticException;

public abstract class CubexTypeGrammar {
	public String name;
	
	public abstract String getName();
	
	// this equals t
	public boolean equals(CubexTypeGrammar t) throws SemanticException{
		//TODO: IMPLEMENT THIS
		throw new SemanticException("Need to implement CubexTypeGrammar.equals");
	}
}
