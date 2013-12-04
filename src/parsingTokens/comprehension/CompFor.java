package parsingTokens.comprehension;

import java.util.HashMap;
import java.util.Set;

import Exception.SemanticException;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public class CompFor extends Comp {
	private String v;
//	private Set<String> freeContext;
	
	public CompFor(String v, CubexExpression e, Comp c) {
		this.v = v;
		this.e = e;
		this.comp = c;
	}

	public String toString() {
		return "for ( " + v + " in " + e.toString() + " ) " + comp.toString();
	}

	@Override
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		// TODO Auto-generated method stub
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
