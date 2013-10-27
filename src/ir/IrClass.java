package ir;

import java.util.ArrayList;

import parsingTokens.CubexList;
import parsingTokens.context.CubexTypeTuple;
import ir.expressions.IrExpression;
import ir.statements.IrStatement;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public class IrClass implements IrProgramElem {
	public String name;
	public CubexList<String> kindcontext;
	public CubexList<CubexTypeTuple> typecontext;
	public CubexTypeGrammar extendsType;
	public CubexList<IrStatement> statements;
	public CubexList<IrExpression> expressions;
	public CubexList<IrFunctionDef> functions;

	public IrClass(String n, CubexList<String> k,
			CubexList<CubexTypeTuple> typecont, CubexTypeGrammar t,
			CubexList<IrStatement> s, CubexList<IrExpression> e,
			CubexList<IrFunctionDef> f) {
		name = n;
		kindcontext = k;
		typecontext = typecont;
		extendsType = t;
		statements = s;
		expressions = e;
		functions = f;
	}

	public IrClass(String name, CubexList<String> kindContext,
			CubexList<CubexTypeTuple> typeContext, CubexTypeGrammar extendsType) {
		this.name = name;
		this.kindcontext = kindContext;
		this.typecontext = typeContext;
		this.extendsType = extendsType;
		this.statements = new CubexList<IrStatement>();
		this.expressions = new CubexList<IrExpression>();
		this.functions = new CubexList<IrFunctionDef>();
	}

	@Override
	public ArrayList<String> toC() {
		// TODO Auto-generated method stub
		return null;
	}

}
