package parsingTokens.expressions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import ir.IrType;
import ir.expressions.IrExpression;
import ir.expressions.IrIterable;
import ir.expressions.IrString;
import ir.expressions.IrVariableExpression;
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
		if(mValue.length() == 0){
			IrType t = new IrType("void*");
			IrTypeTuple tuple = new IrTypeTuple(t, context.nextTemp());
			//System.out.println(tuple.variableName);
			//System.out.println(this.toIr(context).toC(null));
			arr.add(new IrBind(tuple, this.toIr(context), cubexContext));
			return arr;
		}
		for(int i = 1; i < mValue.length()-1; i++){
			char c = mValue.charAt(i);
			IrType t = new IrType("git_t");
			IrTypeTuple tuple = new IrTypeTuple(t, context.nextTemp());
			//IrFunctionCall fun = new IrFunctionCall("new_git_obj", "git_t", null);
			IrVariableExpression fun = new IrVariableExpression("new_git_obj(new_character(charuni('" + c + "')))","");
			//fun.addArgument(e.type, new IrVariableExpression(paramBind.tuple.variableName, paramBind.tuple.type.type));
			IrBind bind = new IrBind(tuple, fun, cubexContext);
			arr.add(bind);
		}
		CubexList<IrExpression> irE = new CubexList<IrExpression>();
		for (IrBind s : arr) {
			//TODO something
			irE.add(new IrVariableExpression(s.tuple.variableName, s.tuple.type.type));
		}
		IrIterable iterable = new IrIterable(irE, cubexType);
		IrType t = new IrType("git_t");
		IrTypeTuple tuple = new IrTypeTuple(t, context.nextTemp());
		IrBind b = new IrBind(tuple, iterable, cubexContext);
		arr.add(b);
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
	public boolean equals(CubexString expr){
		return mValue.equals(expr.mValue);
	}
	
	public int hashCode(){
		return toString().hashCode();
	}
}