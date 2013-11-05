package ir.statements;

import java.util.ArrayList;

import typeChecker.TypeContext;
import ir.CGenerationContext;
import ir.expressions.IrExpression;

public final class IrReturn implements IrStatement {
	// the Cubex variables to be freed before returning
	private ArrayList<String> freeContext;
	private IrExpression expression;
	
	public IrReturn(IrExpression expression) {
		this.expression = expression;
	}
	
	public void setFreeContext(ArrayList<String> fc) {
		freeContext = fc;
	}
	
	public ArrayList<String> toProgramOutput(CGenerationContext context) {
		ArrayList<String> output = new ArrayList<String>();
		
		return output;
	}

	@Override
	public ArrayList<String> toC(CGenerationContext context) {
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("return " + expression.toC(context) + ";");
		return arrList;
	}

	@Override
	public ArrayList<String> toMainC(CGenerationContext context) {
		ArrayList<String> output = new ArrayList<String>();
		int cur_iterator = context.getCurIterator();
		context.incrementCurIterator();
		String iterator = "_it" + cur_iterator;
		String itDeclaration = iterator + " = new_iterator((" + expression.toC(context) + "));";
		String itCondition = "while(hasNext(" + iterator + ")) {";
		String tempVar = "_return = getNext(" + iterator + ");";
		
		output.add(itDeclaration);
		output.add(itCondition);
		output.add(tempVar);
		
		output.add("print_line(char* _return, int len)");
		
		output.add("}");
		
		//GARBAGE COLLECT EVERYTHING
		output.add("return;");
		return output;
	}

}

