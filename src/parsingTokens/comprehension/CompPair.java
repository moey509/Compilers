package parsingTokens.comprehension;

import ir.comp.IrComprehension;
import ir.comp.IrComprehensionPair;

import java.util.HashMap;
import java.util.Set;

import Exception.SemanticException;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import parsingTokens.typeGrammar.CubexTypeName;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;

public class CompPair extends Comp {
	//comp can be null!!
	CubexTypeGrammar cubexType;
	
	public CompPair(CubexExpression e, Comp c) {
		this.e = e;
		this.comp = c;
	}
	
	public String toString() {
		if (comp!=null) {
			return e.toString() + " , " + comp.toString();
		}
		return e.toString();
	}

	@Override
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		for(String s : c.mutableTypeContext.keySet()){
			CubexTypeGrammar g = c.mutableTypeContext.get(s);
			varList.put(s, g);
		}
		if (e == null){
			return new CubexTypeName("Nothing");
		} else {
			cubexType = e.typeCheck(c);
			if (comp == null){
				return cubexType;
			} else {
				return cubexType.join(c, comp.typeCheck(c));
			}
		}
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
		IrComprehensionPair output;
		if (comp == null){
			addStruct(context, null, extras);
			output = new IrComprehensionPair(null, e.toIr(context), cubexType, comprehensionName, nestedComprehensionName, varList);
			System.out.println("PAIR: " + this.comprehensionName);
			System.out.println("PAIRtoIR: " + this);
		}
		else{
			IrComprehension c = comp.toIr(context, extras);
			addStruct(context, c.getComprehensionName(), extras);
			nestedComprehensionName = c.getComprehensionName();
			output = new IrComprehensionPair(c, e.toIr(context), cubexType, comprehensionName, nestedComprehensionName, varList);
		}
		return output;
	}
}
