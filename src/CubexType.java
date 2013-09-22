import java.util.Map;
import java.util.IdentityHashMap;

public abstract class CubexType {
	private static CubexType mBool = new CubexBool();
	public static CubexType getBool() { return mBool; }
	private static CubexType mInt = new CubexInt();
	public static CubexType getInt() { return mInt; }
	private static Map<CubexType,CubexType> mArrays = new IdentityHashMap<CubexType,CubexType>();
	public static CubexType getArray(CubexType elemType) {
		CubexType array = mArrays.get(elemType);
		if (array == null) {
			array = new CubexArray(elemType);
			mArrays.put(elemType, array);
		}
		return array;
	}

	public boolean equals(Object that) { return equals((CubexType)that); }
	public boolean equals(CubexType that) { return this == that; }
	public boolean isSubtypeOf(CubexType that) { return equals(that); }

	public boolean isBool() { return false; }
	public boolean isInt() { return false; }
	public boolean isArray() { return false; }	
	public CubexType getArrayArgument() throws NoSuchTypeException {
		throw new NoSuchTypeException("Error in CubexTypes");
	}
}

class CubexBool extends CubexType {
	public boolean isBool() { return true; }
}

class CubexInt extends CubexType {
	public boolean isInt() { return true; }
}

class CubexArray extends CubexType {
	private CubexType mElemType;
	public CubexArray(CubexType elemType) { mElemType = elemType; }
	public boolean isArray() { return true; }
	public CubexType getArrayArgument() throws NoSuchTypeException {
		return mElemType;
	}
}