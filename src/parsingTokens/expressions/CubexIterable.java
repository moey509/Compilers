package parsingTokens.expressions;

import ir.IrType;
import ir.expressions.IrCFunctionCall;
import ir.expressions.IrExpression;
import ir.expressions.IrIterable;
import ir.program.IrTypeTuple;
import ir.statements.IrBind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;
import Exception.SemanticException;

public class CubexIterable extends CubexExpression {
	CubexList<CubexExpression> list;
	
	CubexTypeGrammar cubexType;
	CubexCompleteContext cubexContext;

	public CubexIterable(CubexList<CubexExpression> listIn) {
		list = listIn;
		type = "Iterable";
	}
	
	public ArrayList<IrBind> getExpressions(IrGenerationContext context){
		ArrayList<IrBind> arr = new ArrayList<IrBind>();
		ArrayList<IrBind> tempBinds = new ArrayList<IrBind>();
		ArrayList<IrBind> params = new ArrayList<IrBind>();
		String appendLeft = "";
		String appendRight = "NULL";
		for(int i = list.contextCollection.size()-1; i >=0; i--){
			CubexExpression e = list.contextCollection.get(i);
			params = e.getExpressions(context);
			arr.addAll(params);
			IrCFunctionCall fun;
			IrType t = new IrType("git_t");
			appendLeft = context.nextTemp();
			//Create a new git object
			IrTypeTuple tuple = new IrTypeTuple(t, appendLeft);
			if(params.size() == 0){
				ArrayList<String> cParameters = new ArrayList<String>();
				cParameters.add(e.name);
				ArrayList<String> cParameterTypes = new ArrayList<String>();
				cParameterTypes.add("void*");
				fun = new IrCFunctionCall("new_git_obj", cParameters, cParameterTypes);//new IrFunctionCall("new_git_obj", "git_t", null);
				fun.input.add(e.name);
				fun.input = cParameters;
			}
			//Throw in a temporary variable
			else{
				IrBind paramBind = params.get(params.size()-1);
				ArrayList<String> cParameters = new ArrayList<String>();
				cParameters.add(paramBind.tuple.variableName);
				ArrayList<String> cParameterTypes = new ArrayList<String>();
				cParameterTypes.add("void*");
				fun = new IrCFunctionCall("new_git_obj", cParameters, cParameterTypes);
				fun.input.add(paramBind.tuple.variableName);
				fun.input = cParameters;
			}
			IrBind bind = new IrBind(tuple, fun, cubexContext);
			tempBinds.add(bind);
			arr.add(bind);
			
			//Iterable Appends
			//Internal to cubexIterable
			String nextAppendRight = context.nextTemp();
			tuple = new IrTypeTuple(t, nextAppendRight);
			ArrayList<String> cParameters = new ArrayList<String>();
			cParameters.add(appendLeft);
			cParameters.add(appendRight);
			ArrayList<String> cParameterTypes = new ArrayList<String>();
			cParameterTypes.add("git_t");
			cParameterTypes.add("git_t");
			fun = new IrCFunctionCall("iterable_append", cParameters, cParameterTypes);
			if(!appendLeft.equals("NULL"))fun.input.add(appendLeft);
			if(!appendRight.equals("NULL"))fun.input.add(appendRight);
			bind = new IrBind(tuple, fun, cubexContext);
			tempBinds.add(bind);
			arr.add(bind);
			appendRight = nextAppendRight;
		}
		if(tempBinds.size() == 0){
			IrType t = new IrType("git_t");
			IrTypeTuple tuple = new IrTypeTuple(t, context.nextTemp());
			IrBind b = new IrBind(tuple, this.toIr(context), cubexContext);
			arr.add(b);
			return arr;
		}
//		else{
//			CubexList<IrExpression> irE = new CubexList<IrExpression>();
//			for (IrBind s : tempBinds) {
//				irE.add(new IrVariableExpression(s.tuple.variableName, s.tuple.type.type));
//			}
//			IrIterable iterable = new IrIterable(irE, cubexType);
//			IrType t = new IrType("git_t");
//			IrTypeTuple tuple = new IrTypeTuple(t, context.nextTemp());
//			IrBind b = new IrBind(tuple, iterable, cubexContext);
//			arr.add(b);			
//			return arr;
//		}
		return arr;
	}
	
	public IrIterable toIr(IrGenerationContext context) {
		CubexList<IrExpression> irE = new CubexList<IrExpression>();
		for (CubexExpression i : list.contextCollection) {
			irE.add(i.toIr(context));
		}
		return new IrIterable(irE, cubexType);
	}

	public String toString() {
		String rightSpace = list.size() == 0 ? "" : " ";
		return "[ " + list.toString(",") + rightSpace + "]";
	}

	// Check if the expression is of some type
	public CubexTypeGrammar typeCheck(CubexCompleteContext c)
			throws SemanticException {
		CubexTypeGrammar type;
		CubexTypeGrammar joinedType = new CubexTypeClass("Nothing", new CubexList<CubexTypeGrammar>());
		for (int i = 0; i < list.size(); i++) {
			type = list.get(i).typeCheck(c);
			joinedType = type.join(c, joinedType);
		}
		CubexList<CubexTypeGrammar> iterableType = new CubexList<CubexTypeGrammar>();
		iterableType.add(joinedType);
		cubexContext = c.clone();
		cubexType = new CubexTypeClass("Iterable", iterableType);
		return cubexType;
	}
	
	@Override
	public void getVars(Set<String> set){
		for (CubexExpression e : list.contextCollection) {
			e.getVars(set);
		}
	}
	
	@Override
	public void replaceVars(HashMap<String, String> map) {
		for (CubexExpression e : list.contextCollection)  {
			e.replaceVars(map);
		}
	}
	
	public boolean equals(CubexIterable expr){
		Iterator<CubexExpression> iter1 = list.iterable().iterator();
		Iterator<CubexExpression> iter2 = expr.list.iterable().iterator();
		
		while (iter1.hasNext() && iter2.hasNext()){
			CubexExpression expr1 = iter1.next();
			CubexExpression expr2 = iter2.next();
			if (!expr1.equals(expr2)){
				return false;
			}
		}
		if (iter1.hasNext() || iter2.hasNext()){
			return false;
		}
		return true;
	}
	
	public int hashCode(){
		return toString().hashCode();
	}
}
