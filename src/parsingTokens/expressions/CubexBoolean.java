package parsingTokens.expressions;

import java.util.Set;

import ir.expressions.IrBoolean;
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