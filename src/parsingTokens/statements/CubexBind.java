package parsingTokens.statements;

import java.util.ArrayList;
import java.util.HashMap;

import ir.IrType;
import ir.program.IrTypeTuple;
import ir.statements.IrBind;
import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;

public final class CubexBind extends CubexStatement {
	private String classid;
	private IrType type = null;
//	CubexExpression e;
	
	CubexCompleteContext cubexContext;

	public CubexBind(String classid, CubexExpression e) {
		this.classid = classid;
		this.e = e;
	}
	
	public String getId(){
		return classid;
	}
	
	public IrType getIrType(){
		return type;
	}
	
	public IrBind toIr(IrGenerationContext context) {
		String s = "";
		if(context.containsGlobalVariable(classid)){
			s+="_";
		}
		ArrayList<IrBind> arr = e.getExpressions(context);
		if(arr.size() == 0){
			IrBind b = new IrBind(new IrTypeTuple(type, s+classid), e.toIr(context), cubexContext);
			return b;
		}
		else{
			IrBind b = new IrBind(new IrTypeTuple(type, s+classid), arr.get(arr.size()-1).expression, cubexContext);
			b.temporaryBinds.addAll(arr);
			return b;
		}
	}

	public String toString() {
		return classid + " := " + e.toString() + " ;";
	}
	
	public TypeContext typeCheck(CubexCompleteContext c) throws SemanticException {
		if (c.typeContext.containsKey(classid)) throw new SemanticException("Tried to bind immutable variable (CubexBind)");
		CubexCompleteContext copy = c.clone();
		copy.typeContext.noConflictMerge(copy.mutableTypeContext);
		CubexTypeGrammar t = e.typeCheck(copy);
		type = t.toIrType();
		TypeContext typecontext = c.mutableTypeContext.clone();
		if (typecontext.containsKey(classid)) {
			typecontext.remove(classid);
		}
		typecontext.put(classid, t);
		cubexContext = c.clone();
		cubexContext.appendTypeContext(typecontext);
		return typecontext;
	}
	
	public TypeContextReturn typeCheckReturn(CubexCompleteContext c) throws SemanticException {
		if (c.typeContext.containsKey(classid)) throw new SemanticException("Tried to bind immutable variable (CubexBind)");
		CubexCompleteContext copy = c.clone();
		copy.typeContext.noConflictMerge(copy.mutableTypeContext);
		CubexTypeGrammar t = e.typeCheck(copy);
		type = t.toIrType();
		TypeContext typecontext = c.mutableTypeContext.clone();
		if (typecontext.containsKey(classid)) {
			typecontext.remove(classid);
		}
		typecontext.put(classid, t);
		CubexTypeClass nothing = new CubexTypeClass("Nothing", new CubexList<CubexTypeGrammar>());
		cubexContext = c.clone();
		cubexContext.appendTypeContext(typecontext);
		return new TypeContextReturn(typecontext, false, nothing);
	}

	@Override
	public void replaceVars(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		
	}
	
//	public TypeContextReturn typeCheckReturn(CubexCompleteContext c) throws SemanticException{
//		TypeContext t = typeCheck(c);
//		//TODO fix bug with returning null
//	
//		return new TypeContextReturn(t, false, new CubexTypeClass("Nothing", new CubexList<CubexTypeGrammar>()));
//	}
	
}