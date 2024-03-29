package parsingTokens.comprehension;

import ir.comp.IrComprehension;
import ir.comp.IrComprehensionFor;
import ir.comp.IrComprehensionIf;

import java.util.HashMap;
import java.util.Set;

import Exception.SemanticException;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;

public class CompIf extends Comp {
	CubexTypeGrammar cubexType;
	
	
	public CompIf(CubexExpression e, Comp c) {
		this.e = e;
		this.comp = c;
	}
	
	public String toString() {
		return "if ( " + e.toString() + " ) " + comp.toString();
	}

	@Override
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		for(String s : c.mutableTypeContext.keySet()){
			CubexTypeGrammar g = c.mutableTypeContext.get(s);
			varList.put(s, g);
		}
		if (!e.typeCheck(c).getName().equals("Boolean"))
			throw new SemanticException(e.toString() + " must be of type Boolean");
		if (comp == null)
			throw new SemanticException("Cannot have a null comprehension following an if");
		cubexType = comp.typeCheck(c);
		return cubexType;
	}

	@Override
	public void getVars(Set<String> set) {
		e.getVars(set);
		if (comp!=null) {
			comp.getVars(set);
		}
	}

	@Override
	public void replaceVars(HashMap<String, String> map) {
		e.replaceVars(map);
		if (comp!=null) {
			comp.replaceVars(map);
		}
	}

	@Override
	public IrComprehension toIr(IrGenerationContext context, HashMap<String, CubexTypeGrammar> extras) {
		IrComprehension c = comp.toIr(context, extras);
		addStruct(context, c.getComprehensionName(), extras);
		nestedComprehensionName = c.getComprehensionName();
		return new IrComprehensionIf(c, e.toIr(context), cubexType, comprehensionName, nestedComprehensionName, varList, extras);
	}

}
