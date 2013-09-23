public final class CubexListStatement implements CubexStatement {
	private CubexList<CubexStatement> cList;

	public CubexListStatement(CubexList<CubexStatement> cList) {
		this.cList = cList;
	}

	public String toString() {
		String rightSpace = cList.size() == 0 ? "" : " ";
		return "{ " + cList.toString(" ") + rightSpace + "}";
	}
}