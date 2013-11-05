package ir.statements;

import java.util.ArrayList;
import java.util.List;

import ir.CGenerationContext;
import ir.expressions.IrExpression;


public class IrFor implements IrStatement {
	private ArrayList<String> freeContext;
	private IrExpression list;
	private String var;
	private List<IrStatement> statements;

	public IrFor(IrExpression list, String var) {
		this.list = list;
		this.var = var;
		this.statements = new ArrayList<IrStatement>();
	}
	
	// initialize the freeContext - used by the typeChecker
	public void setFreeContext(ArrayList<String> fc) {
		freeContext = fc;
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
		int cur_iterable = context.getCurIterable();
		context.incrementCurIterator();
		context.incrementCurIterable();
		String iterable = context.iterable + cur_iterable;
		String iterator = context.iterator + cur_iterator;
		
		//TODO: ANSHA - need to add iterable and iterator into mutable context.
		
		String iterDeclaration = iterable + " = iterable_append((" + list.toC(context) + "), NULL);";
		String itDeclaration = iterator + " = new_iterator((" + iterable + "));";
		String itCondition = "while(hasNext(" + iterator + ")) {";
		String tempVar = var + " = getNext(" + iterator + ");";
		
		arr.add(iterDeclaration);
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


