package typeChecker;

import java.util.HashMap;
import java.util.Map;

import Exception.SemanticException;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public class TypeContext {
	private HashMap<String, CubexTypeGrammar> contextMap;
	
	public TypeContext(){
		contextMap = new HashMap<String, CubexTypeGrammar>();			
	}
	
	// If the context needs to be modified, remove the mapping and add a new one back in
	public TypeContext clone() {
		TypeContext tc = new TypeContext();
		tc.contextMap = (HashMap<String, CubexTypeGrammar>) this.contextMap.clone();
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
}
