package parsingTokens;
import java.util.ArrayList;
import java.util.List;


public class CubexList<T>{


	public List<T> contextCollection = new ArrayList<T>();
	
	public void add(T object) {
		contextCollection.add(object);
	}
	
	public void add(CubexList<T> tempList) {
		for(int i = 0; i < tempList.size(); i++){
			contextCollection.add(tempList.get(i));
		}
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
	
	public Iterable<T> iterable(){
		return contextCollection;
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
