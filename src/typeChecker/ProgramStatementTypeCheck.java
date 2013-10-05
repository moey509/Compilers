package typeChecker;

public class ProgramStatementTypeCheck extends ProgramTypeCheck {

	public ProgramStatementTypeCheck(ClassContext classContext,
			KindContext kindContext, FunctionContext functionContext,
			TypeContext typeContext) {
		super(classContext, kindContext, functionContext, typeContext);
	}

	@Override
	public boolean typeCheck() {
		return false;
	}

}
