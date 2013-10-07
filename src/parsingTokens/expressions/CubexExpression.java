package parsingTokens.expressions;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public class CubexExpression {
	String name;

	public CubexExpression() {
	}

	public CubexExpression(String vp) {
		name = vp;
	}

	public String toString() {
		return name;
	}

//	// Check if the expression is of some type
//	public CubexTypeGrammar typeCheck(CubexCompleteContext c,
//			CubexTypeGrammar t) throws SemanticException {
//		throw new SemanticException("");
//	}
//
//	public CubexTypeGrammar typeCheck(CubexCompleteContext c,
//			CubexTypeClass t) throws SemanticException {
//		throw new SemanticException("");
//	}
//
//	// Check if the expression is of some list of types
//	public CubexTypeGrammar typeCheck(CubexCompleteContext c,
//			CubexList<CubexTypeGrammar> t) throws SemanticException {
//		throw new SemanticException("");
//	}
	
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException{
		throw new SemanticException("");
	}
}