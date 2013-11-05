package parsingTokens.expressions;

import java.util.Set;

import ir.expressions.IrInteger;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;
import Exception.SemanticException;

public final class CubexInteger extends CubexExpression {
	private int mValue;

	public CubexInteger(int value) {
		mValue = value;
	}
	
	public IrInteger toIr(IrGenerationContext context) {
		return new IrInteger(mValue);
	}

	public String toString() {
		return String.valueOf(mValue);
	}
	
	// Check if the expression is of some type
	public CubexTypeGrammar typeCheck(CubexCompleteContext c)
			throws SemanticException {
		return new CubexTypeClass("Integer", new CubexList<CubexTypeGrammar>());
	}
	
	@Override
	public void getVars(Set<String> set){
		return;
	}
}