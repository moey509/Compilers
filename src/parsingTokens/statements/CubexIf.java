package parsingTokens.statements;

import Exception.SemanticException;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;

public final class CubexIf extends CubexStatement {
//	private CubexExpression e;  // if e:
	private CubexStatement s1;	//{	s1 }
	private CubexStatement s2;	// else {s2}

	// if there is no else statement, let s2 be null
	public CubexIf(CubexExpression e, CubexStatement s1, CubexStatement s2) {
		this.e = e;
		this.s1 = s1;
		this.s2 = s2;
	}

	public String toString() {
		String temp;
		if (s2 != null) {
			temp = s2.toString();
		}
		else{
			temp = "{ }";
		}
		boolean prev = CubexListStatement.flatten;
		CubexListStatement.flatten = false;
		String newString = "if ( " + e.toString() + " ) " + s1.toString() + " else " + temp;
		CubexListStatement.flatten = prev;
		return newString;
	}
	
	public TypeContext typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexCompleteContext copy0 = c.clone();
		copy0.typeContext.noConflictMerge(copy0.mutableTypeContext);
		CubexTypeGrammar etype = e.typeCheck(copy0);
		if (!etype.name.equals("Boolean")) throw new SemanticException("CubexIf: e is not a boolean");
		TypeContext t1 = s1.typeCheck(c);
		TypeContext t2 = s2.typeCheck(c);
		return t1.intersection(t2);
		
	}
	
	public TypeContextReturn typeCheckReturn(CubexCompleteContext c) throws SemanticException {
		CubexCompleteContext copy0 = c.clone();
		copy0.typeContext.noConflictMerge(copy0.mutableTypeContext);
		CubexTypeGrammar etype = e.typeCheck(copy0);
		if (!etype.name.equals("Boolean")) throw new SemanticException("CubexIf: e is not a boolean");
		TypeContextReturn t1 = s1.typeCheckReturn(c);
		TypeContextReturn t2 = s2.typeCheckReturn(c);
		TypeContext t = t1.typeContext.intersection(t2.typeContext);
		boolean g = t1.guaranteedToReturn && t2.guaranteedToReturn;
		return new TypeContextReturn(t, g, t1.retType.join(t2.retType));
	}
}
