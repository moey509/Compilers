package parsingTokens.expressions;

import java.util.ArrayList;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.context.CubexTypeScheme;
import parsingTokens.context.CubexTypeTuple;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.TypeContext;

public final class CubexFunctionApp extends CubexExpression {
	private CubexExpression expr;
	private String v_v;
	private CubexList<CubexTypeGrammar> typeParams;
	private CubexList<CubexExpression> functionParams;

	public CubexFunctionApp(CubexExpression expr, String v_v,
			CubexList<CubexTypeGrammar> typeParams,
			CubexList<CubexExpression> functionParams) {
		this.expr = expr;
		this.v_v = v_v;
		this.typeParams = typeParams;
		this.functionParams = functionParams;
	}

	public String toString() {
		String rightSpace1 = typeParams.size() == 0 ? "" : " ";
		String rightSpace2 = functionParams.size() == 0 ? "" : " ";
		return expr.toString() + " . " + v_v + " < " + typeParams.toString(",")
				+ rightSpace1 + "> ( " + functionParams.toString(",")
				+ rightSpace2 + ")";
	}

	// Check if the expression is of some type
	public CubexTypeGrammar typeCheck(CubexCompleteContext c)
			throws SemanticException {
		CubexTypeGrammar objectType = expr.typeCheck(c);
		CubexTypeScheme typeScheme = c.methodLookup(objectType, v_v);

		ArrayList<String> kContext = new ArrayList<String>(
				typeScheme.getKindContext().contextCollection);
		ArrayList<CubexTypeGrammar> params = new ArrayList<CubexTypeGrammar>(
				typeParams.contextCollection);

		if (kContext.size() != params.size()) {
			throw new SemanticException("Incorrect number of parameters");
		}
		TypeContext cont = new TypeContext();
		for (int i = 0; i < kContext.size(); i++) {
			cont.put(kContext.get(i), params.get(i));
		}

		CubexList<CubexTypeTuple> typeContext = typeScheme.getTypeContext();

		for (int i = 0; i < typeContext.size(); i++) {
			CubexTypeGrammar paramExpr = functionParams.get(i).typeCheck(c);
			if (!typeContext.get(i).getTypeGrammar().equals(paramExpr))
				throw new SemanticException("");
		}
		CubexTypeGrammar output = typeScheme.getTypeGrammar().replaceParams(
				cont);
		return output;
	}
}
