package typeChecker;

import java.util.HashMap;
import java.util.Map;

import parsingTokens.context.CubexTypeScheme;

public class FunctionContext {
	public Map<String, CubexTypeScheme> nameToTypeSchemeMap;
	
	public FunctionContext(){
		nameToTypeSchemeMap = new HashMap<String, CubexTypeScheme>();
	}
	
	public void merge(FunctionContext funcContext){
		for (Map.Entry<String, CubexTypeScheme> entry : funcContext.iterable()){
			nameToTypeSchemeMap.put(entry.getKey(), entry.getValue());
		}
	}
	
	public void put(String functionName, CubexTypeScheme typeScheme){
		nameToTypeSchemeMap.put(functionName, typeScheme);
	}
	
	public boolean containsKey(String functionName){
		return nameToTypeSchemeMap.containsKey(functionName);
	}
	
	public CubexTypeScheme get(String functionName){
		return nameToTypeSchemeMap.get(functionName);
	}
	
	public void remove(String functionName){
		nameToTypeSchemeMap.remove(functionName);		
	}
	
	public Iterable<Map.Entry<String, CubexTypeScheme>> iterable(){
		return nameToTypeSchemeMap.entrySet();
	}
	
	public FunctionContext clone(){
		FunctionContext output = new FunctionContext();
		output.merge(this);
		return output;
	}
}
