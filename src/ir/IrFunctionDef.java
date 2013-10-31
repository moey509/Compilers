package ir;

import java.util.ArrayList;

import parsingTokens.context.CubexTypeScheme;
import ir.statements.IrStatement;

public class IrFunctionDef implements IrProgramElem {
	public String name;
	public CubexTypeScheme typescheme;
	public IrStatement statement;

	public IrFunctionDef(String n, CubexTypeScheme tscheme, IrStatement s) {
		name = n;
		typescheme = tscheme;
		statement = s;
		//TODO: What happens if statement is null?
		if(s != null){
			statement = s;
		}
	}

	@Override
	public ArrayList<String> toC() {
		return null;
	}
}
