package parsingTokens.expressions;

import ir.IrGenerationContext;
import ir.expressions.IrExpression;
import ir.expressions.IrVariableExpression;
import Exception.SemanticException;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;

public class CubexExpression {
	String name;	

	public CubexExpression() {
	}

	public CubexExpression(String vp) {
		name = vp;
	}

	public String toString() {
		return name;
	}

	// // Check if the expression is of some type
	// public CubexTypeGrammar typeCheck(CubexCompleteContext c,
	// CubexTypeGrammar t) throws SemanticException {
	// throw new SemanticException("");
	// }
	//
	// public CubexTypeGrammar typeCheck(CubexCompleteContext c,
	// CubexTypeClass t) throws SemanticException {
	// throw new SemanticException("");
	// }
	//
	// // Check if the expression is of some list of types
	// public CubexTypeGrammar typeCheck(CubexCompleteContext c,
	// CubexList<CubexTypeGrammar> t) throws SemanticException {
	// throw new SemanticException("");
	// }

	public CubexTypeGrammar typeCheck(CubexCompleteContext c)
			throws SemanticException {
		if (c.containsTypeVariableInMutableTypeContext(name)) {
			return c.getTypeGrammarFromMutableTypeContext(name);
		} else if (c.containsTypeVariableInTypeContext(name)) {
			return c.getTypeGrammarFromTypeContext(name);
		} else {
			throw new SemanticException("Variable " + name + " does not exist");
		}
	}
	
	public IrExpression toIr(IrGenerationContext context) {
		System.out.println("here");
		return new IrVariableExpression(name);
	}
}