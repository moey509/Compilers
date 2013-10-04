package typeChecker;

public class TypeScheme {
	private KindContext kindContext;
	private TypeContext typeContext;
	private Type returnType;
	
	public TypeScheme(KindContext kindContext, TypeContext typeContext,
			Type returnType) {
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

	public Type getReturnType() {
		return returnType;
	}

}
