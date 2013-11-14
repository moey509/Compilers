package ir.statements;

import ir.CGenerationContext;
import ir.expressions.IrExpression;

import java.util.ArrayList;

import typeChecker.CubexCompleteContext;

public final class IrReturn implements IrStatement {
	// the Cubex variables to be freed before returning
	private ArrayList<String> freeContext = new ArrayList<String>();
	private IrExpression expression;
	public ArrayList<IrBind> temporaryBinds = new ArrayList<IrBind>();
	public CubexCompleteContext context;
	
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
	public ArrayList<String> toC(CGenerationContext context, boolean isMain) {
		ArrayList<String> arrList = new ArrayList<String>();

		String itDeclaration = "";
		String itCondition = "";
		String tempVar = "";
		if (isMain) {
			int cur_iterator = context.getCurIterator();
			context.incrementCurIterator();
			String iterator = "_it" + cur_iterator;
			context.mainVarDecl.put(iterator, "iterator_t");
			itDeclaration = iterator + " = new_iterator((" + expression.toC(context) + "));";
			itCondition = "while(hasNext(" + iterator + ")) {";
			tempVar = "_return = getNext(" + iterator + ");";
		}
		
		for(IrBind b : temporaryBinds){
			arrList.addAll(b.toC(context, isMain));
		}
		for(int i = 0; i < temporaryBinds.size()-1; i++){
			IrBind b = temporaryBinds.get(i);
			arrList.add("ref_decrement((General_t)" + b.tuple.variableName + ");");
		}
		
		if (isMain) {
			arrList.add(itDeclaration);
			arrList.add(itCondition);
			arrList.add(tempVar);
		}
		
		for (String s : freeContext) {
			if (isMain) {
				if (!s.equals("_input"))
					arrList.add("ref_decrement((General_t)" + s + ");");
			}
			else {
				arrList.add("ref_decrement((General_t)" + s + ");");
			}
		}
		
		if (isMain) {
			arrList.add("print_line(charToString(_return), stringLength(_return));");
			
			arrList.add("}");
			for (String s : freeContext) {
				arrList.add("ref_decrement((General_t)" + s + ");");
			}
			//GARBAGE COLLECT EVERYTHING
			arrList.add("return;");
		}
		else {
			arrList.add("return " + expression.toC(context) + ";");
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
//			output.add("ref_decrement((General_t)" + b.tuple.variableName + ");");
//		}
//		output.add(itDeclaration);
//		output.add(itCondition);
//		output.add(tempVar);
		
//		for (String s : freeContext) {
//			if (!s.equals("_input"))
//			output.add("ref_decrement((General_t)" + s + ");");
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
}

