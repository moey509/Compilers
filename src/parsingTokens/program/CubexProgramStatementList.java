package parsingTokens.program;

import parsingTokens.statements.CubexList;
import parsingTokens.statements.CubexStatement;

public class CubexProgramStatementList implements CubexProgramType {
	private CubexList<CubexStatement> statementList;

	public CubexProgramStatementList(CubexList<CubexStatement> statementList) {
		this.statementList = statementList;
	}

	public String toString() {
		return statementList.toString(" ");
	}
}
