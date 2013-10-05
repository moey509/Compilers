package typeChecker;

public abstract class ProgramTypeCheck {

	public ProgramTypeCheck(ClassContext classContext, KindContext kindContext,
			FunctionContext functionContext, TypeContext typeContext) {
	}

	public abstract boolean typeCheck();
}
