package parsingTokens.expressions;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.context.CubexTypeScheme;
import parsingTokens.context.CubexTypeTuple;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.ClassContextElement;
import typeChecker.CubexCompleteContext;
import typeChecker.KindContext;
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
		// TODO: check to make sure that the expr.toString() is what we are
		// looking for
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
		// TODO

		CubexList<CubexTypeTuple> typeContext = typeScheme.getTypeContext();

		TypeContext cont = new TypeContext(typeContext);

		for (int i = 0; i < typeContext.size(); i++) {
			CubexTypeGrammar paramExpr = functionParams.get(i).typeCheck(c);
			if (!typeContext.get(i).getTypeGrammar().equals(paramExpr))
				throw new SemanticException("");
		}
		CubexTypeGrammar output = typeScheme.getTypeGrammar().replaceParams(cont)
	}
}
