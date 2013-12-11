package parsingTokens.expressions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import ir.IrType;
import ir.expressions.IrCFunctionCall;
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
		System.out.println(mValue);
		for(int i = mValue.length()-2; i > 0; i--){
			char c = mValue.charAt(i);
			System.out.println(c);
			IrType t = new IrType("git_t");
			appendLeft = context.nextTemp();
			IrTypeTuple tuple = new IrTypeTuple(t, appendLeft);
			ArrayList<String> cParameters = new ArrayList<String>();
			if(c == '\''){
				cParameters.add("'" + '\\' + '\'' + "'");
			}
			else if(c == '\"'){
				cParameters.add("'" + '\\' + '\'' + "'");
			}
			else if(c == '\\'){
				cParameters.add("'" + '\\' + '\\' + "'");
			}
			else{
				cParameters.add("'" + c + "'");
			}
			ArrayList<String> cParameterTypes = new ArrayList<String>();
			cParameterTypes.add("char");
			IrCFunctionCall fun;
			fun = new IrCFunctionCall("new_git_obj_charuni" + "", cParameters, cParameterTypes,"");
			IrBind bind = new IrBind(tuple, fun, cubexContext);
			arr.add(bind);
			
			//Iterable Appends
			String nextAppendRight = context.nextTemp();
			tuple = new IrTypeTuple(t, nextAppendRight);
			cParameters = new ArrayList<String>();
			cParameters.add(appendLeft);
			cParameters.add(appendRight);
			cParameterTypes = new ArrayList<String>();
			cParameterTypes.add("git_t");
			cParameterTypes.add("git_t");
			fun = new IrCFunctionCall("iterable_append", cParameters, cParameterTypes,"");
			if(!appendLeft.equals("NULL"))fun.input.add(appendLeft);
			if(!appendRight.equals("NULL"))fun.input.add(appendRight);
			bind = new IrBind(tuple, fun, cubexContext);
			arr.add(bind);
			appendRight = nextAppendRight;
		}
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