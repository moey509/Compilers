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
		if (type.equals("Iterable")) {
			return "git_t";
		}
		if (type.equals("git_t")) {
			return type;
		}
		if (type.length()<2) {
			return "General_t";
		}
		else
			return type + "_t";
	}

	public String declarationInStruct(){
		// TODO: IS THIS RIGHT?!??!?! (original funtion commented out -
		// what should this output when type.equals("Iterable")?
		return toC();
//		if(type == null){
//			return "git_t";
//		}
//		if(type.equals("void*")){
//			return type;
//		}
//		if (type.equals("String"))
//			return "git_t";
//		else
//			return type + "_t";
	}
}
