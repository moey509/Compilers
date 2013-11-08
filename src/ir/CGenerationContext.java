package ir;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CGenerationContext {
	public Map<String, CGenerationType> cVariableToTypeMap;
	public HashSet<String> variablesDeclaredInScope;
	public HashSet<String> variablesInitializedInScope;
	//map of variable name to variable type that needs to be declared at the top of the main function
	public Map<String, String> mainVarDecl = new HashMap<String, String>();
	//map of variable name to variable type that needs to be declared at the top of each funciton
	public Map<String, String> fcnVarDecl = new HashMap<String, String>();
	
	// final constants:
	public final String iterator = "_it";
	public final String iterable = "_iter";
	
	int count = 0;
	// counters to maintain references
	int cur_iterator;		// the appropriate form of an iterator will be = "_it" + cur_iterator
	int cur_iterable;		// the appropriate form of an iterable will be = "_iter" + cur_iterable
	
	public int nextCount(){
		return count++;
	}
	
	public CGenerationContext(){
		cVariableToTypeMap = new HashMap<String, CGenerationType>();
		variablesDeclaredInScope = new HashSet<String>();
		variablesInitializedInScope = new HashSet<String>();
		cur_iterator = 1; 
	}
	
	public int getCurIterator() {
		return this.cur_iterator;
	}
	
	public void incrementCurIterator() {
		this.cur_iterator += 1;
	}
	
	public int getCurIterable() {
		return this.cur_iterable;	
	}
	
	public void incrementCurIterable() {
		this.cur_iterable +=1 ;
	}
}
