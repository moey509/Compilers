package ir.statements;

import java.util.ArrayList;
import java.util.List;

import ir.CGenerationContext;
import ir.expressions.IrExpression;


public class IrFor implements IrStatement {
	private ArrayList<String> freeContext = new ArrayList<String>();
	private IrExpression list;
	private String var;
	private List<IrStatement> statements;
	public ArrayList<IrBind> temporaryBinds;

	public IrFor(String var, IrExpression list) {
		this.list = list;
		this.var = var;
		this.statements = new ArrayList<IrStatement>();
		temporaryBinds = new ArrayList<IrBind>();
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
	public void addDeclaration(ArrayList<String> arr, CGenerationContext context){
		return;
	}
	public void addInitialization(ArrayList<String> arr, CGenerationContext context){
		return;
	}
	
	public ArrayList<String> toC(CGenerationContext context) {
		ArrayList<String> output = new ArrayList<String>();
		int cur_iterator = context.getCurIterator();
		int cur_iterable = context.getCurIterable();
		context.incrementCurIterator();
		context.incrementCurIterable();
		String iterable = context.iterable + cur_iterable;
		String iterator = "__it" + cur_iterator;

		String iterDeclaration = iterable + " = iterable_append((" + list.toC(context) + "), NULL);";
		//add iterable to list of stuff declared at the top of the function

		String itDeclaration = iterator + " = new_iterator((" + iterable + "));";
		String itCondition = "while(hasNext(" + iterator + ")) {";
		String tempVar = "void* " + var + " = getNext(" + iterator + ");";

		output.add(iterDeclaration);
		output.add(itDeclaration);
		output.add(itCondition);
		output.add(tempVar);

		for(IrStatement s : statements){
			for(IrBind b : s.getTemporaryVariables()){
				b.addDeclaration(output, context);
			}
			s.addDeclaration(output, context);
		}
		for(IrStatement s : statements){
			for(IrBind b : s.getTemporaryVariables()){
				b.addInitialization(output, context);
			}
			s.addInitialization(output, context);
		}
		
		for (IrStatement s : statements) {
			output.addAll(s.toC(context));
		}
		
		//decrementing variables in the free context
		//TODO: need to handle v and e in "for(v in e)"
		for (String s : freeContext) {
			output.add("ref_decrement((General_t)" + s + ");");
		}
		
		String endLoop = "}";
		
		output.add(endLoop);

		return output;
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
		// TODO: add iterable (variable) to list of things to be declared at the top of the main function
		context.mainVarDecl.put(iterable, "git_t");
		String itDeclaration = iterator + " = new_iterator((" + iterable + "));";
		String itCondition = "while(hasNext(" + iterator + ")) {";
		String tempVar = "void* " + var + " = getNext(" + iterator + ");";
		
		System.out.println("sdfadfasdfasdff"  + iterDeclaration);
		
		arr.add(iterDeclaration);
		arr.add(itDeclaration);
		arr.add(itCondition);
		arr.add(tempVar);
		
		for (IrStatement s : statements) {
			arr.addAll(s.toMainC(context));
		}
		
		//decrementing variables in the free context
		//TODO: need to handle v and e in "for(v in e)"
		for (String s : freeContext) {
			arr.add("ref_decrement((General_t)" + s + ");");
		}
		
		String endLoop = "}";
		
		arr.add(endLoop);

		return arr;
	}
	public ArrayList<IrBind> getTemporaryVariables(){
		return this.temporaryBinds;
	}
}


