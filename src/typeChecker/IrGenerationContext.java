package typeChecker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IrGenerationContext {
	private String currentClass;
	private Set<String> globalFunctions;
	private Map<String, String> typeToSuperTypeMap;
	private Map<String, Set<String>> objectToFunctionMap;

	public IrGenerationContext() {
		globalFunctions = new HashSet<String>();
		typeToSuperTypeMap = new HashMap<String, String>();
		objectToFunctionMap = new HashMap<String, Set<String>>();
	}
	
	public void setCurrentClass(String currentClass){
		this.currentClass = currentClass;
	}
	
	public String getCurrentClass(){
		return currentClass;
	}

	public void addGlobalFunction(String function){
		globalFunctions.add(function);
	}
	
	public boolean containsGlobalFunction(String function){
		return globalFunctions.contains(function);
	}
	
	public String getSuperType(String type){
		return typeToSuperTypeMap.get(type);
	}
	
	public void setSuperType(String type, String superType){
		typeToSuperTypeMap.put(type, superType);
	}
	
	public boolean objectContainsFunction(String object, String function){
		return objectToFunctionMap.get(object).contains(function);
	}
	
	public void objectAddFunction(String object, String function){
		if (!objectToFunctionMap.containsKey(object)){
			objectToFunctionMap.put(object, new HashSet<String>());
		}
		objectToFunctionMap.get(object).add(function);
	}
	
}
