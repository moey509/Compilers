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
		if (!(e1Type.getName().equals("Iterable") && e2Type.getName().equals("Iterable"))){
			throw new SemanticException("Must append arguments of type Iterable");
		}
		CubexList<CubexTypeGrammar> list = e1Type.getTypeList();
		CubexList<CubexTypeGrammar> list2 = e2Type.getTypeList();
		
		CubexList<CubexTypeGrammar> output = new CubexList<CubexTypeGrammar>();
		output.add(list.get(0).join(c, list2.get(0)));
		return new CubexTypeClass("Iterable", output);
	}
}
