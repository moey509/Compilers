package typeChecker;

import java.util.HashMap;
import java.util.Map;

public class ClassContext {
	Map<String,ClassContextElement> contextMap;
	
	public ClassContext(){
		contextMap = new HashMap<String, ClassContextElement>();
	}
	
	public void put(String name, ClassContextElement value){
		contextMap.put(name, value);
	}
	
	public ClassContextElement get(String name){
		return contextMap.get(name);
	}
}
