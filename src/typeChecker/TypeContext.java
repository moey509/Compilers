package typeChecker;

import java.util.HashMap;
import java.util.Map;

public class TypeContext {
	private Map<String, Type> contextMap;
	
	public TypeContext(){
		contextMap = new HashMap<String, Type>();
				
	}
	
	public void put(String variableName, Type type){
		contextMap.put(variableName, type);
	}
	
	public void merge(TypeContext typeContext){
		for (Map.Entry<String, Type> entry : typeContext.iterable()){
			contextMap.put(entry.getKey(), entry.getValue());
		}
	}
	
	public void remove(String variableName){
		contextMap.remove(variableName);
	}
	
	public Type get(String variableName){
		return contextMap.get(variableName);
	}
	
	public Iterable<Map.Entry<String, Type>> iterable(){
		return contextMap.entrySet();
	}
}
