package parsingTokens.expressions;


public final class CubexString extends CubexExpression {
	private String mValue;
	public CubexString(String value) { mValue = value; }
	public String toString(){
		return mValue;
	}
}