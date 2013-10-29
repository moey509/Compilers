package ir.expressions;

import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public final class IrFunctionApp extends IrExpression {
	private IrExpression expr;
	private String v_v;
	private CubexList<CubexTypeGrammar> typeParams;
	private CubexList<IrExpression> functionParams;

	public IrFunctionApp(IrExpression expr, String v_v,
			CubexList<CubexTypeGrammar> typeParams,
			CubexList<IrExpression> functionParams) {
		this.expr = expr;
		this.v_v = v_v;
		this.typeParams = typeParams;
		this.functionParams = functionParams;
	}

	public String toC() {
		return "";
	}
}
