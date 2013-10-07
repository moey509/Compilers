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

	public CubexFunctionApp(CubexExpression expr, String v_v, CubexList<CubexTypeGrammar> typeParams, CubexList<CubexExpression> functionParams) {
		this.expr = expr;
		this.v_v = v_v;
		this.typeParams = typeParams;
		this.functionParams = functionParams;
	}

	public String toString() {
		//TODO: check to make sure that the expr.toString() is what we are looking for
		String rightSpace1 = typeParams.size() == 0 ? "" : " ";
		String rightSpace2 = functionParams.size() == 0 ? "" : " ";
		return expr.toString() + " . " + v_v + " < " + typeParams.toString(",") + rightSpace1 + "> ( " + functionParams.toString(",") + rightSpace2 + ")";
	}
	
	// Check if the expression is of some type
	public CubexTypeGrammar typeCheck(CubexCompleteContext c, CubexTypeGrammar t)
			throws SemanticException {
		CubexTypeGrammar objectType = expr.typeCheck(c, t);
		ClassContextElement classContext;
		CubexTypeScheme typeScheme;
		if (c.containsClassName(objectType.name)) {
			classContext = c.getElementFromClassContext(objectType.name);
		}
		else {
			throw new SemanticException("");
		}
		if(classContext.functionMap.containsKey(v_v)){
			typeScheme = classContext.functionMap.get(v_v);
		}
		else {
			throw new SemanticException("");
		}
		
		CubexList<String> kindContext = typeScheme.getKindContext();
		
		
		
		CubexList<CubexTypeTuple> typeContext = typeScheme.getTypeContext();

		for (int i = 0; i < typeContext.size(); i++){
			if typeContext.get(i).
		
		CubexTypeGrammar typeGrammar = typeScheme.getTypeGrammar();
		
	}

	public CubexTypeGrammar typeCheck(CubexCompleteContext c, CubexTypeClass t)
			throws SemanticException {
		
	}

	// Check if the expression is of some list of types
	public CubexTypeGrammar typeCheck(CubexCompleteContext c,
			CubexList<CubexTypeGrammar> t) throws SemanticException {
		return new CubexTypeClass("Integer", new CubexList<CubexTypeGrammar>());
	}
}
}