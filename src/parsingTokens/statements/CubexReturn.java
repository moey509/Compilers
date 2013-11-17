package parsingTokens.statements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import ir.expressions.IrVariableExpression;
import ir.program.IrTypeTuple;
import ir.statements.IrBind;
import ir.statements.IrReturn;
import Exception.SemanticException;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;

public final class CubexReturn extends CubexStatement {
	// does not exist until after typeCheck is called
	private Set<String> freeContext;
	
	CubexCompleteContext cubexContext;

	public CubexReturn(CubexExpression e) {
		this.e = e;
	}
	
	public CubexExpression gete() {
		return e;
	}
	
	public IrReturn toIr(IrGenerationContext context) {
//		System.out.println("before");
		ArrayList<IrBind> arr = e.getExpressions(context);
//		System.out.println("after");
		if(arr.size() == 0){
			IrReturn ir = new IrReturn(e.toIr(context), cubexContext);
			ir.setFreeContext(new ArrayList<String>(freeContext));
			return ir;
		}
		else{
			IrReturn ir = new IrReturn(new IrVariableExpression(arr.get(arr.size()-1).tuple.variableName, arr.get(arr.size()-1).tuple.type.type), cubexContext);
			ir.setFreeContext(new ArrayList<String>(freeContext));
			ir.temporaryBinds = arr;
//			System.out.println("In cubexreturn: " + ir.temporaryBinds);
			return ir;
		}
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
		CubexTypeGrammar etype = e.typeCheck(copy0);

		freeContext = c.mutableTypeContext.keySet();
		Set<String> set = new HashSet<String>();
		e.getVars(set);
		freeContext.removeAll(set);
		TypeContextReturn temp = new TypeContextReturn(c.mutableTypeContext.clone(), true, etype);
		cubexContext = c.clone();
		return temp;
	}

	@Override
	public void replaceVars(HashMap<String, String> map) {
		e.replaceVars(map);
		for (String s : map.keySet()) {
			if (freeContext.contains(s)) {
				freeContext.remove(s);
				freeContext.add(map.get(s));
			}
		}
	}
}

