package typeChecker;

import java.util.HashMap;
import java.util.Map;

import parsingTokens.context.CubexTypeScheme;

public class FunctionContext {
	public Map<String, CubexTypeScheme> nameToTypeSchemeMap;
	
	public FunctionContext(){
		nameToTypeSchemeMap = new HashMap<String, CubexTypeScheme>();
	}
	
	public void put(String functionName, CubexTypeScheme typeScheme){
		nameToTypeSchemeMap.put(functionName, typeScheme);
	}
	
	public CubexTypeScheme get(String functionName){
		return nameToTypeSchemeMap.get(functionName);
	}
	
	public void remove(String functionName){
		nameToTypeSchemeMap.remove(functionName);		
	}
}
