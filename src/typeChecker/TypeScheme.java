package typeChecker;

import parsingTokens.typeGrammar.CubexTypeGrammar;

public class TypeScheme {
	private KindContext kindContext;
	private TypeContext typeContext;
	private CubexTypeGrammar returnType;
	
	public TypeScheme(KindContext kindContext, TypeContext typeContext,
			CubexTypeGrammar returnType) {
		this.kindContext = kindContext;
		this.typeContext = typeContext;
		this.returnType = returnType;
	}

	public KindContext getKindContext() {
		return kindContext;
	}

	public TypeContext getTypeContext() {
		return typeContext;
	}

	public CubexTypeGrammar getReturnType() {
		return returnType;
	}

}
