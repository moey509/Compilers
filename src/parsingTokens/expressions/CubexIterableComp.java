package parsingTokens.expressions;

import ir.expressions.IrIterable;
import ir.statements.IrBind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.comprehension.Comp;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import parsingTokens.typeGrammar.CubexTypeName;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;

public class CubexIterableComp extends CubexExpression {
	Comp comp; // may be null!
	
	CubexTypeGrammar cubexType;
	CubexCompleteContext cubexContext;
	
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
		CubexTypeGrammar type;
		if (comp == null){
			type = new CubexTypeName("Nothing");
		} 
		else {
			cubexContext = c.clone();
			type = comp.typeCheck(cubexContext);
		}
		
		CubexList<CubexTypeGrammar> iterableType = new CubexList<CubexTypeGrammar>();
		iterableType.add(type);
		cubexContext = c.clone();
		cubexType = new CubexTypeClass("Iterable", iterableType);
		return cubexType;
	}
	
	@Override
	public void getVars(Set<String> set){
		if (comp!=null) {
			comp.getVars(set);
		}
	}
	
	@Override
	public void replaceVars(HashMap<String, String> map) {
		if (comp!=null) {
			comp.replaceVars(map);
		}
	}
	
	public boolean equals(CubexIterable expr){
		return false;
	}
	
	public int hashCode(){
		return 0;
	}

}
