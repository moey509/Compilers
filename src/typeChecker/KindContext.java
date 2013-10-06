package typeChecker;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class KindContext {
	private Set<String> contextSet;
	
	public KindContext(){
		contextSet = new HashSet<String>();
	}
	
	public void add(String typeParamNames){
		contextSet.add(typeParamNames);
	}
	
	public void addAll(Collection<String> nameCollection){
		contextSet.addAll(nameCollection);
	}
	
	public void addAll(KindContext cont){
		contextSet.addAll(cont.contextSet);
	}
	
	public void remove(String typeParamNames){
		contextSet.remove(typeParamNames);
	}
	
	public boolean contains(String typeParamNames){
		return contextSet.contains(typeParamNames);
	}
}
