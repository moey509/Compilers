package parsingTokens.typeGrammar;


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

}
