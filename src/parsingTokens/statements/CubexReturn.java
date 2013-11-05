package parsingTokens.statements;

import ir.statements.IrReturn;
import Exception.SemanticException;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;

public final class CubexReturn extends CubexStatement {
	TypeContext freeContext;

	public CubexReturn(CubexExpression e) {
		this.e = e;
	}
	
	public IrReturn toIr(IrGenerationContext context) {
		return new IrReturn(e.toIr(context), freeContext);
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
		freeContext = c.mutableTypeContext;
		CubexCompleteContext copy0 = c.clone();
		copy0.typeContext.noConflictMerge(copy0.mutableTypeContext);
		CubexTypeGrammar etype = e.typeCheck(copy0);
		return new TypeContextReturn(c.mutableTypeContext.clone(), true, etype);
	}
}

