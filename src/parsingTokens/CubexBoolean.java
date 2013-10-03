package parsingTokens;

import parsingTokens.context.CubexExpression;

public final class CubexBoolean extends CubexExpression {
	private boolean mValue;
	public CubexBoolean(boolean value) { mValue = value; }
	
	public String toString(){
		return mValue ? "true" : "false";
	}
}