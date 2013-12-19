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
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;
import typeChecker.TypeContext;

public final class CubexFunctionCall extends CubexExpression {
	private String v_vc; //function name
	private CubexList<CubexTypeGrammar> typeParams; // the stuff in angle brackets
	private CubexList<CubexExpression> functionParams; 
	
	CubexTypeGrammar cubexType;
	CubexCompleteContext cubexContext;

	public CubexFunctionCall(String v_vc, CubexList<CubexTypeGrammar> typeParams, CubexList<CubexExpression> functionParams) {
		this.v_vc = v_vc;
		this.type = v_vc;
		this.typeParams = typeParams;
		this.functionParams = functionParams;
	}

	public IrFunctionCall toIr(IrGenerationContext context) {
		IrFunctionCall irFunCall;
		if (context.containsGlobalFunction("_" + v_vc)){
			String obj = "";

			if (v_vc != null){
				obj = v_vc.replaceAll("_", "__");
			}

			irFunCall = new IrFunctionCall("_" + obj, cubexType);
		}
		else{
			String obj = "";
			String fun = "";
					
			if (context.getCurrentClassDeclaration() != null){
				obj = "_" + context.getCurrentClassDeclaration().replaceAll("_", "__");
			}
			if (v_vc != null){
				fun = v_vc.replaceAll("_", "__");
			}
			
			irFunCall = new IrFunctionCall(obj + "_" + fun, cubexType);
		}

		for (CubexExpression i : functionParams.contextCollection) {
			irFunCall.addArgument(i.type, i.toIr(context));
			//System.out.println("CUBEX: " + i.type + " " + i.toString());
		}
		context.printGlobalFunctions();
		return irFunCall;
	}

	public String toString() {
		String rightSpace1 = typeParams.size() == 0 ? "" : " ";
		String rightSpace2 = functionParams.size() == 0 ? "" : " ";
		return v_vc + " < " + typeParams.toString(",") + rightSpace1 + "> ( " + functionParams.toString(",") + rightSpace2 + ")";
	}

	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		CubexTypeScheme typeScheme;
		if (c.containsFunctionName(v_vc)) {
			typeScheme = c.getTypeSchemeFromFunctionContext(v_vc);
		} 
		else {
			throw new SemanticException(v_vc + " is not contained in function context");
		}

		// Get the Function Kind Context
		ArrayList<String> kContext = new ArrayList<String>(typeScheme.getKindContext().contextCollection);

		// Get the Function Types
		ArrayList<CubexTypeGrammar> params = new ArrayList<CubexTypeGrammar>(typeParams.contextCollection);

		// Check to see if number of Function type params matches the number of
		// types given to the function
		if (kContext.size() != params.size()) {
			throw new SemanticException("Incorrect number of parameters");
		}

		TypeContext cont = new TypeContext();
		for (int i = 0; i < kContext.size(); i++) {
			cont.put(kContext.get(i), params.get(i));
			if (!c.containsClassName(params.get(i).getName()) && !c.kindContextContainsTypeParam(params.get(i).getName())) {
				throw new SemanticException(params.get(i).getName()	+ " is not a valid type.");
			}
		}

		CubexList<CubexTypeTuple> typeContext = typeScheme.getTypeContext();

		for (int i = 0; i < typeContext.size(); i++) {
			CubexTypeGrammar paramExpr = functionParams.get(i).typeCheck(c);
			// Replace generic types and check for supertype
			if (!typeContext.get(i).getTypeGrammar().replaceParams(cont).isSuperTypeOf(c, paramExpr)) {
				throw new SemanticException("Expected argument of type " + typeContext.get(i).getTypeGrammar() + " but received " + paramExpr);
			}
		}
		CubexTypeGrammar output = typeScheme.getTypeGrammar().replaceParams(cont);
		type = output.name;
		cubexType = output;
		return output;
	}
	
	@Override
	public void getVars(Set<String> set){
//		for (CubexExpression e : functionParams.contextCollection) {
//			e.getVars(set);
//		}
	}
	
	@Override
	public void replaceVars(HashMap<String, String> map) {
		for (CubexExpression e : functionParams.contextCollection) {
			e.replaceVars(map);
		}
	}
	
	public ArrayList<IrBind> getExpressions(IrGenerationContext context){
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
				tempParams.add(new IrBind(tuple, new IrVariableExpression(tuple.variableName, e.cubexType), cubexContext));
			}
			//Throw in a temporary variable
			else{
				tempParams.add(arr.get(arr.size()-1));
			}
		}
		IrType t = new IrType("void*");
		IrTypeTuple tuple = new IrTypeTuple(t, context.nextTemp());
		IrFunctionCall call;
		String obj = "";
		if (v_vc != null){
			obj = v_vc.replaceAll("_", "__");
		}
		
		IrBind b;
		//No function parameters, then the call is just the original call
		if(tempParams.size() == 0){
			call = this.toIr(context);
			b = new IrBind(tuple, call, cubexContext);
		}
		//Function parameters. Then the call is a new IrFunction with parameters added
		else{
			call = new IrFunctionCall("_" + obj, cubexType);
			for(IrBind bind : tempParams){
				call.addArgument("void*", new IrVariableExpression(bind.tuple.variableName));
			}
			b = new IrBind(tuple, call, cubexContext);
		} 
		arr.add(b);
		return arr;
	}
	
	public boolean equals(CubexFunctionCall expression){
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