package ir.statements;

import ir.CGenerationContext;
import ir.IrMiscFunctions;
import ir.expressions.IrExpression;
import ir.expressions.IrVariableExpression;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import optimization.LvaContext;
import optimization.CseContext;
import typeChecker.CubexCompleteContext;

public final class IrWhile extends IrStatement {
	private ArrayList<String> freeContext = new ArrayList<String>();
	private IrExpression condition;
	private List<IrStatement> statements;
	public CubexCompleteContext context;

	public IrWhile(IrExpression condition, CubexCompleteContext context) {
		this.condition = condition;
		this.statements = new ArrayList<IrStatement>();
		this.temporaryBinds = new ArrayList<IrBind>();
		this.context = context;
		
//		condition.getVars(this.useSet);
	}
	
	public void addDeclaration(ArrayList<String> arr, CGenerationContext context){
	}
	public void addInitialization(ArrayList<String> arr, CGenerationContext context){
	}
	
	public void setFreeContext(ArrayList<String> fc) {
		freeContext = fc;
	}
	
	public void addStatement(IrStatement statement){
		statements.add(statement);
	}
	
	public void addStatement(List<IrStatement> statement){
		statements.addAll(statement);
	}

	@Override
	public ArrayList<String> toC(CGenerationContext context, boolean isMain, ArrayList<String> extras) {
		ArrayList<String> arrList = new ArrayList<String>();
		if(context.lva && hasFreeBefore){
			for(String s : freeBefore){
				IrMiscFunctions.decrement_ref(context, s, arrList);
//				arrList.add("ref_decrement((General_t)" + s + ");");
				arrList.add(s + " = NULL;");
			}
		}
		for (IrBind i : temporaryBinds) {
			arrList.addAll(i.toC(context, isMain, extras));
		}
		arrList.add("while(((Boolean_t)" + condition.toC(context) + ")->value) {");
		//Should be replaced by Ansha's code methinks
		if(!context.lva){
			for(IrBind b : this.temporaryBinds){
				String s = b.tuple.variableName;
				IrMiscFunctions.decrement_ref(context, s, arrList);
//				arrList.add("ref_decrement((General_t)" + s + ");");
				arrList.add(s + "= NULL;");
			}
		}
		else{
			for(String s : inMinusOut()){
				IrMiscFunctions.decrement_ref(context, s, arrList);
//				arrList.add("ref_decrement((General_t)" + s + ");");
				arrList.add(s + " = NULL;");
			}
		}
		for (IrBind i : temporaryBinds) {
			if(!(context.lva && i.isDead())){
				context.varDecl.put(i.tuple.variableName, i.tuple.type.toC());
				context.varInit.put(i.tuple.variableName, "NULL");
			}
		}
		if (isMain) {
			for(IrStatement s : statements){
				for(IrBind b : s.getTemporaryVariables()){
					b.addDeclaration(arrList, context);
					b.addInitialization(arrList, context);
				}
				s.addDeclaration(arrList, context);
				s.addInitialization(arrList, context);
			}
		}
		for (IrStatement statement : statements){
			arrList.addAll(statement.toC(context, isMain, extras));
		}
		for (IrBind i : temporaryBinds) {
			arrList.addAll(i.toC(context, isMain, extras));
		}
		arrList.add("}");
		//Should be replaced by Ansha's code methinks
		if(!context.lva){
			for(IrBind b : this.temporaryBinds){
				String s = b.tuple.variableName;
				IrMiscFunctions.decrement_ref(context, s, arrList);
//				arrList.add("ref_decrement((General_t)" + s + ");");
				arrList.add(s + "= NULL;");
			}
			for (String s : freeContext) {
				IrMiscFunctions.decrement_ref(context, s, arrList);
//				arrList.add("ref_decrement((General_t)" + s + ");");
			}
		}
		else{
			for(String s : inMinusOut()){
				IrMiscFunctions.decrement_ref(context, s, arrList);
//				arrList.add("ref_decrement((General_t)" + s + ");");
			}
			if(hasFreeAfter){
				for(String s : freeAfter){
					IrMiscFunctions.decrement_ref(context, s, arrList);
//					arrList.add("ref_decrement((General_t)" + s + ");");
					arrList.add(s + "= NULL;");
				}
			}
		}
		
		return arrList;
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
				IrStatement afterWhile = c.nextList.removeFirst();
				IrStatement top = afterWhile.getTop();
				top.afterLoop = true;
				top.prevLoop = this;
				top.lastAfterLoop = true;
				nextSet.add(top);
			}
		
			if (statements.size() > 0) {
				ArrayList<IrStatement> statementlist = new ArrayList<IrStatement>();
				if (statements.get(0) instanceof IrStatementList) {
					IrStatementList st = (IrStatementList) statements.get(0);
					statementlist.addAll(st.statementList);
				} else {
					statementlist.addAll(statements);
				}
				
				if (temporaryBinds.size() > 0) {
					c.nextList.add(0, temporaryBinds.get(0));
				} else {
					c.nextList.add(0, this);
				}

				c.nextList.addAll(0, statementlist);
				IrStatement first = c.nextList.removeFirst().getTop();
				// do stuff with the first statement inside While
				nextSet.add(first);
				first.afterLoop = true;
				first.prevLoop = this;
				first.lastAfterLoop = false;

				for (IrStatement s : statementlist) {
					s.populateSets(c);
				}
			}
		}
	}

	public void removeCommonSubexpressions(CseContext context) {
		context.stripBinds(statements);
		CseContext context1 = context.clone();
		for (IrBind tempBind : temporaryBinds){
			tempBind.expression = tempBind.expression.eliminateSubexpression(context1);
			context1.putVariable(tempBind.getVariableName(), tempBind.expression.getSubexpressions(context1));
		}
		for (IrStatement statement : statements){
			statement.removeCommonSubexpressions(context1);
		}
		context.clearUnknownVariables();
	}

	@Override
	public String toString() {
		return "IrWhile : while (" + getExpression().toString() + " )";
	}

	public IrExpression getExpression() {


		return condition;
	}
	
	public List<IrStatement> getAllStatements(){
		List<IrStatement> output = new ArrayList<IrStatement>();
		output.addAll(statements);
		return output;
	}
}
