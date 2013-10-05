package typeChecker;

import java.util.LinkedList;
import java.util.List;

public class Type {
	String name;
	
	List<Type> superTypes;
	
	public Type(String name){
		this.name = name;
		superTypes = new LinkedList<Type>();
		
	}

}
