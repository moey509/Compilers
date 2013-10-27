package ir.statements;

import java.util.ArrayList;

import parsingTokens.CubexList;
import ir.statements.IrStatement;

public class IrListStatement extends IrStatement {
	private CubexList<IrStatement> cList;
	public static boolean flatten = false;

	public IrListStatement(CubexList<IrStatement> cList) {
		this.cList = cList;
	}

	@Override
	public ArrayList<String> toC() {
		// TODO Auto-generated method stub
		return null;
	}


}