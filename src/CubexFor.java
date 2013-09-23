public final class CubexFor implements CubexStatement {
	private String varfun;
	private CubexExpression e;
	private CubexStatement s;

	public CubexFor(String varfun, CubexExpression e, CubexStatement s) {
		this.varfun = varfun;
		this.e = e;
		this.s = s;
	}

	public String toString() {
		return "for ( " + varfun + " in " + e.toString() + " ) " + s.toString();
	}
}


