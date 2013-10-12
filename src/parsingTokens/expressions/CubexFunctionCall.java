package parsingTokens.expressions;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.context.CubexTypeScheme;
import parsingTokens.context.CubexTypeTuple;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import parsingTokens.typeGrammar.CubexTypeName;
import typeChecker.CubexCompleteContext;

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

	public String toString() {
		String rightSpace1 = typeParams.size() == 0 ? "" : " ";
		String rightSpace2 = functionParams.size() == 0 ? "" : " ";
		return v_vc + " < " + typeParams.toString(",") + rightSpace1 + "> ( "
				+ functionParams.toString(",") + rightSpace2 + ")";
	}

	// Check if the expression is of some type
	public CubexTypeGrammar typeCheck(CubexCompleteContext c, CubexTypeGrammar t)
			throws SemanticException {

		CubexTypeGrammar nothing = new CubexTypeName("Nothing");
		CubexTypeScheme typeScheme = c.methodLookup(nothing, v_vc);

		CubexList<String> kindContext = typeScheme.getKindContext();
		// TODO implement this later

		CubexList<CubexTypeTuple> typeContext = typeScheme.getTypeContext();

		for (int i = 0; i < typeContext.size(); i++) {
			CubexTypeGrammar paramExpr = functionParams.get(i).typeCheck(c);
			if (!typeContext.get(i).getTypeGrammar().equals(paramExpr))
				throw new SemanticException("");
		}
		return typeScheme.getTypeGrammar();

	}

	public CubexTypeGrammar typeCheck(CubexCompleteContext c, CubexTypeClass t)
			throws SemanticException {
		CubexTypeScheme typeScheme;
		if (c.containsFunctionName(v_vc)) {
			typeScheme = c.getTypeSchemeFromFunctionContext(v_vc);
		} else {
			throw new SemanticException("");
		}

		CubexList<String> kindContext = typeScheme.getKindContext();
		// TODO implement this later

		CubexList<CubexTypeTuple> typeContext = typeScheme.getTypeContext();

		for (int i = 0; i < typeContext.size(); i++) {
			CubexTypeGrammar paramExpr = functionParams.get(i).typeCheck(c);
			if (!typeContext.get(i).getTypeGrammar().equals(paramExpr))
				throw new SemanticException("");
		}
		return typeScheme.getTypeGrammar();

	}

	// Check if the expression is of some list of types
	public CubexTypeGrammar typeCheck(CubexCompleteContext c,
			CubexList<CubexTypeGrammar> t) throws SemanticException {
		CubexTypeScheme typeScheme;
		if (c.containsFunctionName(v_vc)) {
			typeScheme = c.getTypeSchemeFromFunctionContext(v_vc);
		} else {
			throw new SemanticException("");
		}

		CubexList<String> kindContext = typeScheme.getKindContext();
		// TODO implement this later

		CubexList<CubexTypeTuple> typeContext = typeScheme.getTypeContext();

		for (int i = 0; i < typeContext.size(); i++) {
			CubexTypeGrammar paramExpr = functionParams.get(i).typeCheck(c);
			if (!typeContext.get(i).getTypeGrammar().equals(paramExpr))
				throw new SemanticException("");
		}
		return typeScheme.getTypeGrammar();

	}
}