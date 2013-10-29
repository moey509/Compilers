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
		ArrayList<String> arrList = new ArrayList<String>();
		for (IrStatement statement : cList.iterable())
			arrList.addAll(statement.toC());
		return arrList;
	}


}