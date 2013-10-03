package parsingTokens.program;

import parsingTokens.statements.CubexStatement;

public class CubexProgramStatement implements CubexProgramType {
	private CubexStatement statement;

	public CubexProgramStatement(CubexStatement statement) {
		this.statement = statement;
	}

	public String toString() {
		return statement.toString();
	}
}
