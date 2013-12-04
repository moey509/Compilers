package parsingTokens.comprehension;

import java.util.HashMap;
import java.util.Set;

import Exception.SemanticException;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public class CompPair extends Comp {
//	private Set<String> freeContext;
	
	public CompPair(CubexExpression e, Comp c) {
		this.e = e;
		this.comp = c;
	}
	
	public String toString() {
		return e.toString() + " , " + comp.toString();
	}

	@Override
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		return null;
	}

	@Override
	public void getVars(Set<String> set) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replaceVars(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		
	}

}
