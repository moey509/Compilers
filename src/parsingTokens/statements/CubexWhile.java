package parsingTokens.statements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import ir.expressions.IrVariableExpression;
import ir.statements.IrBind;
import ir.statements.IrFor;
import ir.statements.IrWhile;
import Exception.SemanticException;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;

public final class CubexWhile extends CubexStatement {
	private CubexStatement s;
	private Set<String> freeContext;
	
	CubexCompleteContext cubexContext;

	public CubexWhile(CubexExpression e, CubexStatement s) {
		this.e = e;
		this.s = new CubexListStatement(s.flatten());
	}
	
	public IrWhile toIr(IrGenerationContext context) {
		ArrayList<IrBind> arr = e.getExpressions(context);
		if(arr.size() == 0){
			IrWhile ir = new IrWhile(e.toIr(context), cubexContext);
			ir.addStatement(s.toIr(context));
			ir.temporaryBinds.addAll(arr);
			ir.setFreeContext(new ArrayList<String>(freeContext));
			
			return ir;
		}
		else{
			IrBind b = arr.get(arr.size()-1);
			IrWhile ir = new IrWhile(new IrVariableExpression(b.tuple.variableName), cubexContext);
			ir.temporaryBinds.addAll(arr);

			ir.addStatement(s.toIr(context));
			ir.setFreeContext(new ArrayList<String>(freeContext));
			return ir;
		}
	}

	public String toString() {
		String s2 = "while ( " + e.toString() + " ) " + s.toString();
		return s2;
	}
	
	public TypeContext typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexCompleteContext copy0 = c.clone();
		copy0.typeContext.noConflictMerge(copy0.mutableTypeContext);
		CubexTypeGrammar etype = e.typeCheck(copy0);
		if (!etype.getName().equals("Boolean")) throw new SemanticException("CubexIf: e is not a boolean");

		TypeContext t = s.typeCheck(c);
		if (!t.keySet().containsAll(c.mutableTypeContext.keySet())) {
			throw new SemanticException("CubexWhile: Resultant context does not contain initial context");
		}
		freeContext = new HashSet<String>(t.keySet());
		freeContext.removeAll(c.mutableTypeContext.keySet());
		TypeContext temp = c.mutableTypeContext.clone();
		cubexContext = c.clone();
		cubexContext.appendTypeContext(temp);
		return temp;
	}
	
	public TypeContextReturn typeCheckReturn(CubexCompleteContext c) throws SemanticException {
		CubexCompleteContext copy0 = c.clone();
		copy0.typeContext.noConflictMerge(copy0.mutableTypeContext);
		CubexTypeGrammar etype = e.typeCheck(copy0);
		if (!etype.getName().equals("Boolean")) throw new SemanticException("CubexIf: e is not a boolean");

		TypeContextReturn t = s.typeCheckReturn(c);
//		if (!t.typeContext.containsAll(c, c.mutableTypeContext)) {
//			throw new SemanticException("CubexWhile: Resultant context does not contain initial context");
//		}
		TypeContext ret = t.typeContext.containsAll(c, c.mutableTypeContext);
		freeContext = new HashSet<String>(t.typeContext.keySet());
		freeContext.removeAll(ret.keySet());
		TypeContextReturn temp = new TypeContextReturn(ret, false, t.retType);
		cubexContext = c.clone();
		return temp;
		
	}

	@Override
	public void replaceVars(HashMap<String, String> map) {
		e.replaceVars(map);
		s.replaceVars(map);
		// replace variables in freeContext
		for (String s : map.keySet()) {
			if (freeContext.contains(s)) {
				freeContext.remove(s);
				freeContext.add(map.get(s));
			}
		}
	}
}
