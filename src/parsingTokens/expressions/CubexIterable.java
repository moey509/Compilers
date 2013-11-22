package parsingTokens.expressions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import ir.IrType;
import ir.expressions.IrExpression;
import ir.expressions.IrFunctionCall;
import ir.expressions.IrIterable;
import ir.expressions.IrVariableExpression;
import ir.program.IrTypeTuple;
import ir.statements.IrBind;
import ir.statements.IrStatement;
import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;

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
		for(CubexExpression e : list.contextCollection){
			params = e.getExpressions(context);
			arr.addAll(params);
			if(params.size() == 0){
				IrType t = new IrType("git_t");
				IrTypeTuple tuple = new IrTypeTuple(t, context.nextTemp());
				IrVariableExpression fun = new IrVariableExpression("new_git_obj(" + e.name + ")","");//new IrFunctionCall("new_git_obj", "git_t", null);
				//fun.addArgument(e.type, new IrVariableExpression(e.name, e.type));
				IrBind bind = new IrBind(tuple, fun, cubexContext);
				tempBinds.add(bind);
				arr.add(bind);
			}
			//Throw in a temporary variable
			else{
				IrBind paramBind = params.get(params.size()-1);
				
				IrType t = new IrType("git_t");
				IrTypeTuple tuple = new IrTypeTuple(t, context.nextTemp());
				//IrFunctionCall fun = new IrFunctionCall("new_git_obj", "git_t", null);
				IrVariableExpression fun = new IrVariableExpression("new_git_obj(" + paramBind.tuple.variableName + ")","");
				//fun.addArgument(e.type, new IrVariableExpression(paramBind.tuple.variableName, paramBind.tuple.type.type));
				IrBind bind = new IrBind(tuple, fun, cubexContext);
				
				tempBinds.add(bind);
				arr.add(bind);
			}
		}
		if(tempBinds.size() == 0){
			IrType t = new IrType("git_t");
			IrTypeTuple tuple = new IrTypeTuple(t, context.nextTemp());
			IrBind b = new IrBind(tuple, this.toIr(context), cubexContext);
			arr.add(b);
			return arr;
		}
		else{
			CubexList<IrExpression> irE = new CubexList<IrExpression>();
			for (IrBind s : tempBinds) {
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
