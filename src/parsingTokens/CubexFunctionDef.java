package parsingTokens;

import java.util.HashMap;

import ir.program.IrFunction;
import ir.program.IrTypeTuple;
import parsingTokens.context.CubexTypeScheme;
import parsingTokens.context.CubexTypeTuple;
import parsingTokens.statements.CubexListStatement;
import parsingTokens.statements.CubexStatement;
import typeChecker.IrGenerationContext;

public class CubexFunctionDef {
	public String name;
	public CubexTypeScheme typescheme;
	public CubexStatement statement;

	public CubexFunctionDef(String n, CubexTypeScheme tscheme, CubexStatement s) {
		name = n;
		typescheme = tscheme;
		statement = s;
		if (s != null) {
			statement = new CubexListStatement(s.flatten());
		}
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

	public IrFunction toIr(IrGenerationContext context) {
		String obj = "";
		String fun = "";
				
		if (context.getCurrentClassDeclaration() != null){
			obj = context.getCurrentClassDeclaration().replaceAll("_", "__");
		}
		if (name != null){
			fun = name.replaceAll("_", "__");
		}
		IrFunction irFunction = new IrFunction(typescheme.getTypeGrammar().toIrType(), obj, fun);
		for (CubexTypeTuple tuple : typescheme.getTypeContext().iterable()) {
			IrTypeTuple argument = new IrTypeTuple(tuple.getTypeGrammar().toIrType(), tuple.getName());
			irFunction.addFunctionArgument(argument);
		}
		if(statement != null){
			irFunction.addStatement(statement.toIr(context));
		}
		return irFunction;
	}
	
	public void replaceVars(HashMap<String, String> map) {
		if (statement != null) {
			statement.replaceVars(map);
		}
		typescheme.replaceVars(map);
	}

}
