package ir.statements;

import parsingTokens.CubexList;
import parsingTokens.statements.CubexStatement;


public final class IrListStatement extends CubexStatement {
	private CubexList<CubexStatement> cList;
	public static boolean flatten = false;

	public IrListStatement(CubexList<CubexStatement> cList) {
		this.cList = cList;
	}


}