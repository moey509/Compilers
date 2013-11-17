package parsingTokens.expressions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import ir.IrType;
import ir.expressions.IrString;
import ir.program.IrTypeTuple;
import ir.statements.IrBind;
import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;

public final class CubexString extends CubexExpression {
	private String mValue;

	CubexTypeGrammar cubexType;
	CubexCompleteContext cubexContext;
	
	public CubexString(String value) {
		mValue = value;
		type = "String";
	}
	
	public IrString toIr(IrGenerationContext context) {
		return new IrString(mValue);
	}

	public String toString() {
		return mValue;
	}
	
	public ArrayList<IrBind> getExpressions(IrGenerationContext context){
		//System.out.println("In CubexString: " + this);
		ArrayList<IrBind> arr = new ArrayList<IrBind>();
		IrType t = new IrType("void*");
		IrTypeTuple tuple = new IrTypeTuple(t, context.nextTemp());
		//System.out.println(tuple.variableName);
		//System.out.println(this.toIr(context).toC(null));
		arr.add(new IrBind(tuple, this.toIr(context), cubexContext));
		return arr;
	}

	// Check if the expression is of some type
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		cubexType = new CubexTypeClass("String", new CubexList<CubexTypeGrammar>());
		cubexContext = c.clone();
		return cubexType;
	}
	
	@Override
	public void getVars(Set<String> set) {
		return;
	}
			
	@Override 
	public void replaceVars(HashMap<String, String> map) {
		return;
	}
}