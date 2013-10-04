package typeChecker;

import java.util.HashMap;
import java.util.Map;

public class FunctionContext {
	private Map<String, TypeScheme> nameToTypeSchemeMap;
	
	public FunctionContext(){
		nameToTypeSchemeMap = new HashMap<String, TypeScheme>();
	}
	
	public void put(String functionName, TypeScheme typeScheme){
		nameToTypeSchemeMap.put(functionName, typeScheme);
	}
	
	public TypeScheme get(String functionName){
		return nameToTypeSchemeMap.get(functionName);
	}
	
	public void remove(String functionName){
		nameToTypeSchemeMap.remove(functionName);		
	}
}
