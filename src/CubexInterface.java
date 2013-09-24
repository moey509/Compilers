
public class CubexInterface {
	String name;
	CubexList<String> kindcontext;
	CubexTypeGrammar type;
	CubexList<CubexFunctionDef> list;
	public CubexInterface(String n, CubexList<String> k, CubexTypeGrammar t, CubexList<CubexFunctionDef> l) {
		name = n;
		kindcontext = k;
		type = t;
		list = l;
	}
	
	public String toString() {
		String rightSpace1 = kindcontext.size() == 0 ? "" : " ";
		String rightSpace2 = list.size() == 0 ? "" : " ; ";
		StringBuilder build = new StringBuilder();
		build.append("interface ");
		build.append(name);
		build.append(" < ");
		build.append(kindcontext.toString(","));
		build.append(rightSpace1);
		build.append("> extends ");
		build.append(type);
		build.append(" { ");
		build.append(list.toString(";"));
		build.append(rightSpace2);
		build.append("}");
		return build.toString();
	}

}
