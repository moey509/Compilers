package typeChecker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import parsingTokens.CubexFunctionDef;

public class IrGenerationContext {
	private String currentClassDeclaration;
	private Set<String> globalVariables;
	private Set<String> globalFunctions;
	private Map<String, String> typeToSuperTypeMap;
	private Map<String, Set<CubexFunctionDef>> objectToFunctionMap;
	private Map<String, CubexFunctionDef> objectToConstructorMap;
	int count = 0;
	
	public int nextCount(){
		return count++;
	}
	
	public String nextTemp(){
		return "__temp" + nextCount();
	}
	
	public IrGenerationContext() {
		globalVariables = new HashSet<String>();
		globalFunctions = new HashSet<String>();
		typeToSuperTypeMap = new HashMap<String, String>();
		objectToFunctionMap = new HashMap<String, Set<CubexFunctionDef>>();
		objectToConstructorMap = new HashMap<String, CubexFunctionDef>();
	}
	
	public void setCurrentClassDeclaration(String currentClassDeclaration){
		this.currentClassDeclaration = currentClassDeclaration;
	}
	
	public String getCurrentClassDeclaration(){
		return currentClassDeclaration;
	}

	public void addGlobalVariable(String variable){
		globalVariables.add(variable);
	}
	
	public boolean containsGlobalVariable(String variable){
		return false;
		//return globalVariables.contains(variable);
	}
	
	public void printGlobalVariables(){
		System.out.println("Global Variables: " + globalVariables.toString());
	}
	
	public void addGlobalFunction(String function){
		globalFunctions.add(function);
	}
	
	public boolean containsGlobalFunction(String function){
		return globalFunctions.contains(function);
	}
	
	public void printGlobalFunctions(){
		System.out.println("Global Functions: " + globalFunctions.toString());
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
	
	public void addConstructor(String object, CubexFunctionDef constructor){
		objectToConstructorMap.put(object, constructor);
	}
	
	public CubexFunctionDef getConstructor(String object){
		return objectToConstructorMap.get(object);
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Current Class Declaration: " + currentClassDeclaration + "\n");
		
		sb.append("Global Variables: ");
		for (String s : globalVariables){
			sb.append(s + ", ");
		}
		if (!globalVariables.isEmpty()){
			sb.delete(sb.length()-2, sb.length());
		}
		sb.append("\n");
		
		sb.append("Global Functions: ");
		for (String s : globalFunctions){
			sb.append(s+ ", ");
		}
		if (!globalFunctions.isEmpty()){
			sb.delete(sb.length()-2, sb.length());
		}
		sb.append("\n");
		
		sb.append("Type to Super: ");
		for (Map.Entry<String, String> entry : typeToSuperTypeMap.entrySet()){
			sb.append(entry.getKey() + ":" + entry.getValue()+ ", ");
		}
		if (!typeToSuperTypeMap.isEmpty()){
			sb.delete(sb.length()-2, sb.length());
		}
		sb.append("\n");
		
		sb.append("Object to Functions: ");
		for (Entry<String, Set<CubexFunctionDef>> entry : objectToFunctionMap.entrySet()){
			sb.append(entry.getKey() + ": [");
			
			for (CubexFunctionDef funDef : entry.getValue()){
				sb.append(funDef.name + ", ");
			}
			if (!entry.getValue().isEmpty()){
				sb.delete(sb.length()-2, sb.length());
			}
			sb.append("], ");
		}
		if (!objectToFunctionMap.isEmpty()){
			sb.delete(sb.length()-2, sb.length());
		}
		sb.append("\n");
		
		
		return sb.toString();
	}
	
}
