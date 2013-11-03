package ir;

import java.util.HashMap;
import java.util.Map;

public class CGenerationContext {
	public Map<String, CGenerationType> cVariableToTypeMap;
	
	public CGenerationContext(){
		cVariableToTypeMap = new HashMap<String, CGenerationType>();
	}
	
}
