package parsingTokens.typeGrammar;

import typeChecker.CubexCompleteContext;
import Exception.SemanticException;

public class CubexTypeName extends CubexTypeGrammar{	
	public CubexTypeName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
	public void validate(CubexCompleteContext c) throws SemanticException{
		if (!c.kindContext.contains(name)){
			throw new SemanticException("");
		}
	}

}
