package ir.statements;

import java.util.ArrayList;

import ir.CGenerationContext;
import ir.expressions.IrExpression;
import ir.program.IrTypeTuple;

public final class IrBind implements IrStatement {
	public IrTypeTuple tuple;
	public IrExpression expression;
	public ArrayList<IrBind> temporaryBinds;

	public IrBind(IrTypeTuple tuple, IrExpression expression) {
		this.tuple = tuple;
		this.expression = expression;
		this.temporaryBinds = new ArrayList<IrBind>();
	}
	
	public void addDeclaration(ArrayList<String> arr, CGenerationContext context){
		if(!context.variablesDeclaredInScope.contains(tuple.variableName)){
			arr.add("void* " + tuple.variableName + ";");
			context.variablesDeclaredInScope.add(tuple.variableName);
		}
	}

	@Override
	public ArrayList<String> toC(CGenerationContext context) {
		ArrayList<String> output = new ArrayList<String>();
		//output.add(tuple.type.toC() + " " + tuple.variableName + " = " + expression.toC(context) + ";");
		for(IrBind b : temporaryBinds){
			output.addAll(b.toC(context));
		}
		if(temporaryBinds.size() > 0){
			String s = temporaryBinds.get(temporaryBinds.size()-1).tuple.variableName;
			output.add(tuple.variableName + " = " + s + ";");
			output.add("ref_increment(" + tuple.variableName + ");");
		}
		else{
			//TODO: We need to make sure that y was initialized somehow or initialize everything to NULL and set to NULL when freed
			output.add("ref_decrement(" + tuple.variableName + ");");
			output.add(tuple.variableName + " = " + expression.toC(context) + ";");
			output.add("ref_increment(" + tuple.variableName + ");");
		}
		for(IrBind b : temporaryBinds){
			output.add("ref_decrement(" + b.tuple.variableName + ");");
		}
		return output;
	}

	@Override
	public ArrayList<String> toMainC(CGenerationContext context) {
		return toC(context);
	}
	
	public ArrayList<IrBind> getTemporaryVariables(){
		return this.temporaryBinds;
	}

}