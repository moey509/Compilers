public class CubexIterable extends CubexExpression{
	CubexList<CubexExpression> list;
	public CubexIterable(CubexList<CubexExpression> listIn) { list = listIn; }
	
	public String toString(){
		return "[ " + list.toString(",") + " ]";
	}
}
