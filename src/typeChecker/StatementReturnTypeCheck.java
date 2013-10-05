package typeChecker;

public class StatementReturnTypeCheck extends StatementTypeCheck {

	public StatementReturnTypeCheck(ClassContext classContext,
			KindContext kindContext, FunctionContext functionContext,
			TypeContext typeContext) {
		super(classContext, kindContext, functionContext, typeContext);
	}

	public boolean typeCheck() {
		return false;
	}
}
