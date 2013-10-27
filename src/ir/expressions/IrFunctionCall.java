package ir.expressions;

import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeGrammar;


public final class IrFunctionCall extends IrExpression {
	private String v_vc;
	private CubexList<CubexTypeGrammar> typeParams;
	private CubexList<IrExpression> functionParams;

	public IrFunctionCall(String v_vc,
			CubexList<CubexTypeGrammar> typeParams,
			CubexList<IrExpression> functionParams) {
		this.v_vc = v_vc;
		this.typeParams = typeParams;
		this.functionParams = functionParams;
	}
	
	public String toC() {
		return null;
	}
}