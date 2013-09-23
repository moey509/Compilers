public final class CubexBind implements CubexStatement {
	private String classid;
	private CubexExpression e;

	public CubexBind(String classid, CubexExpression e) {
		this.classid = classid;
		this.e = e;
	}

	public String toString() {
		return classid + ":=" + e.toString();
	}
}