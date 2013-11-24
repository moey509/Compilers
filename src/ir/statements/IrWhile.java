package ir.statements;

import ir.CGenerationContext;
import ir.expressions.IrExpression;

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
		for (IrBind i : temporaryBinds) {
			arrList.addAll(i.toC(context, isMain, extras));
		}
		arrList.add("while(((Boolean_t)" + condition.toC(context) + ")->value) {");
		//TODO: Should be replaced by Ansha's code methinks
		for(IrBind b : this.temporaryBinds){
			String s = b.tuple.variableName;
			arrList.add("ref_decrement((General_t)" + s + ");");
			arrList.add(s + "= NULL;");
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
		//TODO: Should be replaced by Ansha's code methinks
		for(IrBind b : this.temporaryBinds){
			String s = b.tuple.variableName;
			arrList.add("ref_decrement((General_t)" + s + ");");
			arrList.add(s + "= NULL;");
		}
		//TODO: Should be replaced by Ansha's code methinks
		for (String s : freeContext) {
			arrList.add("ref_decrement((General_t)" + s + ");");
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
			condition.getVars(useSet, c.functionUse);
			
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
				
				if (temporaryBinds.size() > 0) {
					c.nextList.add(0, temporaryBinds.get(0));
				} else {
					c.nextList.add(0, this);
				}
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
		return "IrWhile : while (" + condition.toString() + " )";
	}
}
