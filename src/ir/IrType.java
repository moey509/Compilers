package ir;

public class IrType {

	public String type;

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

	public String declarationInStruct(){
		if (type == "Integer")
			return "int";
		if (type == "Character")
			return "char";
		if (type == "String")
			return "char*";
		
		return "struct *" + type;
	}
}
