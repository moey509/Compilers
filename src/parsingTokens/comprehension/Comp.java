package parsingTokens.comprehension;

import java.util.HashMap;
import java.util.Set;

import Exception.SemanticException;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public abstract class Comp {
	protected CubexExpression e;
	protected Comp comp; // can be null - needs to be checked
	
	public abstract CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException;
	public abstract void getVars(Set<String> set);
	public abstract void replaceVars(HashMap<String, String> map);

}
