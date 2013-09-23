public class CubexTypeName implements CubexTypeGrammar{
	private String name;
	
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
