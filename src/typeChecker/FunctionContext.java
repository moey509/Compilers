package typeChecker;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.context.CubexTypeScheme;
import parsingTokens.context.CubexTypeTuple;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public class FunctionContext {
	public Map<String, CubexTypeScheme> nameToTypeSchemeMap;
	
	public FunctionContext(){
		nameToTypeSchemeMap = new HashMap<String, CubexTypeScheme>();
	}
	
	public FunctionContext clone(){
		FunctionContext fc = new FunctionContext();
		fc.nameToTypeSchemeMap = new HashMap<String, CubexTypeScheme>( this.nameToTypeSchemeMap);
		return fc;
	}
	
	public void merge(FunctionContext funcContext){
		for (Map.Entry<String, CubexTypeScheme> entry : funcContext.iterable()){
			if(nameToTypeSchemeMap.containsKey(entry.getKey())){
				//TODO: Check to see if the type scheme and type context are congruent
			}
			nameToTypeSchemeMap.put(entry.getKey(), entry.getValue());
		}
	}
	
	public void put(String functionName, CubexTypeScheme typeScheme){
		nameToTypeSchemeMap.put(functionName, typeScheme);
	}
	
	public boolean containsKey(String functionName){
		return nameToTypeSchemeMap.containsKey(functionName);
	}
	
	public CubexTypeScheme get(String functionName){
		return nameToTypeSchemeMap.get(functionName);
	}
	
	public void remove(String functionName){
		nameToTypeSchemeMap.remove(functionName);		
	}
	
	public Iterable<Map.Entry<String, CubexTypeScheme>> iterable(){
		return nameToTypeSchemeMap.entrySet();
	}
	
	public FunctionContext replace(Map<String, CubexTypeGrammar> map) throws SemanticException{
		FunctionContext output = new FunctionContext();
		for (Entry<String, CubexTypeScheme> entry : nameToTypeSchemeMap.entrySet()){
			String str = entry.getKey();
			CubexTypeScheme oldScheme = entry.getValue();
			CubexList<String> k = oldScheme.getKindContext();
			CubexTypeGrammar returnType;
			if (map.containsKey(oldScheme.getTypeGrammar().getName())){
				returnType = map.get(oldScheme.getTypeGrammar().getName());
			}
			else{
				returnType = oldScheme.getTypeGrammar();
			}
			
			CubexList<CubexTypeTuple> outputTuples = new CubexList<CubexTypeTuple>();
			for (CubexTypeTuple blah : oldScheme.getTypeContext().iterable()){
				if (map.containsKey(blah.getTypeGrammar().getName())){
					outputTuples.add(new CubexTypeTuple(blah.getName(), map.get(blah.getTypeGrammar().getName())));
				}
				else {
					outputTuples.add(new CubexTypeTuple(blah.getName(), blah.getTypeGrammar()));
				}
			}
			
			output.put(str, new CubexTypeScheme(k, outputTuples, returnType));
		}
		return output;
	}
	
	public String toString() {
		return "Function Context: " + nameToTypeSchemeMap.toString();
	}
}
