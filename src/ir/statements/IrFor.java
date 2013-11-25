package ir.statements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import optimization.LvaContext;
import optimization.CseContext;
import typeChecker.CubexCompleteContext;
import ir.CGenerationContext;
import ir.expressions.IrExpression;
import ir.expressions.IrVariableExpression;


public class IrFor extends IrStatement {
	private ArrayList<String> freeContext = new ArrayList<String>();
	private IrExpression list;
	private String var;
	private List<IrStatement> statements;
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
		String inc1Declaration = "ref_increment((General_t)" + iterable + ");";
		String itDeclaration = iterator + " = new_iterator((" + iterable + "));";
		String inc2Declaration = "ref_increment((General_t)" + iterator + ");";

		//add iterable to list of stuff declared at the top of the function
		context.varDecl.put(iterable, "git_t");
		context.varDecl.put(iterator, "iterator_t");

		//String itDeclaration = iterator + " = new_iterator((" + iterable + "));";
		//add iterator to list of stuff declared at the top of the function
//		context.fcnVarDecl.put(iterator, "iterator_t");
		String itCondition = "while(hasNext(" + iterator + ")) {";
		String tempVar = "void* " + var + " = getNext(" + iterator + ");";
		String tempVarInc = "ref_increment((General_t)" + var + ");";

		output.add(iterDeclaration);
		output.add(inc1Declaration);
		output.add(itDeclaration);
		output.add(inc2Declaration);
		
		//TODO: Should be replaced by Ansha's code
		for(IrBind b : this.temporaryBinds){
			String s = b.tuple.variableName;
			output.add("ref_decrement((General_t)" + s + ");");
		}
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
		output.add(tempVarInc);

		/*** vvv THE FOLLOWING IS A CODE BLOCK ***/
		// MODIFY CONTEXT
		context.controlFlowVariables.add(iterable);
		context.controlFlowVariables.add(iterator);
		
		for (IrStatement s : statements) {
			output.addAll(s.toC(context, isMain));
		}
		
		// UNDO MODIFICATIONS
		context.controlFlowVariables.remove(iterable);
		context.controlFlowVariables.remove(iterator);
		/*** ^^^^ END CODE BLOCK ***/
	
		//TODO: Should be replaced by Ansha's code?
		String tempVarDec = "ref_decrement((General_t)" + var + ");";
		String endLoop = "}";

		output.add(tempVarDec);
		output.add(endLoop);
		
		///TODO: Shouldn't be replaced by Ansha's code?...what if there are two for loops in a row with the same iterable?
		String dec1Declaration = "ref_decrement((General_t)" + iterable + ");";
		String dec2Declaration = "ref_decrement((General_t)" + iterator + ");";
		String null1Declaration = iterable + " = NULL;";
		String null2Declaration = iterator + " = NULL;";
		
		output.add(dec1Declaration);
		output.add(dec2Declaration);
		output.add(null1Declaration);
		output.add(null2Declaration);

		//decrementing variables in the free context
		//TODO: Should be replaced by Ansha's code methinks
		for (String s : freeContext) {
			output.add("ref_decrement((General_t)" + s + ");");
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
			lvaDebugHelper();
		}
		
		for (IrStatement s : statements) {
			s.lva(c);
		}
	}

	@Override
	public void populateSets(LvaContext c) {
		if (nextSet==null) {
			nextSet = new HashSet<IrStatement>();
			
			useSet = new HashSet<String>();
			getExpression().getVars(useSet, c.functionUse);
			
			populateSetsTemps(c);
			
			if (c.nextList.size() > 0) {
				nextSet.add(c.nextList.removeFirst().getTop());
			}
		
			if (statements.size() > 0) {
				ArrayList<IrStatement> statementlist = new ArrayList<IrStatement>();
				if (statements.get(0) instanceof IrStatementList) {
					IrStatementList st = (IrStatementList) statements.get(0);
					statementlist.addAll(st.statementList);
				} else {
					statementlist.addAll(statements);
				}

				c.nextList.add(0, this);
				c.nextList.addAll(0, statementlist);
				nextSet.add(c.nextList.removeFirst().getTop());

				for (IrStatement s : statementlist) {
					s.populateSets(c);
				}
			}
		}
	}

	public void removeCommonSubexpressions(CseContext context) {
		CseContext context1 = context.clone();
		CseContext context2 = context.clone();
		for (IrStatement statement : statements){
			statement.removeCommonSubexpressions(context1);
		}
		context2 = context1.merge(context2);
		for (IrBind tempBind : temporaryBinds){
			tempBind.expression = tempBind.expression.eliminateSubexpression(context);
			context.putVariable(tempBind.getVariableName(), tempBind.expression.getSubexpressions(context));
		}
		context = context.merge(context2);
		
	}

	@Override
	public String toString() {
		return "IrFor: " + "for ( " + var + " in " + getExpression().toString() + " )";
	}

	public IrExpression getExpression() {
		int length = temporaryBinds.size();
		if (length > 0) {
			String varname = temporaryBinds.get(length-1).tuple.variableName;
			String ctype = temporaryBinds.get(length-1).tuple.type.toC();
			return new IrVariableExpression(varname, ctype);
		}
		return list;
	}
}


