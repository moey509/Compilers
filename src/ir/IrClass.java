package ir;

import java.util.ArrayList;

import parsingTokens.CubexList;
import ir.expressions.IrExpression;
import ir.statements.IrStatement;

public class IrClass implements IrProgramElem {
	public String name;
	public CubexList<String> kindcontext;
	public CubexList<IrStatement> statements;
	public CubexList<IrExpression> expressions;
	public CubexList<IrFunctionDef> functions;

	public IrClass(String n, CubexList<String> k,
			CubexList<IrStatement> s, CubexList<IrExpression> e,
			CubexList<IrFunctionDef> f) {
		name = n;
		kindcontext = k;
		statements = s;
		expressions = e;
		functions = f;
	}

	@Override
	public ArrayList<String> toC() {
		
		return null;
	}

}
