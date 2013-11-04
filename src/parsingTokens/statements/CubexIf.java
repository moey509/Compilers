package parsingTokens.statements;

import ir.statements.IrIf;
import Exception.SemanticException;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;
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
	
	public IrIf toIr(IrGenerationContext context) {
		IrIf ir = new IrIf(e.toIr(context));
		ir.addStatement1(s1.toIr(context));
		if (s2 != null)
			ir.addStatement2(s2.toIr(context));
		return ir;
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
		if(s2 == null){
			return t1;
		}
		else{
			TypeContext t2 = s2.typeCheck(c);
			return t1.intersection(c, t2);
		}
		
	}
	
	public TypeContextReturn typeCheckReturn(CubexCompleteContext c) throws SemanticException {
		CubexCompleteContext copy0 = c.clone();
		copy0.typeContext.noConflictMerge(copy0.mutableTypeContext);
		CubexTypeGrammar etype = e.typeCheck(copy0);
		if (!etype.getName().equals("Boolean")) throw new SemanticException("CubexIf: e is not a boolean");
		TypeContextReturn t1 = s1.typeCheckReturn(c);
		if(s2 == null){
			TypeContext t = t1.typeContext;
			boolean g = false;
			return new TypeContextReturn(c.mutableTypeContext, g, t1.retType);
		}
		TypeContextReturn t2 = s2.typeCheckReturn(c);
		TypeContext t = t1.typeContext.intersection(c, t2.typeContext);
		boolean g = t1.guaranteedToReturn && t2.guaranteedToReturn;
		return new TypeContextReturn(t, g, t1.retType.join(c, t2.retType));
	}
}
