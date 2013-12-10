package ir;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CGenerationContext {
	public Map<String, CGenerationType> cVariableToTypeMap;
	public HashSet<String> variablesDeclaredInScope;
	public HashSet<String> variablesInitializedInScope;
	public ArrayList<String> comprehensionFunctions = new ArrayList<String>();
	
	// set that contains all variables that need to be freed from control flow types.
	// ie. in the case for (v in e) {}, 'e' will get placed into this set
	public HashSet<String> controlFlowVariables = new HashSet<String>();
	
	//map of variable name to variable type that needs to be declared at the top of scope
	// declare new map whenever we enter a new scope (i.e. function implementation or main function
	public Map<String, String> varDecl = new HashMap<String, String>();
	public Map<String, String> varInit = new HashMap<String, String>();
	
	public Map<String, Set<String>> objectToDataMap;
	public String currentObject;
	
	public boolean lva = false;
	
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
		objectToDataMap = new HashMap<String, Set<String>>();
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
	
	public String getComprehensionStruct(){
		return "__compStruct" + getComprehensionCount();
	}
	int comprehensionCount = 0;
	private int getComprehensionCount() {
		// TODO Auto-generated method stub
		
		return comprehensionCount++;
	}
	
}
