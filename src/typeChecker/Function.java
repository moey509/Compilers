package typeChecker;

import parsingTokens.context.CubexTypeScheme;

public class Function {
	String functionName;
	CubexTypeScheme typeScheme;
	Statement statement;
	
	public Function(String functionName, CubexTypeScheme typeScheme,
			Statement statement) {
		this.functionName = functionName;
		this.typeScheme = typeScheme;
		this.statement = statement;
	}

	public String getFunctionName() {
		return functionName;
	}

	public CubexTypeScheme getTypeScheme() {
		return typeScheme;
	}

	public Statement getStatement() {
		return statement;
	}
}
