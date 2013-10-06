package parsingTokens;
import java.util.ArrayList;
import java.util.List;

/*
 * List with no spaces
 */
<<<<<<< HEAD:src/parsingTokens/CubexList.java
<<<<<<< HEAD:src/parsingTokens/CubexList.java
public class CubexList<T>{
=======
public class CubexList<T> {
>>>>>>> 5832f6138642e0af48d3b41f9a0774ef5499e82f:src/parsingTokens/statements/CubexList.java
=======
public class CubexList<T> {
>>>>>>> 5832f6138642e0af48d3b41f9a0774ef5499e82f:src/parsingTokens/statements/CubexList.java
	public List<T> contextCollection = new ArrayList<T>();
	
	public void add(T object) {
		contextCollection.add(object);
	}
	
	public T get(int i){
		return contextCollection.get(i);
	}
	
	public void remove(T object) {
		contextCollection.remove(object);
	}
	
	public int size(){
		return contextCollection.size();
	}
	
	public boolean isEmpty() {
		return contextCollection.isEmpty();
	}
	
	public String toString(){
		return this.toString(" ");
	}
	
	public String toString(String separator) {
		StringBuilder sb = new StringBuilder();
		boolean firstTime = true;

		for (T s : contextCollection){
			if(firstTime){
				firstTime = false;
			}
			else{
				if (separator.equals(" ") || separator.equals("")) {
					sb.append(separator);
				}
				else {
					sb.append(" " + separator + " ");
				}					
			}
			sb.append(s.toString());
		}
		
		return sb.toString();
	}
}
