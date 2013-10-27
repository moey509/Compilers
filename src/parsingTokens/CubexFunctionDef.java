package parsingTokens;

import ir.IrFunctionDef;
import parsingTokens.context.CubexTypeScheme;
import parsingTokens.statements.CubexListStatement;
import parsingTokens.statements.CubexStatement;

public class CubexFunctionDef {
	public String name;
	public CubexTypeScheme typescheme;
	public CubexStatement statement;

	public CubexFunctionDef(String n, CubexTypeScheme tscheme, CubexStatement s) {
		name = n;
		typescheme = tscheme;
		statement = s;
		//TODO: What happens if statement is null?
		if(s != null){
			statement = new CubexListStatement(s.flatten());
		}
	}
	
	public IrFunctionDef toIr() {
		return new IrFunctionDef(name, typescheme, statement.toIr());
	}

	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append("fun ");
		build.append(name);
		build.append(" ");
		build.append(typescheme.toString(","));
		if (statement != null) {
			build.append(" ");
			build.append(statement.toString());
		}

		return build.toString();
	}

}
