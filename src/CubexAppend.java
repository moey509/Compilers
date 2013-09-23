public class CubexAppend extends CubexExpression{
	CubexExpression e1, e2;
	public CubexAppend(CubexExpression expr1, CubexExpression expr2){
		e1 = expr1;
		e2 = expr2;
	}
	
	public String toString(){
		return e1.toString() + " ++ " + e2.toString();
	}
}
