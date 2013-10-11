package parsingTokens.typeGrammar;

import typeChecker.CubexCompleteContext;
import Exception.SemanticException;

public class CubexTypeIntersection extends CubexTypeGrammar {
	CubexTypeGrammar typeGrammar1;
	CubexTypeGrammar typeGrammar2;

	public CubexTypeIntersection(CubexTypeGrammar typeGrammar1,
			CubexTypeGrammar typeGrammar2) {
		this.typeGrammar1 = typeGrammar1;
		this.typeGrammar2 = typeGrammar2;
	}
	

	@Override
	public String getName() throws SemanticException {
		throw new SemanticException("CubexTypeIntersection does not have name");
	}

	@Override
	public String toString() {
		return typeGrammar1.toString() + " & " + typeGrammar2.toString();
	}
	
	@Override
	public void validate(CubexCompleteContext c) throws SemanticException {
		// TODO Auto-generated method stub

	}
}
