package ir;

import java.util.HashMap;
import java.util.Map;

public class CGenerationContext {
	public Map<String, CGenerationType> cVariableToTypeMap;
	
	// counters to maintain references
	int cur_iterator;		// the appropriate form of an iterator will be = "_it" + cur_iterator
	
	public CGenerationContext(){
		cVariableToTypeMap = new HashMap<String, CGenerationType>();
		cur_iterator = 1; 
	}
	
	public int getCurIterator() {
		return this.cur_iterator;
	}
	
	public void incrementCurIterator() {
		this.cur_iterator += 1;
	}
}
