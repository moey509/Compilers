package ir;

public class IrType {

	public String type;

	public IrType(String type) {
		this.type = type;
	}

	public String toC() {
		if(type == null){
			return "git_t";
		}
		if(type.equals("void*")){
			return type;
		}
		if (type.equals("String"))
			return "git_t";
		else
			return type + "_t";
	}

	public String declarationInStruct(){
		return type + "_t";
	}
}
