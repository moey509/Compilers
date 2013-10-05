package typeChecker;

public abstract class StatementTypeCheck {
	ClassContext classContext;
	KindContext kindContext;
	FunctionContext functionContext;
	TypeContext typeContext;

	public StatementTypeCheck(ClassContext classContext,
			KindContext kindContext, FunctionContext functionContext,
			TypeContext typeContext) {
		this.classContext = classContext;
		this.kindContext = kindContext;
		this.functionContext = functionContext;
		this.typeContext = typeContext;
	}

	public abstract boolean typeCheck();
}
