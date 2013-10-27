package parsingTokens.expressions;

import ir.expressions.IrOnwards;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import Exception.SemanticException;

public class CubexOnwards extends CubexUnaryExpression {
	boolean include;
	public CubexFunctionApp function;

	public CubexOnwards(CubexExpression l, boolean incl) {
		super(l);
		include = incl;
	}
	
	public IrOnwards toIr() {
		return new IrOnwards(getmArgument().toIr(), include);
	}

	public String toString() {
		return getmArgument().toString() + " . onwards < > ( "
				+ (include ? "true" : "false") + " )";
	}

	// Returns an Iterable of Integer
	public CubexTypeGrammar typeCheck(CubexCompleteContext c)
			throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		l.add(new CubexBoolean(false));
		function = new CubexFunctionApp(super.getmArgument(), "onwards",
				new CubexList<CubexTypeGrammar>(), l);
		return function.typeCheck(c);
	}
}
