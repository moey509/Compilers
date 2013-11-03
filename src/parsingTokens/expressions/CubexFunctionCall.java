package parsingTokens.expressions;

import ir.expressions.IrExpression;
import ir.expressions.IrFunctionCall;

import java.util.ArrayList;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.context.CubexTypeScheme;
import parsingTokens.context.CubexTypeTuple;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;
import typeChecker.TypeContext;

public final class CubexFunctionCall extends CubexExpression {
	private String v_vc;
	private CubexList<CubexTypeGrammar> typeParams;
	private CubexList<CubexExpression> functionParams;

	public CubexFunctionCall(String v_vc,
			CubexList<CubexTypeGrammar> typeParams,
			CubexList<CubexExpression> functionParams) {
		this.v_vc = v_vc;
		this.typeParams = typeParams;
		this.functionParams = functionParams;
	}

	public IrFunctionCall toIr(IrGenerationContext context) {
		//TODO something with context to know which function to call in c
		IrFunctionCall irFunCall;
		if (context.containsGlobalFunction("_" + v_vc)){
			irFunCall = new IrFunctionCall("_" + v_vc);
		}
		else{
			irFunCall = new IrFunctionCall(v_vc);
		}
		for (CubexExpression i : functionParams.contextCollection) {
			irFunCall.addArgument(i.toIr(context));
		}
		return irFunCall;
	}

	public String toString() {
		String rightSpace1 = typeParams.size() == 0 ? "" : " ";
		String rightSpace2 = functionParams.size() == 0 ? "" : " ";
		return v_vc + " < " + typeParams.toString(",") + rightSpace1 + "> ( "
				+ functionParams.toString(",") + rightSpace2 + ")";
	}

	public CubexTypeGrammar typeCheck(CubexCompleteContext c)
			throws SemanticException {
		CubexTypeScheme typeScheme;
		if (c.containsFunctionName(v_vc)) {
			typeScheme = c.getTypeSchemeFromFunctionContext(v_vc);
		} else {
			throw new SemanticException(v_vc
					+ " is not contained in function context");
		}

		// Get the Function Kind Context
		ArrayList<String> kContext = new ArrayList<String>(
				typeScheme.getKindContext().contextCollection);

		// Get the Function Types
		ArrayList<CubexTypeGrammar> params = new ArrayList<CubexTypeGrammar>(
				typeParams.contextCollection);

		// Check to see if number of Function type params matches the number of
		// types given to the function
		if (kContext.size() != params.size()) {
			throw new SemanticException("Incorrect number of parameters");
		}

		TypeContext cont = new TypeContext();
		for (int i = 0; i < kContext.size(); i++) {
			cont.put(kContext.get(i), params.get(i));
			if (!c.containsClassName(params.get(i).getName())
					&& !c.kindContextContainsTypeParam(params.get(i).getName())) {
				throw new SemanticException(params.get(i).getName()
						+ " is not a valid type.");
			}
		}

		CubexList<CubexTypeTuple> typeContext = typeScheme.getTypeContext();

		for (int i = 0; i < typeContext.size(); i++) {
			CubexTypeGrammar paramExpr = functionParams.get(i).typeCheck(c);
			// Replace generic types and check for supertype
			if (!typeContext.get(i).getTypeGrammar().replaceParams(cont)
					.isSuperTypeOf(c, paramExpr)) {
				throw new SemanticException("Expected argument of type "
						+ typeContext.get(i).getTypeGrammar()
						+ " but received " + paramExpr);
			}
		}
		CubexTypeGrammar output = typeScheme.getTypeGrammar().replaceParams(
				cont);
		return output;
	}
}