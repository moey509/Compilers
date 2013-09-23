public final class CubexInteger extends CubexExpression {
	private int mValue;
	public CubexInteger(int value) {mValue = value;}
	public String toString(){
		return String.valueOf(mValue);
	}
}