package parsingTokens.comprehension;

import java.util.HashMap;
import java.util.Set;

import Exception.SemanticException;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public class CompIf extends Comp {
//	private Set<String> freeContext;
	
	public CompIf(CubexExpression e, Comp c) {
		this.e = e;
		this.comp = c;
	}
	
	public String toString() {
		return "if ( " + e.toString() + " ) " + comp.toString();
	}

	@Override
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		if (!e.typeCheck(c).getName().equals("Boolean"))
			throw new SemanticException(e.toString() + " must be of type Boolean");
		if (comp == null)
			throw new SemanticException("Cannot have a null comprehension following an if");
		return comp.typeCheck(c);
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
