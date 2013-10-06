package parsingTokens.expressions;

import parsingTokens.statements.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public class CubexExpression {
	String name;
	public CubexExpression(){}
	public CubexExpression(String vp){
		name = vp;
	}
	public String toString(){
		return name;
	}
	//Check if the expression is of some type
	public boolean typeCheck(CubexCompleteContext c, CubexTypeGrammar t){
		return false;
	}
	public boolean typeCheck(CubexCompleteContext c, CubexTypeClass t){
		return false;
	}
	//Check if the expression is of some list of types
	public boolean typeCheck(CubexCompleteContext c, CubexList<CubexTypeGrammar> t){
		return false;
	}
}