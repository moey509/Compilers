package parsingTokens.expressions;

<<<<<<< HEAD
import parsingTokens.CubexList;
=======
import parsingTokens.statements.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
<<<<<<< HEAD
>>>>>>> 5832f6138642e0af48d3b41f9a0774ef5499e82f
=======
>>>>>>> 5832f6138642e0af48d3b41f9a0774ef5499e82f

public class CubexIterable extends CubexExpression{
	CubexList<CubexExpression> list;
	public CubexIterable(CubexList<CubexExpression> listIn) { list = listIn; }
	
	public String toString(){
		String rightSpace = list.size() == 0 ? "" : " ";
		return "[ " + list.toString(",") + rightSpace + "]";
	}
	
	//Must check that all expressions are of type t: vc<t>
	//Rule 5.5
	public boolean typeCheck(CubexCompleteContext c, CubexTypeClass t){
		for(int i = 0; i < list.size(); i++){
			if(!list.get(i).typeCheck(c, t.typeList.get(0))){
				return false;
			}
		}
		return true;
	}
	//Check if the expression is of some list of types
	public boolean typeCheck(CubexCompleteContext c, CubexList<CubexTypeGrammar> t){
		return false;
	}
}
