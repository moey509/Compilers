
public class CubexFunctionDef {
	String name;
	CubexTypeScheme typescheme;
	CubexStatement statement;
	
	public CubexFunctionDef(String n, CubexTypeScheme tscheme, CubexStatement s) {
		name = n;
		typescheme = tscheme;
		statement = s;
	}
	
	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append("fun ");
		build.append(name);
		build.append(" ");
		build.append(typescheme.toString(","));
		if (statement!=null) {
			build.append(" ");
			build.append(statement.toString());
		}
		
		return build.toString();
	}

}
