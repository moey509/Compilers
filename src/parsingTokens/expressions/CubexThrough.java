package parsingTokens.expressions;

import java.util.ArrayList;
import java.util.Set;

import ir.expressions.IrThrough;
import ir.statements.IrBind;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;
import Exception.SemanticException;

public class CubexThrough extends CubexBinaryExpression {
	private boolean includeLeft;
	private boolean includeRight;
	//private CubexExpression expr;
	public CubexFunctionApp function;

	public CubexThrough(CubexExpression l, CubexExpression r, boolean inclL,
			boolean inclR) {
		super(l, r);
		//expr = l;
		includeLeft = inclL;
		includeRight = inclR;
	}
	
	public IrThrough toIr(IrGenerationContext context) {
		return new IrThrough(getmLeft().toIr(context), getmRight().toIr(context), includeLeft, includeRight);
	}

	public String toString() {
		String incL = includeLeft ? "true" : "false";
		String incR = includeRight ? "true" : "false";
		return getmLeft().toString() + " . through < > ( "
				+ getmRight().toString() + " , " + incL + " , " + incR + " )";
	}

	//Returns an Iterable of Integer
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexList<CubexExpression> l = new CubexList<CubexExpression>();
		l.add(super.getmRight());
		l.add(new CubexBoolean(false));
		l.add(new CubexBoolean(false));
		function = new CubexFunctionApp(super.getmLeft(), "through",
				new CubexList<CubexTypeGrammar>(), l);
		return function.typeCheck(c);
	}
	public ArrayList<IrBind> getExpressions(IrGenerationContext context){
		ArrayList<IrBind> arr = function.getExpressions(context);
		return arr;
	}
}
