package parsingTokens.statements;

import ir.statements.IrReturn;
import Exception.SemanticException;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;

public final class CubexReturn extends CubexStatement {

	public CubexReturn(CubexExpression e) {
		this.e = e;
	}
	
	public IrReturn toIr() {
		return new IrReturn(e.toIr());
	}

	public String toString() {
		return "return " + e.toString() + " ;";
	}
//	public CubexCompleteContext typeCheck(CubexCompleteContext c, boolean bool, CubexTypeClass t) throws SemanticException {
//		//7.9
//		if(bool){
//			return e.typeCheck(c, t);
//		}
//		return this.typeCheck(c, true, t); //Weakening
//	}
	
	public TypeContextReturn typeCheckReturn(CubexCompleteContext c) throws SemanticException {
		CubexCompleteContext copy0 = c.clone();
		copy0.typeContext.noConflictMerge(copy0.mutableTypeContext);
		System.out.println(copy0.toString());
		CubexTypeGrammar etype = e.typeCheck(copy0);
		return new TypeContextReturn(c.mutableTypeContext.clone(), true, etype);
	}
}

