package parsingTokens.expressions;

import java.util.ArrayList;
import java.util.Set;

import ir.expressions.IrOnwards;
import ir.statements.IrBind;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;
import Exception.SemanticException;

public class CubexOnwards extends CubexUnaryExpression {
	boolean include;
	public CubexFunctionApp function;
	
	CubexTypeGrammar cubexType;

	public CubexOnwards(CubexExpression l, boolean incl) {
		super(l);
		include = incl;
		type = l.type;
	}
	
	public IrOnwards toIr(IrGenerationContext context) {
		return new IrOnwards(getmArgument().toIr(context), include, cubexType);
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
		cubexType = function.typeCheck(c);
		return cubexType;
	}
	public ArrayList<IrBind> getExpressions(IrGenerationContext context){
		ArrayList<IrBind> arr = function.getExpressions(context);
		return arr;
	}
}
