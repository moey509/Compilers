package parsingTokens.expressions;

import java.util.ArrayList;
import java.util.Set;

import ir.IrType;
import ir.expressions.IrBoolean;
import ir.program.IrTypeTuple;
import ir.statements.IrBind;
import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;

public final class CubexBoolean extends CubexExpression {
	private boolean mValue;

	public CubexBoolean(boolean value) {
		mValue = value;
		type = "Boolean";
	}

	public IrBoolean toIr(IrGenerationContext context) {
		return new IrBoolean(mValue);
	}
	
	public ArrayList<IrBind> getExpressions(IrGenerationContext context){
		ArrayList<IrBind> arr = new ArrayList<IrBind>();
		IrType t = new IrType("void*");
		IrTypeTuple tuple = new IrTypeTuple(t, context.nextTemp());
		arr.add(new IrBind(tuple, this.toIr(context)));
		return arr;
	}

	public String toString() {
		return mValue ? "true" : "false";
	}

	// Check if the expression is of some type
	public CubexTypeGrammar typeCheck(CubexCompleteContext c)
			throws SemanticException {
		return new CubexTypeClass("Boolean", new CubexList<CubexTypeGrammar>());
	}
	
	@Override
	public void getVars(Set<String> set){
		return;
	}
}