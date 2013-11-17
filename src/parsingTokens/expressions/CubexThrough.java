package parsingTokens.expressions;

import java.util.ArrayList;
import java.util.Set;

import ir.expressions.IrBinaryExpression;
import ir.expressions.IrThrough;
import ir.expressions.IrUnaryExpression;
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

	CubexCompleteContext cubexContext;

	public CubexThrough(CubexExpression l, CubexExpression r, boolean inclL,
			boolean inclR) {
		super(l, r);
		//expr = l;
		includeLeft = inclL;
		includeRight = inclR;
		type = l.type;
	}
	
	public IrBinaryExpression toIr(IrGenerationContext context) {
		operator = "";
		if(includeLeft){
			operator += ".";
		}
		else{
			operator += "<";
		}
		if(includeRight){
			operator += ".";
		}
		else{
			operator += "<";
		}
		return new IrBinaryExpression(getmLeft().toIr(context), getmRight().toIr(context), operator, cubexType);
		//return new IrThrough(getmLeft().toIr(context), getmRight().toIr(context), includeLeft, includeRight, cubexType);
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
		cubexType = function.typeCheck(c);
		cubexContext = c.clone();
		return cubexType;
	}
}
