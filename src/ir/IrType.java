package ir;

public class IrType {

	public String type;

	public IrType(String type) {
		this.type = type;
	}

	public String toC() {
		return type + "_t";
	}

	public String declarationInStruct(){
		return type + "_t";
	}
}
