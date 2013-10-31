package context;

import java.util.HashSet;

public class IrContext {
	private String superClass;
	private HashSet<String> definedFunctions;
	
	public IrContext(){
		definedFunctions = new HashSet<String>();
	}

	public String getSuperClass() {
		return superClass;
	}

	public void setSuperClass(String superClass) {
		this.superClass = superClass;
	}
	
	public void addFunction(String function){
		definedFunctions.add(function);
	}
	
	public void resetFunctions(){
		definedFunctions.clear();
	}
	
	public boolean containsFunction(String function){
		return definedFunctions.contains(function);
	}
	
}
