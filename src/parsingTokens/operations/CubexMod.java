package parsingTokens.operations;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexBinaryExpression;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public class CubexMod extends CubexBinaryExpression {
	public CubexMod(CubexExpression left, CubexExpression right) {
		super(left, right);
	}
	public String toString(){
		return getmLeft().toString() + " . modulo < > ( " + getmRight().toString() + " )";
	}
	
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexList<CubexTypeGrammar> l = new CubexList<CubexTypeGrammar>();
		l.add(new CubexTypeClass("Integer", new CubexList<CubexTypeGrammar>()));
		return new CubexTypeClass("Iterable", l);
	}
}