package ir.statements;

import java.util.ArrayList;
import java.util.List;

import optimization.CseContext;
import typeChecker.CubexCompleteContext;
import ir.CGenerationContext;
import ir.expressions.IrExpression;


public class IrFor implements IrStatement {
	private ArrayList<String> freeContext = new ArrayList<String>();
	private IrExpression list;
	private String var;
	private List<IrStatement> statements;
	public ArrayList<IrBind> temporaryBinds;
	public CubexCompleteContext context;

	public IrFor(String var, IrExpression list, CubexCompleteContext context) {
		this.list = list;
		this.var = var;
		this.statements = new ArrayList<IrStatement>();
		this.temporaryBinds = new ArrayList<IrBind>();
		this.context = context;
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
	}
	public void addInitialization(ArrayList<String> arr, CGenerationContext context){
	}

	public ArrayList<String> toC(CGenerationContext context, boolean isMain) {
		ArrayList<String> output = new ArrayList<String>();
		int cur_iterator = context.getCurIterator();
		int cur_iterable = context.getCurIterable();
		context.incrementCurIterator();
		context.incrementCurIterable();
		String iterable = context.iterable + cur_iterable;
		String iterator = context.iterator + cur_iterator;
		
		for(IrBind b : temporaryBinds){
			// put variables at the top of fcn here:
			context.varDecl.put(b.tuple.variableName, b.tuple.type.toC());
			output.add(b.tuple.variableName + " = NULL;");
			output.addAll(b.toC(context, isMain));
		}

		// there's a reason why these aren't IrBinds! The rhs is not really an IrFunctionCall ...
		// there is no CubexTypeGrammar for the expression, and the arguments don't have IrTypes
		// can discuss later?
		String iterDeclaration = iterable + " = iterable_append((" + list.toC(context) + "), NULL);";
		String middleDeclaration = "ref_decrement((General_t)" + iterable + ");";
		String itDeclaration = iterator + " = new_iterator((" + iterable + "));";

		//add iterable to list of stuff declared at the top of the function
		context.varDecl.put(iterable, "git_t");
		context.varDecl.put(iterator, "iterator_t");

		//String itDeclaration = iterator + " = new_iterator((" + iterable + "));";
		//add iterator to list of stuff declared at the top of the function
//		context.fcnVarDecl.put(iterator, "iterator_t");
		String itCondition = "while(hasNext(" + iterator + ")) {";
		String tempVar = "void* " + var + " = getNext(" + iterator + ");";

		output.add(iterDeclaration);
		output.add(middleDeclaration);
		output.add(itDeclaration);
		output.add(itCondition);

		for(IrStatement s : statements){
			for(IrBind b : s.getTemporaryVariables()){
				b.addDeclaration(output, context);
//				output.add(b.tuple.type.toC() + " " + b.tuple.variableName + ";");
			}
			s.addDeclaration(output, context);
		}
		for(IrStatement s : statements){
			for(IrBind b : s.getTemporaryVariables()){
				b.addInitialization(output, context);
			}
			s.addInitialization(output, context);
		}

		output.add(tempVar);

		for (IrStatement s : statements) {
			output.addAll(s.toC(context, isMain));
		}

		String endLoop = "}";

		output.add(endLoop);

		//decrementing variables in the free context
		//TODO: need to handle v and e in "for(v in e)"
		for (String s : freeContext) {
			output.add("ref_decrement((General_t)" + s + ");");
		}

		return output;
	}
	/*
	@Override
	public ArrayList<String> toMainC(CGenerationContext context) {
    /*
		ArrayList<String> arr = new ArrayList<String>();
		int cur_iterator = context.getCurIterator();
		int cur_iterable = context.getCurIterable();
		context.incrementCurIterator();
		context.incrementCurIterable();
		String iterable = context.iterable + cur_iterable;
		String iterator = context.iterator + cur_iterator;
	 */
	//String iterDeclaration = iterable + " = iterable_append((" + list.toC(context) + "), NULL);";
	//		context.mainVarDecl.put(list.toC(context), "void*");
	// TODO: add iterable (variable) to list of things to be declared at the top of the main function
	//context.mainVarDecl.put(iterable, "git_t");
	//String itDeclaration = iterator + " = new_iterator((" + iterable + "));";
	//		context.mainVarDecl.put(iterator, "iterator_t");
	//		String itCondition = "while(hasNext(" + iterator + ")) {";
	//		String tempVar = "void* " + var + " = getNext(" + iterator + ");";

	//		System.out.println("sdfadfasdfasdff"  + iterDeclaration);
	/*
		arr.add(iterDeclaration);
		arr.add(itDeclaration);
		arr.add(itCondition);
		arr.add(tempVar);

		for(IrStatement s : statements){
			for(IrBind b : s.getTemporaryVariables()){
				b.addDeclaration(arr, context);
			}
			s.addDeclaration(arr, context);
		}
		for(IrStatement s : statements){
			for(IrBind b : s.getTemporaryVariables()){
				b.addInitialization(arr, context);
			}
			s.addInitialization(arr, context);
		}

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
	 */
	public ArrayList<IrBind> getTemporaryVariables(){
		return this.temporaryBinds;
	}

	@Override
	public void removeCommonSubexpressions(CseContext context) {
		// TODO Auto-generated method stub
		
	}
}


