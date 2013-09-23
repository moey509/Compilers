public final class CubexWhile implements CubexStatement {
	private CubexExpression e;
	private CubexStatement s;

	public CubexWhile(CubexExpression e, CubexStatement s) {
		this.e = e;
		this.s = s;
	}

	public String toString() {
		return "while (" + e.toString() + ") " + s.toString();
	}
}
