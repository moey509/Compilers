package typeChecker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import parsingTokens.CubexFunctionDef;

public class IrGenerationContext {
	private String currentClassDeclaration;
	private Set<String> globalVariables;
	private Set<String> globalFunctions;
	private Map<String, String> typeToSuperTypeMap;
	private Map<String, Set<CubexFunctionDef>> objectToFunctionMap;

	public IrGenerationContext() {
		globalVariables = new HashSet<String>();
		globalFunctions = new HashSet<String>();
		typeToSuperTypeMap = new HashMap<String, String>();
		objectToFunctionMap = new HashMap<String, Set<CubexFunctionDef>>();
	}
	
	public void setCurrentClassDeclaration(String currentClassDeclaration){
		this.currentClassDeclaration = currentClassDeclaration;
	}
	
	public String getCurrentClassDeclaration(){
		return currentClassDeclaration;
	}

	public void addGlobalVariable(String variable){
		globalFunctions.add(variable);
	}
	
	public boolean containsGlobalVariable(String variable){
		return globalFunctions.contains(variable);
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
	
	
	public Set<CubexFunctionDef> functionSet(String object){
		return objectToFunctionMap.get(object);
	}
	
	public void objectAddFunction(String object, CubexFunctionDef function){
		if (!objectToFunctionMap.containsKey(object)){
			objectToFunctionMap.put(object, new HashSet<CubexFunctionDef>());
		}
		objectToFunctionMap.get(object).add(function);
	}
	
}
