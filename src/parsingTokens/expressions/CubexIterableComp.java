package parsingTokens.expressions;

import ir.expressions.IrIterable;
import ir.statements.IrBind;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import Exception.SemanticException;
import parsingTokens.comprehension.Comp;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;

public class CubexIterableComp extends CubexExpression {
	Comp comp; // may be null!
	
	public CubexIterableComp(Comp c) {
		this.comp = c;
	}
		
	public ArrayList<IrBind> getExpressions(IrGenerationContext context){
		return null;
	}
	
	public IrIterable toIr(IrGenerationContext context) {
		return null;
	}

	public String toString() {
		if (comp!=null) {
			return "[ " + comp.toString() + " ]";
		}
		return "[ ]";
	}

	// Check if the expression is of some type
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		return null;
	}
	
	@Override
	public void getVars(Set<String> set){
	}
	
	@Override
	public void replaceVars(HashMap<String, String> map) {
	}
	
	public boolean equals(CubexIterable expr){
		return false;
	}
	
	public int hashCode(){
		return 0;
	}

}
