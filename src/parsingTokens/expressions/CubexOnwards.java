package parsingTokens.expressions;

import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import Exception.SemanticException;


public class CubexOnwards extends CubexUnaryExpression {
	boolean include;
	public CubexOnwards(CubexExpression l, boolean incl) {
		super(l);
		include = incl;
	}
	
	public String toString(){
		return getmArgument().toString() + " . onwards < > ( " + (include ? "true" : "false") + " )";
	}

	//Returns an Iterable of Integer
		public CubexTypeGrammar typeCheck(CubexCompleteContext c,
				CubexList<CubexTypeGrammar> t) throws SemanticException {
			CubexList<CubexTypeGrammar> l = new CubexList<CubexTypeGrammar>();
			l.add(new CubexTypeClass("Integer", new CubexList<CubexTypeGrammar>()));
			return new CubexTypeClass("Iterable", l);
		}
}
