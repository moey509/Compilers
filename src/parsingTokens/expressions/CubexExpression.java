package parsingTokens.expressions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import ir.CGenerationContext;
import ir.expressions.IrExpression;
import ir.expressions.IrVariableExpression;
import ir.statements.IrBind;
import Exception.SemanticException;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;

public class CubexExpression {
	public String name;
	public String type;
	CubexTypeGrammar cubexType;
	CubexCompleteContext cubexContext;

	public CubexExpression() {
	}
	
	public ArrayList<IrBind> getExpressions(IrGenerationContext context){
		return new ArrayList<IrBind>();
	}

	public CubexExpression(String vp) {
		name = vp;
	}

	public String toString() {
		return name;
	}
	
	public void getVars(Set<String> set) {
		set.add(name);
	}
	
	public void replaceVars(HashMap<String, String> map) {
		if (map.containsKey(name)) {
			name = map.get(name);
		}
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
			cubexType = c.getTypeGrammarFromMutableTypeContext(name);
			type = cubexType.name;
			return cubexType;
		} else if (c.containsTypeVariableInTypeContext(name)) {
			cubexType = c.getTypeGrammarFromTypeContext(name);
			type = cubexType.name;
			return cubexType;
		} else {
			throw new SemanticException("Variable " + name + " does not exist");
		}
	}

	public IrExpression toIr(IrGenerationContext context) {
		if (context.containsGlobalVariable(name)){
			return new IrVariableExpression("_" + name, cubexType);
		}
		else return new IrVariableExpression(name, cubexType);

	}
	
	public boolean equals(CubexExpression expr){
		return name.equals(expr.name);
	}
	
	public int hashCode(){
		return toString().hashCode();
	}
}