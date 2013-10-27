package parsingTokens.statements;

import ir.statements.IrBind;
import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;

public final class CubexBind extends CubexStatement {
	private String classid;
//	CubexExpression e;

	public CubexBind(String classid, CubexExpression e) {
		this.classid = classid;
		this.e = e;
	}
	
	public IrBind toIr() {
		return new IrBind(classid, e.toIr());
	}

	public String toString() {
		return classid + " := " + e.toString() + " ;";
	}
	
	public TypeContext typeCheck(CubexCompleteContext c) throws SemanticException {
		if (c.typeContext.containsKey(classid)) throw new SemanticException("Tried to bind immutable variable (CubexBind)");
		CubexCompleteContext copy = c.clone();
		copy.typeContext.noConflictMerge(copy.mutableTypeContext);
		CubexTypeGrammar t = e.typeCheck(copy);
		TypeContext typecontext = c.mutableTypeContext.clone();
		if (typecontext.containsKey(classid)) {
			typecontext.remove(classid);
		}
		typecontext.put(classid, t);
		return typecontext;
	}
	
	public TypeContextReturn typeCheckReturn(CubexCompleteContext c) throws SemanticException{
		TypeContext t = typeCheck(c);
		//TODO fix bug with returning null
	
		return new TypeContextReturn(t, false, new CubexTypeClass("Nothing", new CubexList<CubexTypeGrammar>()));
	}
	
}