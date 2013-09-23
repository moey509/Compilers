import java.util.ArrayList;
import java.util.List;


public class CubexList<T> implements CubexStatement {
	private List<T> contextCollection = new ArrayList<T>();
	
	public void add(T object) {
		contextCollection.add(object);
	}
	
	public void remove(T object) {
		contextCollection.remove(object);
	}
	
	public String toString(String separator) {
		StringBuilder sb = new StringBuilder();
		boolean firstTime = true;

		for (T s : contextCollection){
			sb.append(s.toString());

			if(firstTime){
				firstTime = false;
			}
			else{
				if (separator.equals(" ")) {
					sb.append(separator);
				}
				else {
					sb.append(" " + separator + " ");
				}					
			}
		}
		
		return sb.toString();
	}
}
