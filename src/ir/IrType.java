package ir;

public class IrType {

	private String type;

	public IrType(String type) {
		this.type = type;
	}

	public String toC() {
		if (type == "Integer")
			return "int";
		if (type == "Character")
			return "char";
		if (type == "String")
			return "char*";
		else
			return type;
	}
}
