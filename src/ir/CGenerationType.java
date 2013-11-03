package ir;

import java.util.ArrayList;

/*
 * A class that represents the "type" that is stored in the hashmap in 
 * CGenerationContext. This type stores whether this type is an iterable or 
 * not, and the appropriate types
 */
public class CGenerationType {
	private boolean isIterable;
	private ArrayList<String> types;
	
	public CGenerationType (boolean isIterable, ArrayList<String> types) {
		this.isIterable = isIterable;
		this.types = types;
	}
	
	public boolean getIsIterable() {
		return isIterable;
	}
	
	public void setIsIterable(boolean isIterable) {
		this.isIterable = isIterable;
	}
	
	public ArrayList<String> getTypes(){
		return this.types;
	}
	
	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}
}
