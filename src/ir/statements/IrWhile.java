package ir.statements;

import ir.CGenerationContext;
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
				arrList.add("ref_decrement((General_t)" + s + ");");
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
				arrList.add("ref_decrement((General_t)" + s + ");");
				arrList.add(s + "= NULL;");
			}
		}
		else{
			for(String s : inMinusOut()){
				arrList.add("ref_decrement((General_t)" + s + ");");
				arrList.add(s + " = NULL;");
			}
		}
		for (IrBind i : temporaryBinds) {
			context.varDecl.put(i.tuple.variableName, i.tuple.type.toC());
			context.varInit.put(i.tuple.variableName, "NULL");
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
				arrList.add("ref_decrement((General_t)" + s + ");");
				arrList.add(s + "= NULL;");
			}
			for (String s : freeContext) {
				arrList.add("ref_decrement((General_t)" + s + ");");
			}
		}
		else{
			for(String s : inMinusOut()){
				arrList.add("ref_decrement((General_t)" + s + ");");
			}
			if(hasFreeAfter){
				for(String s : freeAfter){
					arrList.add("ref_decrement((General_t)" + s + ");");
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
		CseContext context1 = context.clone();
		context1.stripBinds(statements);
		context1.printContext();
		CseContext context2 = context.clone();

		for (IrStatement statement : statements){
			statement.removeCommonSubexpressions(context1);
		}
		CseContext context3 = context1.merge(context2);
		for (IrBind tempBind : temporaryBinds){
			tempBind.expression = tempBind.expression.eliminateSubexpression(context3);
			context3.putVariable(tempBind.getVariableName(), tempBind.expression.getSubexpressions(context3));
		}
		context.setContext(context3);
	}

	@Override
	public String toString() {
		return "IrWhile : while (" + getExpression().toString() + " )";
	}

	public IrExpression getExpression() {
//		int length =  temporaryBinds.size();
//		IrExpression e0 = null;
//		if (length > 0) {
//			String varname = temporaryBinds.get(length-1).tuple.variableName;
//			String ctype = temporaryBinds.get(length-1).tuple.type.toC();
////			return new IrVariableExpression(varname, ctype);
//			e0 = new IrVariableExpression(varname, ctype);
//		}
//		if (e0==null || condition==null) {
////			System.out.println("IrWhile : e0 or condition is null");
//		}  else {
//			String s1 = condition.toString();
//			String s2 = e0.toString();
//			if (!s1.equals(s2)) {
//				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//				System.out.println("IrWhile : e: " + condition.toString() + " , e0: " + e0.toString());
//				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//			}
//		}

		return condition;
	}
	
	public List<IrStatement> getAllStatements(){
		List<IrStatement> output = new ArrayList<IrStatement>();
		output.addAll(statements);
		return output;
	}
}
