import java.util.Map;
import java.util.IdentityHashMap;

public abstract class CubexType {
	private static CubexType mBool = new CubexBool();
	public static CubexType getBool() { return mBool; }
	private static CubexType mInt = new CubexInt();
	public static CubexType getInt() { return mInt; }

	public boolean equals(Object that) { return equals((CubexType)that); }
	public boolean equals(CubexType that) { return this == that; }
	public boolean isSubtypeOf(CubexType that) { return equals(that); }

	public boolean isBool() { return false; }
	public boolean isInt() { return false; }
	public boolean isArray() { return false; }	
}

class CubexBool extends CubexType {
	public boolean isBool() { return true; }
}

class CubexInt extends CubexType {
	public boolean isInt() { return true; }
}

