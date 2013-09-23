public class CubexIterable extends CubexExpression{
	CubexList<CubexExpression> list;
	public CubexIterable(CubexList<CubexExpression> listIn) { list = listIn; }
	
	public String toString(){
		String rightSpace = list.size() == 0 ? "" : " ";
		return "[ " + list.toString(",") + rightSpace + "]";
	}
}
