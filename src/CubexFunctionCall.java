public final class CubexFunctionCall extends CubexExpression {
	private String v_vc;
	private CubexList<CubexTypeGrammar> typeParams;
	private CubexList<CubexExpression> functionParams;

	public CubexFunctionCall(String v_vc, CubexList<CubexTypeGrammar> typeParams, CubexList<CubexExpression> functionParams) {
		this.v_vc = v_vc;
		this.typeParams = typeParams;
		this.functionParams = functionParams;
	}

	public String toString() {
		return v_vc + "<" + typeParams.toString(",") + ">" + "(" + functionParams.toString(",") + ")";
	}
}