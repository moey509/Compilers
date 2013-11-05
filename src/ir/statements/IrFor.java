package ir.statements;

import java.util.ArrayList;
import java.util.List;

import typeChecker.TypeContext;
import ir.CGenerationContext;
import ir.expressions.IrExpression;


public class IrFor implements IrStatement {
	private TypeContext freeContext;
	private IrExpression list;
	private String var;
	private List<IrStatement> statements;

	public IrFor(IrExpression list, String var, TypeContext fc) {
		this.list = list;
		this.var = var;
		this.statements = new ArrayList<IrStatement>();
		this.freeContext = fc;
	}

	public void addStatement(IrStatement statement){
		statements.add(statement);
	}
	
	public void addStatement(List<IrStatement> statement){
		statements.addAll(statement);
	}
	
	
//	  it = new_iterator(i1);
//	  while (hasNext(it)) {
//	    temp = getNext(it);
//	    
//	    /*
//	     *  insert code here
//	     */
//	    
//	    printf ("==> %d\n", temp);
//	}
	public ArrayList<String> toC(CGenerationContext context) {
		ArrayList<String> arr = new ArrayList<String>();
		int cur_iterator = context.getCurIterator();
		context.incrementCurIterator();
		String iterator = "_it" + cur_iterator;
		String itDeclaration = iterator + " = new_iterator((" + list.toC(context) + "));";
		String itCondition = "while(hasNext(" + iterator + ")) {";
		String tempVar = var + " = getNext(" + iterator + ");";
		
		arr.add(itDeclaration);
		arr.add(itCondition);
		arr.add(tempVar);
		
		for (IrStatement s : statements) {
			arr.addAll(s.toC(context));
		}
		
		String endLoop = "}";
		
		arr.add(endLoop);

		return arr;
	}

	@Override
	public ArrayList<String> toMainC(CGenerationContext context) {
		ArrayList<String> arr = new ArrayList<String>();
		int cur_iterator = context.getCurIterator();
		context.incrementCurIterator();
		String iterator = "_it" + cur_iterator;
		String itDeclaration = iterator + " = new_iterator((" + list.toC(context) + "));";
		String itCondition = "while(hasNext(" + iterator + ")) {";
		String tempVar = var + " = getNext(" + iterator + ");";
		
		arr.add(itDeclaration);
		arr.add(itCondition);
		arr.add(tempVar);
		
		for (IrStatement s : statements) {
			arr.addAll(s.toMainC(context));
		}
		
		String endLoop = "}";
		
		arr.add(endLoop);

		return arr;
	}
}


