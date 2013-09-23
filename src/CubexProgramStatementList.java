public class CubexProgramStatementList implements CubexProgramType {
	private CubexList<CubexStatement> statementList;

	public CubexProgramStatementList(CubexList<CubexStatement> statementList) {
		this.statementList = statementList;
	}

	public String toString() {
		return statementList.toString(" ");
	}
}
