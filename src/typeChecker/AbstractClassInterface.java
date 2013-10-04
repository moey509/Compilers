package typeChecker;

import java.util.Map;

public abstract class AbstractClassInterface {
	String name;
	KindContext kindContext;
	Type extension;
	
	Map<String,Function> nameToFunctionMap;
	
}
