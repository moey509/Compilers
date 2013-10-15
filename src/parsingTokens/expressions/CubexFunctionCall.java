package parsingTokens.expressions;

import java.util.ArrayList;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.context.CubexTypeScheme;
import parsingTokens.context.CubexTypeTuple;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import parsingTokens.typeGrammar.CubexTypeName;
import typeChecker.CubexCompleteContext;
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

	public String toString() {
		String rightSpace1 = typeParams.size() == 0 ? "" : " ";
		String rightSpace2 = functionParams.size() == 0 ? "" : " ";
		return v_vc + " < " + typeParams.toString(",") + rightSpace1 + "> ( "
				+ functionParams.toString(",") + rightSpace2 + ")";
	}

	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexTypeScheme typeScheme;
		if (c.containsFunctionName(v_vc)) {
			typeScheme = c.getTypeSchemeFromFunctionContext(v_vc);
		} else {
			throw new SemanticException("");
		}

		ArrayList<String> kContext = new ArrayList<String>(typeScheme.getKindContext().contextCollection);
		//System.out.println("kContext: " + kContext);
		ArrayList<CubexTypeGrammar> params = new ArrayList<CubexTypeGrammar>(typeParams.contextCollection);
		//System.out.println("params: " + params);
		//TODO: Need to do something with this mapping!
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
			if (!typeContext.get(i).getTypeGrammar().isSuperTypeOf(c, paramExpr)){
				//System.out.println(typeContext.get(i).getTypeGrammar() + " is a supertype of " + paramExpr);
				throw new SemanticException("Expected argument of type " + typeContext.get(i).getTypeGrammar() + " but received " + paramExpr);
			}
		}
		CubexTypeGrammar output = typeScheme.getTypeGrammar().replaceParams(cont);
		return output;
	}
}