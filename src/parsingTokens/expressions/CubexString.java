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
		if(mValue.length() <= 2){
			IrType t = new IrType("void*");
			IrTypeTuple tuple = new IrTypeTuple(t, context.nextTemp());
			//System.out.println(tuple.variableName);
			//System.out.println(this.toIr(context).toC(null));
			arr.add(new IrBind(tuple, this.toIr(context), cubexContext));
			return arr;
		}
		String appendLeft = "";
		String appendRight = "NULL";
		for(int i = mValue.length()-2; i > 0; i--){
			char c = mValue.charAt(i);
			IrType t = new IrType("git_t");
			appendLeft = context.nextTemp();
			IrTypeTuple tuple = new IrTypeTuple(t, appendLeft);
			IrVariableExpression fun = new IrVariableExpression("new_git_obj(new_character(charuni('" + c + "')))","");
			IrBind bind = new IrBind(tuple, fun, cubexContext);
			arr.add(bind);
			
			//Iterable Appends
			String nextAppendRight = context.nextTemp();
			tuple = new IrTypeTuple(t, nextAppendRight);
			System.out.println("iterable_append(" + appendLeft + ", " + appendRight + ")");
			fun = new IrVariableExpression("iterable_append(" + appendLeft + ", " + appendRight + ")","");//new IrFunctionCall("new_git_obj", "git_t", null);
			bind = new IrBind(tuple, fun, cubexContext);
			arr.add(bind);
			appendRight = nextAppendRight;
		}
//		CubexList<IrExpression> irE = new CubexList<IrExpression>();
//		for (IrBind s : arr) {
//			//TODO something
//			irE.add(new IrVariableExpression(s.tuple.variableName, s.tuple.type.type));
//		}
//		IrIterable iterable = new IrIterable(irE, cubexType);
//		IrType t = new IrType("git_t");
//		IrTypeTuple tuple = new IrTypeTuple(t, context.nextTemp());
//		IrBind b = new IrBind(tuple, iterable, cubexContext);
//		arr.add(b);
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