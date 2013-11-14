package parsingTokens.expressions;

import java.util.ArrayList;
import java.util.Set;

import ir.IrType;
import ir.expressions.IrInteger;
import ir.program.IrTypeTuple;
import ir.statements.IrBind;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;
import Exception.SemanticException;

public final class CubexInteger extends CubexExpression {
	private int mValue;
	
	CubexCompleteContext cubexContext;

	public CubexInteger(int value) {
		mValue = value;
		type = "Integer";
	}
	
	public IrInteger toIr(IrGenerationContext context) {
		return new IrInteger(mValue);
	}
	public ArrayList<IrBind> getExpressions(IrGenerationContext context){
		ArrayList<IrBind> arr = new ArrayList<IrBind>();
		IrType t = new IrType("void*");
		IrTypeTuple tuple = new IrTypeTuple(t, context.nextTemp());
		arr.add(new IrBind(tuple, this.toIr(context), cubexContext));
		return arr;
	}

	public String toString() {
		return String.valueOf(mValue);
	}
	
	// Check if the expression is of some type
	public CubexTypeGrammar typeCheck(CubexCompleteContext c)
			throws SemanticException {
		cubexContext = c.clone();
		return new CubexTypeClass("Integer", new CubexList<CubexTypeGrammar>());
	}
	
	@Override
	public void getVars(Set<String> set){
		return;
	}
}