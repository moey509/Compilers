package ir.statements;

import java.util.ArrayList;
import java.util.HashSet;

import optimization.LvaContext;
import typeChecker.CubexCompleteContext;
import ir.CGenerationContext;
import ir.expressions.IrAppend;
import ir.expressions.IrBinaryExpression;
import ir.expressions.IrCFunctionCall;
import ir.expressions.IrExpression;
import ir.expressions.IrExpressionTuple;
import ir.expressions.IrFunctionCall;
import ir.expressions.IrIterableComp;
import ir.expressions.IrVariableExpression;
import ir.program.IrTypeTuple;
import optimization.CseContext;

public final class IrBind extends IrStatement {

	public IrTypeTuple tuple;
	public IrExpression expression;
	public CubexCompleteContext context;
	public boolean cse = false;
	
	public IrBind(IrTypeTuple tuple, IrExpression expression, CubexCompleteContext context) {
		this.tuple = tuple;
		this.expression = expression;
		this.temporaryBinds = new ArrayList<IrBind>();
		this.context = context;
		
//		expression.getVars(this.useSet);
		this.defSet.add(tuple.variableName);
	}
	
	public String getVariableName(){
		return tuple.variableName;
	}
	
	public void addDeclaration(ArrayList<String> arr, CGenerationContext context){
		if(!(context.lva && isDead())){
			context.varDecl.put(tuple.variableName, "void*");
		}
//		if(!context.variablesDeclaredInScope.contains(tuple.variableName)){
//			arr.add("void* " + tuple.variableName + ";");
//			context.variablesDeclaredInScope.add(tuple.variableName);
//		}
	}
	
	public void addInitialization(ArrayList<String> arr, CGenerationContext context){
		if(!(context.lva && isDead())){
			context.varInit.put(tuple.variableName, "NULL");
		}
//		if(!context.variablesInitializedInScope.contains(tuple.variableName)){
//			arr.add(tuple.variableName + " = NULL;");
//			context.variablesInitializedInScope.add(tuple.variableName);
//		}
	}

	@Override
	public ArrayList<String> toC(CGenerationContext context, boolean isMain, ArrayList<String> extras) {
		//Hacky fix for Comprehensions
		if(tuple.variableName.equals("y")){
			System.out.println("BINDCONTEXT:" + context.varDecl);
		}
		ArrayList<String> output = new ArrayList<String>();
		if(expression instanceof IrIterableComp){
			IrIterableComp comp = (IrIterableComp)expression;
			context.varDecl.put(tuple.variableName, tuple.type.toC());
			if (comp.comprehension!=null) {
				output.add(comp.comprehension.toC(context));
			}
			output.add(tuple.variableName + " = " + comp.toC(context) + ";");
			return output;
		}
		else if(expression instanceof IrFunctionCall){
			IrFunctionCall fun = (IrFunctionCall)expression;
			for (IrExpressionTuple tuple : fun.arguments){
				if(tuple.expression instanceof IrIterableComp){
					IrIterableComp comp = (IrIterableComp)tuple.expression;
					output.add(comp.comprehension.toC(context));
				}
			}
		}

		//output.add(tuple.type.toC() + " " + tuple.variableName + " = " + expression.toC(context) + ";");
		for(IrBind b : temporaryBinds){
			// put variables at the top of main() here:
			if(!(context.lva && b.isDead())){
				if (isMain) {
					context.varDecl.put(b.tuple.variableName, tuple.type.toC());
					context.varInit.put(b.tuple.variableName, "NULL");
				}
				output.add(b.tuple.variableName + " = NULL;");
				output.addAll(b.toC(context, isMain, extras));
			}
		}
		if(!(context.lva && isDead())){
			context.varDecl.put(tuple.variableName, tuple.type.toC());
			context.varInit.put(tuple.variableName, "NULL");
		}

		// put everything in fcnVarDecl ->
		// the check for whether things already exist in temporaryBinds happens in IrFunction
		//		if (!isMain) {
		//			context.varDecl.put(tuple.variableName, tuple.type.toC());
		//		}
		if(context.lva && hasFreeBefore){
			if(hasFreeBefore){
				for(String s : freeBefore){
					//					System.out.println("FREE BEFORE: " + s);
					output.add("ref_decrement((General_t)" + s + ");");
					output.add(s + " = NULL;");
				}
			}
		}
		if(!(context.lva && isDead())){
			if(temporaryBinds.size() > 0){
				String s;
				if (cse){
					s = expression.toC(context);
				}
				else {
					s = temporaryBinds.get(temporaryBinds.size()-1).tuple.variableName;
				}
				//No live variable analysis. Decrements whatever was previously set to this variable
				output.add("ref_decrement((General_t)" + tuple.variableName + ");");
				output.add(tuple.variableName + " = " + s + ";");
				output.add("ref_increment((General_t)" + tuple.variableName + ");");
			}
			else{
				//Decrements whatever was previously bound to this variable
				output.add("ref_decrement((General_t)" + tuple.variableName + ");");
				//System.out.println("toC: " + tuple.toString() + " " + expression.toC(context));
				if (expression instanceof IrFunctionCall) {
					IrFunctionCall funcCall = (IrFunctionCall) expression;
					if(!funcCall.functionName.equals("_string") && !funcCall.functionName.equals("_character")){
						//Increments arguments before a function call
						for (IrExpressionTuple tuple : funcCall.getArugments()) {
							output.add("ref_increment((General_t)" + tuple.getExpression().toC(context)+ ");");
						}
					}
				}
				//Sets the variable then increments.
				if(expression instanceof IrAppend){
					output.add(((IrAppend)expression).toC(context, tuple.variableName));
				}
				else{
//					if (expression instanceof IrBinaryExpression)
//						System.out.println("toC: " + tuple.toString() + " " + expression.toC(context));
					output.add(tuple.variableName + " = " + expression.toC(context) + ";");
				}
				output.add("ref_increment((General_t)" + tuple.variableName + ");");
			}
		}

		if(context.lva){
			for(String s : inMinusOut()){
				output.add("ref_decrement((General_t)" + s + ");");
				output.add(s + " = NULL;");
			}
		}
		else{
			for(IrBind b : temporaryBinds){
				output.add("ref_decrement((General_t)" + b.tuple.variableName + ");");
				output.add(b.tuple.variableName + " = NULL;");
			}
		}
		return output;
	}
	
	
	
	public ArrayList<IrBind> getTemporaryVariables(){
		return this.temporaryBinds;
	}

	@Override
	public void lva(LvaContext c) {
		lvaHelper(c);

		if (c.debug) {
			// DEBUG STATEMENTS
			System.out.println(toString());
			System.out.println("  isDead: " + isDead());
			lvaDebugHelper();
		}
	}

	@Override
	public void populateSets(LvaContext c) {
		if (nextSet==null) {
			nextSet = new HashSet<IrStatement>();
			
			useSet = new HashSet<String>();
			getExpression().getVars(useSet, c.functionUse);
			
			populateSetsTemps(c);

			// now add to the nextList for this bind
			if (c.nextList.size()>0) {
				nextSet.add(c.nextList.removeFirst().getTop());
			}
		}
	}
	
	
	public boolean isDead() {
		IrExpression e = getExpression();
		boolean isCFunctionCall = e instanceof IrCFunctionCall;
		for (String s : defSet) {
			if (!outSet.contains(s) && !isCFunctionCall) {
				return true;
			}
		}
		return false;
	}

	public void removeCommonSubexpressions(CseContext context) {		
		for (IrBind tempBind : temporaryBinds){
			tempBind.expression = tempBind.expression.eliminateSubexpression(context);
			context.putVariable(tempBind.getVariableName(), tempBind.expression.getSubexpressions(context));
		}
		//System.out.println("------------");
		context.printContext();
		//System.out.println("Before CSE: " + getVariableName() + "=" + expression);
		IrExpression temp = expression.eliminateSubexpression(context);
		if (!temp.equals(expression)){
			System.out.println("Before CSE: " + getVariableName() + " := " + expression);
			cse = true;
			expression = temp;
			System.out.println("After CSE: " + getVariableName() + " := " + expression);
		}
		context.putVariable(getVariableName(), expression.getSubexpressions(context));
		//context.printContext();
	}

	@Override
	public String toString() {
		return "IrBind: " + tuple.type.toC() + " " + tuple.variableName + " := " + getExpression().toString();
	}

	public IrExpression getExpression() {
		int length = temporaryBinds.size();
		if (length>0 && !cse) {
			String varname = temporaryBinds.get(length-1).tuple.variableName;
			String ctype = temporaryBinds.get(length-1).tuple.type.toC();
			return new IrVariableExpression(varname, ctype);
		}
		return expression;
	}
}
