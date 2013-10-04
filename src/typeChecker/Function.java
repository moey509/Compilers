package typeChecker;

public class Function {
	String functionName;
	TypeScheme typeScheme;
	Statement statement;
	
	public Function(String functionName, TypeScheme typeScheme,
			Statement statement) {
		this.functionName = functionName;
		this.typeScheme = typeScheme;
		this.statement = statement;
	}

	public String getFunctionName() {
		return functionName;
	}

	public TypeScheme getTypeScheme() {
		return typeScheme;
	}

	public Statement getStatement() {
		return statement;
	}
}
