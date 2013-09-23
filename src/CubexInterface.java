
public class CubexInterface {
	String name;
	CubexList<String> kindcontext;
	CubexTypeGrammar typecontext;
	CubexList<CubexFunctionDef> list;
	public CubexInterface(String n, CubexList<String> k, CubexTypeGrammar t, CubexList<CubexFunctionDef> l) {
		name = n;
		kindcontext = k;
		typecontext = t;
		list = l;
	}
	
	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append("interface ");
		build.append(name);
		build.append(" < ");
		build.append(kindcontext.toString());
		build.append(" > extends ");
		build.append((typecontext==null) ? "Thing" : typecontext.toString());
		build.append(" { ");
		build.append(list.toString());
		build.append(" }");
		return build.toString();
	}

}