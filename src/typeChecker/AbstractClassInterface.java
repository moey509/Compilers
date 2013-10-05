package typeChecker;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractClassInterface {
	String name;
	KindContext kindContext;
	List<Type> extendedTypes;
	
	public AbstractClassInterface(String name, KindContext kindContext) {
		this.name = name;
		this.kindContext = kindContext;
		this.extendedTypes = new LinkedList<Type>();
		extendedTypes.add(new Type("Thing"));
	}
	
}
