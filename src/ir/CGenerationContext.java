package ir;

import java.util.HashMap;
import java.util.Map;

public class CGenerationContext {
	public Map<String, String> cVariableToTypeMap;
	public Map<String, Integer> referenceCount;
	
	public CGenerationContext(){
		cVariableToTypeMap = new HashMap<String, String>();
		referenceCount = new HashMap<String, Integer>();
	}
	
}
