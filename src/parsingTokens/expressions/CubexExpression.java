package parsingTokens.expressions;

import ir.expressions.IrExpression;
import ir.expressions.IrVariableExpression;
import Exception.SemanticException;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;

public class CubexExpression {
	String name;
	String type;

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
			type = c.getTypeGrammarFromMutableTypeContext(name).name;
			return c.getTypeGrammarFromMutableTypeContext(name);
		} else if (c.containsTypeVariableInTypeContext(name)) {
			type = c.getTypeGrammarFromTypeContext(name).name;
			return c.getTypeGrammarFromTypeContext(name);
		} else {
			throw new SemanticException("Variable " + name + " does not exist");
		}
	}

	public IrExpression toIr(IrGenerationContext context) {
		//TODO: HOW DO WE FIND THE TYPE OF THIS EXPRESSION???
		//System.out.println("PROBLEM WITH CREATING IRVARIABLEEXPRESSION!");
		//System.out.println("--> not sure how to find the type of variable");
		if (context.containsGlobalVariable(name)){
			return new IrVariableExpression("_" + name, type);
		}
		else return new IrVariableExpression(name, type);

	}
}