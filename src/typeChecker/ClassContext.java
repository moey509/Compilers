package typeChecker;

import java.util.HashMap;
import java.util.Map;

public class ClassContext {
	Map<String,AbstractClassInterface> contextMap;
	
	public ClassContext(){
		contextMap = new HashMap<String, AbstractClassInterface>();
	}
	
	public void put(String name, AbstractClassInterface value){
		contextMap.put(name, value);
	}
	
	public AbstractClassInterface get(String name){
		return contextMap.get(name);
	}
}
