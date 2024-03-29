package parsingTokens.expressions;

import ir.IrType;
import ir.expressions.IrFunctionCall;
import ir.expressions.IrVariableExpression;
import ir.program.IrTypeTuple;
import ir.statements.IrBind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.context.CubexTypeScheme;
import parsingTokens.context.CubexTypeTuple;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import parsingTokens.typeGrammar.CubexTypeName;
import typeChecker.ClassContextElement;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;
import typeChecker.KindContext;
import typeChecker.TypeContext;

public final class CubexFunctionApp extends CubexExpression {
	private CubexExpression expr;
	private String v_v;
	private CubexList<CubexTypeGrammar> typeParams;
	private CubexList<CubexExpression> functionParams;
	
	CubexTypeGrammar cubexType;
	CubexCompleteContext cubexContext;

	public CubexFunctionApp(CubexExpression expr, String v_v, CubexList<CubexTypeGrammar> typeParams, CubexList<CubexExpression> functionParams) {
		this.expr = expr;
		this.v_v = v_v;
		this.typeParams = typeParams;
		this.functionParams = functionParams;
	}

	public String toString() {
		String rightSpace1 = typeParams.size() == 0 ? "" : " ";
		String rightSpace2 = functionParams.size() == 0 ? "" : " ";
		return expr.toString() + " . " + v_v + " < " + typeParams.toString(",")
				+ rightSpace1 + "> ( " + functionParams.toString(",")
				+ rightSpace2 + ")";
	}
	
	public IrFunctionCall toIr(IrGenerationContext context) {
		String obj = "";
		String fun = "";
		if (expr.type != null){
			obj = expr.type.replaceAll("_", "__");
		}
		if (v_v != null){
			fun = v_v.replaceAll("_", "__");
		}
		
		IrFunctionCall irFunCall = new IrFunctionCall("_" + obj + "_" + fun, cubexType);
		irFunCall.addArgument(expr.type, expr.toIr(context));
		for (CubexExpression i : functionParams.contextCollection) {
			irFunCall.addArgument(i.type, i.toIr(context));
		} 
		return irFunCall;
	}
	public ArrayList<IrBind> getExpressions(IrGenerationContext context){
		String obj = "";
		String fun = "";
		if (expr.type != null){
			obj = expr.type.replaceAll("_", "__");
		}
		if (v_v != null){
			fun = v_v.replaceAll("_", "__");
		}
		ArrayList<IrBind> arr = new ArrayList<IrBind>();
		ArrayList<IrBind> tempParams = new ArrayList<IrBind>();
		for(CubexExpression e : functionParams.contextCollection){
			ArrayList<IrBind> functionParamBinds = new ArrayList<IrBind>();
			functionParamBinds = e.getExpressions(context);
			arr.addAll(functionParamBinds);
			if(functionParamBinds.size() == 0){
				IrType t = new IrType("void*");
				IrTypeTuple tuple;
				if (context.containsGlobalVariable(e.toString())){
					tuple = new IrTypeTuple(t, "_" + e.toString());
				}
				else {
					tuple = new IrTypeTuple(t, e.toString());
				}
				tempParams.add(new IrBind(tuple, new IrVariableExpression(tuple.variableName), cubexContext));
			}
			//Throw in a temporary variable
			else{
				tempParams.add(arr.get(arr.size()-1));
			}
		}
		ArrayList<IrBind> thisPointer = expr.getExpressions(context);
		arr.addAll(thisPointer);
		IrType t = new IrType("void*");
		IrTypeTuple tuple = new IrTypeTuple(t, context.nextTemp());
		IrBind b;
		
		String instance;
		if (thisPointer.size() == 0){
			instance = expr.name;
		}
		else {
			instance = thisPointer.get(thisPointer.size() - 1).tuple.variableName;
		}
		
		String functionName =  "\"" +"_" + obj + "_" + fun + "\"";
		String functionCall = "(function_lookup(" + instance + ", " + functionName +"))";
//		System.out.println(functionCall);
		IrFunctionCall call = new IrFunctionCall(functionCall, cubexType);
		//Have to add in all arguments. Must figure out how much each has		
		for(IrBind bind : tempParams){
			//TODO: NULL
			call.addArgument(bind.tuple.type, new IrVariableExpression(bind.tuple.variableName, null));
		}
		if(thisPointer.size() != 0){
			call.addArgument("void*", new IrVariableExpression(thisPointer.get(thisPointer.size()-1).tuple.variableName));
		}
		else{
			call.addArgument(expr.type, expr.toIr(context));
		}
		b = new IrBind(tuple, call, cubexContext);
		
		arr.add(b);
		return arr;
	}

	// Check if the expression is of some type
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexTypeGrammar objectType = expr.typeCheck(c);
		ClassContextElement element = c.classContext.get(objectType.getName());
		if(objectType.getName().equals("Nothing")){
			return objectType;
		}
		if(objectType.getName().equals("Thing")) throw new SemanticException("Method does not exist");
		CubexTypeScheme typeScheme = element.functionMap.get(v_v);

		// build the replaceParams context
		TypeContext cont = new TypeContext();
		TypeContext cont2 = new TypeContext();
		TypeContext cont3 = new TypeContext();
		KindContext kcont = c.classContext.get(objectType.getName()).kindContext;
		CubexList<CubexTypeGrammar> types = objectType.getTypeList();
		for (int i = 0; i < kcont.size(); i++){
			cont.put(kcont.contextSet.get(i), types.get(i));
			cont2.put(kcont.contextSet.get(i), types.get(i));
		}

		while(typeScheme == null){
			for (int i=0 ; i<element.type.getTypeList().size(); i++) {
				CubexTypeGrammar exttype = element.type.getTypeList().get(i);
				if (exttype instanceof CubexTypeName) {
					cont3.put(c.classContext.get(element.type.getName()).kindContext.contextSet.get(i), cont2.get(exttype.getName()));
				}
			}
			cont2 = cont3;
			cont3 = new TypeContext();
			element = c.classContext.get(element.type.getName());
			if (element.functionMap.get(v_v) != null)
				typeScheme = element.functionMap.get(v_v).replaceParams(cont2);
			else
				typeScheme = element.functionMap.get(v_v);
			if(element.name.equals("Thing")) throw new SemanticException("Method does not exist");
		}
		ArrayList<String> kContext = new ArrayList<String>(typeScheme.getKindContext().contextCollection);
		ArrayList<CubexTypeGrammar> params = new ArrayList<CubexTypeGrammar>(typeParams.contextCollection);

		if (kContext.size() != params.size()) {
			throw new SemanticException("Incorrect number of parameters");
		}
		
		for (int i = 0; i < kContext.size(); i++) {
			cont.put(kContext.get(i), params.get(i));
			if (!c.containsClassName(params.get(i).getName()) && !c.kindContextContainsTypeParam(params.get(i).getName())){
				throw new SemanticException(params.get(i).getName() + " is not a valid type.");
			}
		}
		CubexList<CubexTypeTuple> typeContext = typeScheme.getTypeContext();

		for (int i = 0; i < typeContext.size(); i++) {
			CubexTypeGrammar paramExpr = functionParams.get(i).typeCheck(c);
			if (!typeContext.get(i).getTypeGrammar().replaceParams(cont).isSuperTypeOf(c, paramExpr)){
				throw new SemanticException("Expected argument of type " + typeContext.get(i).getTypeGrammar() + " but received " + paramExpr);
			}
		}
		CubexTypeGrammar output = typeScheme.getTypeGrammar().replaceParams(cont);
		type = output.name;
		cubexType = output;
		cubexContext = c.clone();
		return output;
	}
	
	@Override
	public void getVars(Set<String> set){
		expr.getVars(set);
		for (CubexExpression e : functionParams.contextCollection) {
			e.getVars(set);
		}
	}
	
	@Override
	public void replaceVars(HashMap<String, String> map){
		expr.replaceVars(map);
		for (CubexExpression e : functionParams.contextCollection) {
			e.replaceVars(map);
		}
	}
	
	public boolean equals(CubexFunctionApp expression){
		if (!expression.expr.equals(expr)){
			return false;
		}
		if (!name.equals(expression.name)){
			return false;
		}
		Iterator<CubexTypeGrammar> paramIter1 = typeParams.iterable().iterator();
		Iterator<CubexTypeGrammar> paramIter2 = expression.typeParams.iterable().iterator();
		while (paramIter1.hasNext() && paramIter2.hasNext()){
			CubexTypeGrammar t1 = paramIter1.next();
			CubexTypeGrammar t2 = paramIter2.next();
			if (t1.name != t2.name){
				return false;
			}
		}
		if (paramIter1.hasNext() || paramIter2.hasNext()){
			return false;
		}
		Iterator<CubexExpression> exprIter1 = functionParams.iterable().iterator();
		Iterator<CubexExpression> exprIter2 = expression.functionParams.iterable().iterator();
		while (exprIter1.hasNext() && exprIter2.hasNext()){
			CubexExpression e1 = exprIter1.next();
			CubexExpression e2 = exprIter2.next();
			if (!e1.equals(e2)){
				return false;
			}
		}
		if (exprIter1.hasNext() || exprIter2.hasNext()){
			return false;
		}
		
		return true;
	}
	
	public int hashCode(){
		return toString().hashCode();
	}
}
