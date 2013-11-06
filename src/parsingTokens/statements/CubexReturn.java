package parsingTokens.statements;

import java.util.ArrayList;
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
	private Set<String> freeContext;

	public CubexReturn(CubexExpression e) {
		this.e = e;
	}
	
	public IrReturn toIr(IrGenerationContext context) {
		ArrayList<IrBind> arr = e.getExpressions(context);
		if(arr.size() == 0){
			IrReturn ir = new IrReturn(e.toIr(context));
			ir.setFreeContext(new ArrayList<String>(freeContext));
			return ir;
		}
		else{
			IrReturn ir = new IrReturn(new IrVariableExpression(arr.get(arr.size()-1).tuple.variableName, arr.get(arr.size()-1).tuple.type.type));
			ir.setFreeContext(new ArrayList<String>(freeContext));
			ir.temporaryBinds = arr;
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

		return new TypeContextReturn(c.mutableTypeContext.clone(), true, etype);
	}
}

