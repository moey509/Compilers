package parsingTokens.expressions;


import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;


public class CubexIterable extends CubexExpression{
	CubexList<CubexExpression> list;
	public CubexIterable(CubexList<CubexExpression> listIn) { list = listIn; }
	
	public String toString(){
		String rightSpace = list.size() == 0 ? "" : " ";
		return "[ " + list.toString(",") + rightSpace + "]";
	}
	
	//Must check that all expressions are of type t: vc<t>
	//Rule 5.5
	public CubexCompleteContext typeCheck(CubexCompleteContext c, CubexTypeClass t) throws SemanticException{
		for(int i = 0; i < list.size(); i++){
			//TODO: change to returning something false
//			if(!list.get(i).typeCheck(c, t.typeList.get(0))){
//				return null;
//			}
		}
		return c;
	}
	//Check if the expression is of some list of types
	public CubexCompleteContext typeCheck(CubexCompleteContext c, CubexList<CubexTypeGrammar> t) throws SemanticException{
		throw new SemanticException("");
	}
}
