package ir;

public class IrType {

	public String type;

	public IrType(String type) {
		this.type = type;
	}

	public String toC() {
		if (!type.equals("String"))
			return type + "_t";
		else
			return "git_t";
	}

	public String declarationInStruct(){
		return type + "_t";
	}
}
