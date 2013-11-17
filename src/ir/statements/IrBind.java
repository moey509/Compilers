package ir.statements;

import java.util.ArrayList;

import typeChecker.CubexCompleteContext;
import ir.CGenerationContext;
import ir.expressions.IrExpression;
import ir.expressions.IrExpressionTuple;
import ir.expressions.IrFunctionCall;
import ir.expressions.IrVariableExpression;
import ir.program.IrTypeTuple;

public final class IrBind implements IrStatement {
	public IrTypeTuple tuple;
	public IrExpression expression;
	public ArrayList<IrBind> temporaryBinds;
	public CubexCompleteContext context;

	public IrBind(IrTypeTuple tuple, IrExpression expression, CubexCompleteContext context) {
		this.tuple = tuple;
		this.expression = expression;
		this.temporaryBinds = new ArrayList<IrBind>();
		this.context = context;
	}
	
	public void addDeclaration(ArrayList<String> arr, CGenerationContext context){
		context.varDecl.put(tuple.variableName, "void*");
//		if(!context.variablesDeclaredInScope.contains(tuple.variableName)){
//			arr.add("void* " + tuple.variableName + ";");
//			context.variablesDeclaredInScope.add(tuple.variableName);
//		}
	}
	
	public void addInitialization(ArrayList<String> arr, CGenerationContext context){
		context.varInit.put(tuple.variableName, "NULL");
//		if(!context.variablesInitializedInScope.contains(tuple.variableName)){
//			arr.add(tuple.variableName + " = NULL;");
//			context.variablesInitializedInScope.add(tuple.variableName);
//		}
	}

	@Override
	public ArrayList<String> toC(CGenerationContext context, boolean isMain) {
		ArrayList<String> output = new ArrayList<String>();
		//output.add(tuple.type.toC() + " " + tuple.variableName + " = " + expression.toC(context) + ";");
		for(IrBind b : temporaryBinds){
			// put variables at the top of main() here:
			if (isMain) {
				context.varDecl.put(b.tuple.variableName, tuple.type.toC());
				context.varInit.put(b.tuple.variableName, "NULL");
			}
			output.add(b.tuple.variableName + " = NULL;");
			output.addAll(b.toC(context, isMain));
		}
		context.varDecl.put(tuple.variableName, tuple.type.toC());
		context.varInit.put(tuple.variableName, "NULL");
		
		// put everything in fcnVarDecl ->
		// the check for whether things already exist in temporaryBinds happens in IrFunction
//		if (!isMain) {
//			context.varDecl.put(tuple.variableName, tuple.type.toC());
//		}

		if(temporaryBinds.size() > 0){
			String s = temporaryBinds.get(temporaryBinds.size()-1).tuple.variableName;
			output.add("ref_decrement((General_t)" + tuple.variableName + ");");
			output.add(tuple.variableName + " = " + s + ";");
			output.add("ref_increment((General_t)" + tuple.variableName + ");");
		}
		else{
			//TODO: We need to make sure that y was initialized somehow or initialize everything to NULL and set to NULL when freed
			output.add("ref_decrement((General_t)" + tuple.variableName + ");");
			if (expression instanceof IrFunctionCall) {
				IrFunctionCall funcCall = (IrFunctionCall) expression;		
				for (IrExpressionTuple tuple : funcCall.getArugments()) {
					output.add("ref_increment((General_t)" + tuple.getExpression().toC(context)+ ");");
				}
			}
			output.add(tuple.variableName + " = " + expression.toC(context) + ";");
			output.add("ref_increment((General_t)" + tuple.variableName + ");");
		}
		for(IrBind b : temporaryBinds){
			output.add("ref_decrement((General_t)" + b.tuple.variableName + ");");
			output.add(b.tuple.variableName + " = NULL;");
		}
		return output;
	}
	
	public ArrayList<IrBind> getTemporaryVariables(){
		return this.temporaryBinds;
	}

}