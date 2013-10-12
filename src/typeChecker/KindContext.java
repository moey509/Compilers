package typeChecker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import parsingTokens.CubexList;

// represents a list of the type-parameter names. Stuff in 'name'< > 
public class KindContext {
	public ArrayList<String> contextSet;
	
	public KindContext(){
		contextSet = new ArrayList<String>();
	}
	
	public KindContext(CubexList<String> stringList){
		contextSet = new ArrayList<String>(stringList.contextCollection);
	}
	
	public int size() {
		return contextSet.size();
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
	
	public String toString() {
		return "Kind Context: " + contextSet.toString();
	}

}
