package parsingTokens.statements;

import Exception.SemanticException;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;

public class CubexIf extends CubexStatement {
	private CubexStatement s1;	//{	s1 }
	private CubexStatement s2;	// else {s2}

	// if there is no else statement, let s2 be null
	public CubexIf(CubexExpression e, CubexStatement s1, CubexStatement s2) {
		super();
		this.e = e;
		this.s1 = new CubexListStatement(s1.flatten());
		if(s2 != null){
			this.s2 = new CubexListStatement(s2.flatten());
		}
		else{
			this.s2 = s2;
		}
	}

	public String toString() {
		String temp;
		if (s2 != null) {
			temp = s2.toString();
		}
		else{
			temp = "{ }";
		}
		String newString = "if ( " + e.toString() + " ) " + s1.toString() + " else " + temp;
		return newString;
	}
	
	public TypeContext typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexCompleteContext copy0 = c.clone();
		copy0.typeContext.noConflictMerge(copy0.mutableTypeContext);
		CubexTypeGrammar etype = e.typeCheck(copy0);
		if (!etype.getName().equals("Boolean")) throw new SemanticException("CubexIf: e is not a boolean");
		TypeContext t1 = s1.typeCheck(c);
		TypeContext t2 = s2.typeCheck(c);
		return t1.intersection(c, t2);
		
	}
	
	public TypeContextReturn typeCheckReturn(CubexCompleteContext c) throws SemanticException {
		CubexCompleteContext copy0 = c.clone();
		copy0.typeContext.noConflictMerge(copy0.mutableTypeContext);
		CubexTypeGrammar etype = e.typeCheck(copy0);
		if (!etype.getName().equals("Boolean")) throw new SemanticException("CubexIf: e is not a boolean");
		TypeContextReturn t1 = s1.typeCheckReturn(c);
		TypeContextReturn t2 = s2.typeCheckReturn(c);
		TypeContext t = t1.typeContext.intersection(c, t2.typeContext);
		boolean g = t1.guaranteedToReturn && t2.guaranteedToReturn;
		return new TypeContextReturn(t, g, t1.retType.join(c, t2.retType));
	}
}
