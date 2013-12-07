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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replaceVars(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IrComprehension toIr(IrGenerationContext context) {
		IrComprehensionPair output;
		if (comp == null){
			output = new IrComprehensionPair(null, e.toIr(context), cubexType);
		}
		else{
			output = new IrComprehensionPair(comp.toIr(context), e.toIr(context), cubexType);
		}
		return output;
	}
}
