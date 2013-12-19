package ir.statements;

import ir.CGenerationContext;
import ir.expressions.IrExpression;
import ir.expressions.IrIterableComp;
import ir.expressions.IrVariableExpression;

import java.util.ArrayList;
import java.util.HashSet;

import optimization.LvaContext;
import optimization.CseContext;
import typeChecker.CubexCompleteContext;

public final class IrReturn extends IrStatement {
	// the Cubex variables to be freed before returning
	private ArrayList<String> freeContext = new ArrayList<String>();
	private IrExpression expression;
	public CubexCompleteContext context;
	boolean cse;

	public IrReturn(IrExpression expression, CubexCompleteContext context) {
		this.expression = expression;
		this.context = context;
		
	}
	
	public void setFreeContext(ArrayList<String> fc) {
		freeContext = fc;
	}
	
	public void addDeclaration(ArrayList<String> arr, CGenerationContext context){
	}
	public void addInitialization(ArrayList<String> arr, CGenerationContext context){
	}
	
	public ArrayList<String> toProgramOutput(CGenerationContext context) {
		ArrayList<String> output = new ArrayList<String>();
		
		return output;
	}

	@Override
	public ArrayList<String> toC(CGenerationContext context, boolean isMain, ArrayList<String> extras) {
		ArrayList<String> arrList = new ArrayList<String>();
		
		String iterator = "";

		String itDeclaration = "";
		String itIncrement = "";
		String itCondition = "";
		String tempVar = "";
		String printline = "";
		String endBrace = "";
		String itDecrement = "";
		String itNull = "";
		
		String stringVarDeclaration = "";
		String stringVarPopulation = "";
		String stringVarFree = "";
		ArrayList<String> beforeIterator = new ArrayList<String>();
		if (isMain) {
			int cur_iterator = context.getCurIterator();
			context.incrementCurIterator();
			iterator = "_it" + cur_iterator;
			context.varDecl.put(iterator, "iterator_t"); 
			
			//System.out.println("Expression: " + expression);
			if(expression instanceof IrIterableComp){
				IrIterableComp comp = (IrIterableComp)expression;
				if (comp.comprehension!=null) {
					beforeIterator.add(comp.comprehension.toC(context));
				}
				itDeclaration = iterator + " = new_iterator((" + comp.toC(context) + "));";
			}
			else{
				itDeclaration = iterator + " = new_iterator((" + expression.toC(context) + "));";
			}
			itIncrement = "ref_increment((General_t)" + iterator + ");";
			itCondition = "while(hasNext(" + iterator + ")) {";
			stringVarDeclaration = "char* _return_string;";
			tempVar = "_return = getNext(" + iterator + ");";
			stringVarPopulation = "_return_string = charToString(_return);";			
			// newly moved line
			printline = ("print_line(_return_string, stringLength(_return));");
			stringVarFree = "x3free(_return_string);";
			endBrace = ("}");
			// free the iterator
			itDecrement = ("ref_decrement((General_t)" + iterator + ");");
			itNull = (iterator + " = NULL;");
		}
		if (cse){
			String s = expression.toC(context);
//			System.out.println("RETURN: " +s);
		}
		else {
			if(temporaryBinds.size()>0){
			String s = temporaryBinds.get(temporaryBinds.size()-1).tuple.variableName;
//			System.out.println("RETURN: " +s);
			}
		}
		
		for(IrBind b : temporaryBinds){
			if(!(context.lva && b.isDead())){
				arrList.addAll(b.toC(context, isMain, extras));
				context.varDecl.put(b.tuple.variableName, b.tuple.type.toC());
				context.varInit.put(b.tuple.variableName, "NULL");
			}
		}
		
		if (isMain) {
			arrList.addAll(beforeIterator);
			arrList.add(itDeclaration);
			arrList.add(itIncrement);
			arrList.add(itCondition);
			arrList.add(stringVarDeclaration);
			arrList.add(tempVar);
			arrList.add(stringVarPopulation);
			arrList.add(printline);
			arrList.add(stringVarFree);
			arrList.add(endBrace);
			arrList.add(itDecrement);
			arrList.add(itNull);
		}
		
		//Should be replaced by Ansha's code methinks
		
		if(context.lva && hasFreeBefore){
			for(String s : freeBefore){
				arrList.add("ref_decrement((General_t)" + s + ");");
				arrList.add(s + " = NULL;");
			}
		}
		
		if(context.lva){
			for (String s : context.controlFlowVariables) {
				arrList.add("ref_decrement((General_t)" + s + ");");
			}
			for(String s : inMinusOut()){
				if(s.equals(expression.toC(context))&& !isMain){
					arrList.add("ref_decrement_no_free((General_t)" + s + ");");
				}
				else{
					arrList.add("ref_decrement((General_t)" + s + ");");
					arrList.add(s + " = NULL;");
				}
			}
			if (isMain) {
				arrList.add("ref_decrement((General_t)input);");
				arrList.add("ending();");
				arrList.add("return;");
			}
			else{
				arrList.add("return " + expression.toC(context) + ";");
			}
		}
		else{
			//Should be replaced by Ansha's code methinks
			// free control flow variables
			if (expression instanceof IrVariableExpression) {
				String name = ((IrVariableExpression) expression).getVarName();
				for (String s : freeContext) {
					if (!isMain && !s.equals(name)) {
						arrList.add("ref_decrement((General_t)" + s + ");");
					}
				}
			}
			
			for (String s : context.controlFlowVariables) {
				arrList.add("ref_decrement((General_t)" + s + ");");
			}
			//NOTE: note sure if supposed to empty this set...

			//Should be replaced by Ansha's code methinks
			if (isMain) {
				for (String s : freeContext) {
					arrList.add("ref_decrement((General_t)" + s + ");");
				}
				//TODO: this looks wrong 
				for (String s : this.context.typeContext.keySet()) {
					if (!freeContext.contains(s)) {
						arrList.add("ref_decrement((General_t)" + s + ");");
					}
				}
				//GARBAGE COLLECT EVERYTHING
				for(int i = 0; i < temporaryBinds.size(); i++){
					IrBind b = temporaryBinds.get(i);
					arrList.add("ref_decrement((General_t)" + b.tuple.variableName + ");");
				}

				// extra expressions will not get added

				//TODO: REMOVE BEFORE SUBMISSION
				arrList.add("ending();");

				arrList.add("return;");
			}
			else {
				for(int i = 0; i < temporaryBinds.size()-1; i++){
					IrBind b = temporaryBinds.get(i);
					if(i == temporaryBinds.size()-1 && b.tuple.variableName.equals(b.toC(context, isMain, extras))){
						arrList.add("ref_decrement((General_t)" + b.tuple.variableName + ");");
					}
					else{
						arrList.add("ref_decrement((General_t)" + b.tuple.variableName + ");");
					}
				}
				arrList.add("ref_decrement_no_free((General_t)" + expression.toC(context) + ");");
				// add statements that are in extras
				if (extras != null) {
					arrList.addAll(extras);
				}
				if(expression instanceof IrIterableComp){
					IrIterableComp comp = (IrIterableComp)expression;
					if (comp.comprehension!=null) {
						arrList.add("return " + comp.comprehension.toC(context));
					}
				}
				else{
					arrList.add("return " + expression.toC(context) + ";");
				}
			}
		}
		return arrList;
	}
	/*
	@Override
	public ArrayList<String> toMainC(CGenerationContext context) {
		ArrayList<String> output = new ArrayList<String>();
//		int cur_iterator = context.getCurIterator();
//		context.incrementCurIterator();
//		String iterator = "_it" + cur_iterator;
//		context.mainVarDecl.put(iterator, "iterator_t");
//		String itDeclaration = iterator + " = new_iterator((" + expression.toC(context) + "));";
//		String itCondition = "while(hasNext(" + iterator + ")) {";
//		String tempVar = "_return = getNext(" + iterator + ");";
//		
		
//		for(IrBind b : temporaryBinds){
//			output.addAll(b.toC(context));
//		}
//		for(int i = 0; i < temporaryBinds.size()-1; i++){
//			IrBind b = temporaryBinds.get(i);
			output.add("ref_decrement((General_t)" + b.tuple.variableName + ");");
//		}
//		output.add(itDeclaration);
//		output.add(itCondition);
//		output.add(tempVar);
		
//		for (String s : freeContext) {
//			if (!s.equals("_input"))
			output.add("ref_decrement((General_t)" + s + ");");
//		}
////		
//		output.add("print_line(charToString(_return), stringLength(_return));");
//		
//		output.add("}");
//		for (String s : freeContext) {
//			output.add("ref_decrement((General_t)" + s + ");");
//		}
//		//GARBAGE COLLECT EVERYTHING
//		output.add("return;");
//		return output;
	}
	*/

	public ArrayList<IrBind> getTemporaryVariables(){
		return this.temporaryBinds;
	}

	@Override
	public void lva(LvaContext c) {
		lvaHelper(c);
		
		if (c.debug) {
		// DEBUG STATEMENTS
		System.out.println(toString());
		lvaDebugHelper();
		}
	}

	@Override
	// return statements don't have next
	public void populateSets(LvaContext c) {
		if (nextSet==null) {
			nextSet = new HashSet<IrStatement>();
			if (c.nextList.size() >0) {
				c.nextList.removeFirst().getTop();
			}
			useSet = new HashSet<String>();
			getExpression().getVars(useSet, c.functionUse);
			populateSetsTemps(c);
		}
	}

	public void removeCommonSubexpressions(CseContext context) {
		for (IrBind tempBind : temporaryBinds){
//			System.out.println("Before CSE: " + tempBind.getVariableName() + "=" + tempBind.getExpression());
			tempBind.expression = tempBind.expression.eliminateSubexpression(context);
			context.putVariable(tempBind.getVariableName(), tempBind.expression.getSubexpressions(context));
//			System.out.println("After CSE: " + tempBind.getVariableName() + "=" + tempBind.getExpression());
		}
		IrExpression temp = expression.eliminateSubexpression(context);
		if (!expression.equals(temp)){
			cse = true;
			expression = temp;
		}
	}

	@Override
	public String toString() {
		return "IrReturn: return " + getExpression().toString();
	}

	public IrExpression getExpression() {
		int length = temporaryBinds.size();
		IrExpression e0 = null;
		if (length > 0) {
			String varname = temporaryBinds.get(length-1).tuple.variableName;
			e0 = new IrVariableExpression(varname);
		}
		if (e0==null || expression==null) {
		}  else {
			String s1 = expression.toString();
			String s2 = e0.toString();
			if (!s1.equals(s2)) {
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.println("IrReturn : Condition: " + expression.toString() + " , e0: " + e0.toString());
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			}
		}

		return expression;
	}
}

