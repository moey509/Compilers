package parsingTokens.program;

import parsingTokens.CubexList;
import parsingTokens.statements.CubexStatement;
import typeChecker.CubexCompleteContext;

public class CubexProgramStatementList implements CubexProgramType {
	private CubexList<CubexStatement> statementList;

	public CubexProgramStatementList(CubexList<CubexStatement> statementList) {
		this.statementList = statementList;
	}

	public String toString() {
		return statementList.toString(" ");
	}

	@Override
	public boolean typeCheck(CubexCompleteContext c) {
		// TODO Auto-generated method stub
		System.out.println("programStatementList");
		return false;
	}
}
