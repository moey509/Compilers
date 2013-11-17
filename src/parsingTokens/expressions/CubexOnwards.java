package parsingTokens.expressions;

import java.util.ArrayList;
import java.util.Set;

import ir.expressions.IrBinaryExpression;
import ir.expressions.IrOnwards;
import ir.expressions.IrUnaryExpression;
import ir.statements.IrBind;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;
import Exception.SemanticException;

public class CubexOnwards extends CubexUnaryExpression {
	boolean include;
	public CubexFunctionApp function;

	public CubexOnwards(CubexExpression l, boolean incl) {
		super(l);
		include = incl;
		type = l.type;
	}
	
	public IrUnaryExpression toIr(IrGenerationContext context) {
		if(include){
			operator = "...";
		}
		else{
			operator = "<..";
		}
		return new IrUnaryExpression(getmArgument().toIr(context), operator, cubexType);
		//return new IrOnwards(getmArgument().toIr(context), include, cubexType);
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
}
