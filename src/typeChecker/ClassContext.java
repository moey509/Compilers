package typeChecker;

import java.util.HashMap;
import java.util.Map;

import parsingTokens.typeGrammar.CubexTypeGrammar;

public class ClassContext {
	Map<String,ClassContextElement> contextMap;
	
	public ClassContext(){
		contextMap = new HashMap<String, ClassContextElement>();
	}
	
	public void merge(ClassContext typeContext){
		for (Map.Entry<String, ClassContextElement> entry : typeContext.iterable()){
			contextMap.put(entry.getKey(), entry.getValue());
		}
	}
	
	public void put(String name, ClassContextElement value){
		contextMap.put(name, value);
	}
	
	public boolean containsKey(String name){
		return contextMap.containsKey(name);
	}
	
	public ClassContextElement get(String name){
		return contextMap.get(name);
	}
	
	public Iterable<Map.Entry<String, ClassContextElement>> iterable(){
		return contextMap.entrySet();
	}
}
