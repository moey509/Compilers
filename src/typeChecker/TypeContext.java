package typeChecker;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.context.CubexTypeTuple;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public class TypeContext {
	private HashMap<String, CubexTypeGrammar> contextMap;
	
	public TypeContext(){
		contextMap = new HashMap<String, CubexTypeGrammar>();			
	}
	
	public TypeContext(CubexList<CubexTypeTuple> lst){
		contextMap = new HashMap<String, CubexTypeGrammar>();
		for (CubexTypeTuple tup : lst.iterable()){
			contextMap.put(tup.getName(), tup.getTypeGrammar());
		}
	}
	
	// If the context needs to be modified, remove the mapping and add a new one back in
	public TypeContext clone() {
		TypeContext tc = new TypeContext();
		tc.contextMap = new HashMap<String, CubexTypeGrammar>( this.contextMap);
		return tc;
	}
	
	public void put(String variableName, CubexTypeGrammar type){
		contextMap.put(variableName, type);
	}
	
	public void merge(TypeContext typeContext){
		for (Map.Entry<String, CubexTypeGrammar> entry : typeContext.iterable()){
			contextMap.put(entry.getKey(), entry.getValue());
		}
	}
	
	public void noConflictMerge(TypeContext typeContext) throws SemanticException {
		for (Map.Entry<String, CubexTypeGrammar> entry : typeContext.iterable()){
			if (contextMap.containsKey(entry.getKey())) throw new SemanticException("Conflict upon TypeContext noConflictMerge");
			contextMap.put(entry.getKey(), entry.getValue());
		}
	}
	
	public TypeContext intersection(CubexCompleteContext c, TypeContext t2) throws SemanticException {
		TypeContext t = new TypeContext();
		for (String name : contextMap.keySet()) {
			if (t2.containsKey(name)) {
				CubexTypeGrammar type1 = get(name);
				CubexTypeGrammar type2 = t2.get(name);
				t.put(name, type1.join(c, type2));
			}
		}
		return t;
	}
	
	// returns whether this TypeContext contains all of t's entries with their values or a subtype of their values
	// each of t's entries must be in this, and each of t's entry's values must be a supertype of that in this
	public boolean containsAll(CubexCompleteContext c, TypeContext t) throws SemanticException {
		for (String name: t.contextMap.keySet()) {
			if (!contextMap.containsKey(name)) return false;
			if (!t.get(name).subtype(c, get(name))) return false;
		}
		return true;
	}
	
	public void remove(String variableName){
		contextMap.remove(variableName);
	}
	
	public boolean containsKey(String variableName){
		return contextMap.containsKey(variableName);
	}
	
	public CubexTypeGrammar get(String variableName){
		return contextMap.get(variableName);
	}
	
	public Iterable<Map.Entry<String, CubexTypeGrammar>> iterable(){
		return contextMap.entrySet();
	}
	
	public Set<Map.Entry<String, CubexTypeGrammar>> entrySet() {
		return contextMap.entrySet();
	}
}
