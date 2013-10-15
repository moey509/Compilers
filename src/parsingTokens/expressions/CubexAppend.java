package parsingTokens.expressions;

import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import Exception.SemanticException;

public class CubexAppend extends CubexExpression {
	CubexExpression e1, e2;

	public CubexAppend(CubexExpression expr1, CubexExpression expr2) {
		e1 = expr1;
		e2 = expr2;
	}

	public String toString() {
		return e1.toString() + " ++ " + e2.toString();
	}
	
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException{
		CubexTypeGrammar e1Type = e1.typeCheck(c);
		CubexTypeGrammar e2Type = e2.typeCheck(c);
		CubexTypeGrammar join = e1Type.join(c, e2Type);
		
		CubexList<CubexTypeGrammar> nothingList = new CubexList<CubexTypeGrammar>();
		nothingList.add(new CubexTypeClass("Nothing", new CubexList<CubexTypeGrammar>()));
		CubexTypeClass nothing = new CubexTypeClass("Iterable", nothingList);
		
		//To get an iterable of something or if thats not possible, Thing which does not type check
		join = join.join(c, nothing);
		
		//Join must have type iterable
		if (!(join.getName().equals("Iterable"))){
			throw new SemanticException("Must append arguments of type Iterable");
		}
		return e1Type.join(c,e2Type);
	}
}
