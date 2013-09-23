
public class CubexFunctionDef {
	String name;
	CubexTypeScheme typescheme;
	CubexList<CubexStatement> statements;
	
	public CubexFunctionDef(String n, CubexTypeScheme tscheme, CubexList<CubexStatement> s) {
		name = n;
		typescheme = tscheme;
		statements = s;
	}
	
	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append("fun ");
		build.append(name);
		build.append(" ");
		build.append(typescheme.toString());
		if (statements!=null) {
			build.append(" ");
			build.append(statements.toString());
		}
		build.append(" ;");
		
		return build.toString();
	}

}
