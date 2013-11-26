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

public class IrIf extends IrStatement {

	private ArrayList<String> freeContext; //if block
	private ArrayList<String> freeContext2; // else block
	private IrExpression condition;
	private List<IrStatement> statements1; // { s1 }
	private List<IrStatement> statements2; // else {s2}
	public CubexCompleteContext context;

	// if there is no else statement, let s2 be null
	public IrIf(IrExpression condition, CubexCompleteContext context) {
		this.condition = condition;
		this.statements1 = new ArrayList<IrStatement>();
		this.statements2 = new ArrayList<IrStatement>();
		this.temporaryBinds = new ArrayList<IrBind>();
		this.context = context;
		
//		condition.getVars(this.useSet);
	}
	
	public void addDeclaration(ArrayList<String> arr, CGenerationContext context){
	}
	public void addInitialization(ArrayList<String> arr, CGenerationContext context){
	}
	
	public void setFreeContext(ArrayList<String> fc, ArrayList<String> fc2) {
		freeContext = fc;
		freeContext2 = fc2;
	}

	public void addStatement1(List<IrStatement> statement) {
		statements1.addAll(statement);
	}

	public void addStatement1(IrStatement statement) {
		statements1.add(statement);
	}

	public void addStatement2(List<IrStatement> statement) {
		statements2.addAll(statement);
	}

	public void addStatement2(IrStatement statement) {
		statements2.add(statement);
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
		
		for(IrBind b : temporaryBinds){
			context.varDecl.put(b.tuple.variableName, b.tuple.type.toC());
			context.varInit.put(b.tuple.variableName, "NULL");
			arrList.addAll(b.toC(context, isMain, extras));
		}
		arrList.add("if(((Boolean_t)" + condition.toC(context) + ")->value) {");
		//TODO: Should be replaced by Ansha's code methinks
		if(!context.lva){
			for(IrBind b : temporaryBinds){
				String s = b.tuple.variableName;
				arrList.add("ref_decrement((General_t)" + s + ");"); 
				arrList.add(s + "= NULL;");
			}
		}
		else{
			for(String s : inMinusOut()){
				arrList.add("ref_decrement((General_t)" + s + ");"); 
				arrList.add(s + "= NULL;");
			}
		}
		for (IrStatement s1 : statements1) {
			arrList.addAll(s1.toC(context, isMain, extras));
		}
		//Should be replaced by Ansha's code methinks
		if(!context.lva){
			for (String s : freeContext) {
				arrList.add("ref_decrement((General_t)" + s + ");");
			}
		}
		if (statements2.isEmpty()) {
			arrList.add("}");
			//Should be replaced by Ansha's code methinks
			if(!context.lva){
				for(IrBind b : temporaryBinds){
					String s = b.tuple.variableName;
					arrList.add("ref_decrement((General_t)" + s + ");");
					arrList.add(s + "= NULL;");
				}
			}
			else{
				for(String s : inMinusOut()){
					arrList.add("ref_decrement((General_t)" + s + ");"); 
					arrList.add(s + "= NULL;");
				}
			}
		} else {
			arrList.add("} else {");
			//Should be replaced by Ansha's code methinks
			if(!context.lva){
				for(IrBind b : temporaryBinds){
					String s = b.tuple.variableName;
					arrList.add("ref_decrement((General_t)" + s + ");"); 
					arrList.add(s + "= NULL;");
				}
			}
			else{
				for(String s : inMinusOut()){
					arrList.add("ref_decrement((General_t)" + s + ");"); 
					arrList.add(s + "= NULL;");
				}
			}
			for (IrStatement s2 : statements2) {
				arrList.addAll(s2.toC(context, isMain, extras));
			}

			//Should be replaced by Ansha's code methinks
			if(!context.lva){
				for (String s : freeContext2) {
					arrList.add("ref_decrement((General_t)" + s + ");");
				}
			}
			arrList.add("}");
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
//			System.out.println(toString());
			lvaDebugHelper();
		}
		
		for (IrStatement s : statements1) {
			s.lva(c);
		}
		for (IrStatement s : statements2) {
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
			
			if (statements1.size() > 0) {
				ArrayList<IrStatement> statementlist = new ArrayList<IrStatement>();
				if (statements1.get(0) instanceof IrStatementList) {
					IrStatementList st = (IrStatementList) statements1.get(0);
					statementlist.addAll(st.statementList);
				} else {
					statementlist.addAll(statements1);
				}
				
				LvaContext cCopy = c.clone();

				cCopy.nextList.addAll(0, statementlist);
				nextSet.add(cCopy.nextList.removeFirst().getTop());

				for (IrStatement s : statementlist) {
					s.populateSets(cCopy);
				}
				
			}
			
			IrStatement afterIf = c.nextList.getFirst();
			if (statements1.size() >0) {
				afterIf.topAccessed = false;
			}

			if (statements2.size() > 0) {
				ArrayList<IrStatement> statementlist = new ArrayList<IrStatement>();
				if (statements2.get(0) instanceof IrStatementList) {
					IrStatementList st = (IrStatementList) statements2.get(0);
					statementlist.addAll(st.statementList);
				} else {
					statementlist.addAll(statements2);
				}
				
				c.nextList.addAll(0, statementlist);
				nextSet.add(c.nextList.removeFirst().getTop());
				
				for (IrStatement s : statementlist) {
					s.populateSets(c);
				}
			} else {
				nextSet.add(c.nextList.removeFirst().getTop());
			}
			
			for (IrStatement s: nextSet) {
				s.afterLoop = true;
				s.lastAfterLoop = false;
				s.prevLoop = this;
			}
		}
	}

	public void removeCommonSubexpressions(CseContext context) {
		for (IrBind tempBind : temporaryBinds){
			tempBind.expression = tempBind.expression.eliminateSubexpression(context);
			context.putVariable(tempBind.getVariableName(), tempBind.expression.getSubexpressions(context));
		}
		condition = condition.eliminateSubexpression(context);
		CseContext context1 = context.clone();
		CseContext context2 = context.clone();
		for (IrStatement statement : statements1){
			statement.removeCommonSubexpressions(context1);
		}
		for (IrStatement statement : statements2){
			statement.removeCommonSubexpressions(context2);
		}
		context.setContext(context1.merge(context2));

	}

	@Override
	public String toString() {
		return "IrIf: if ( " + getExpression().toString() + " )";
	}

	public IrExpression getExpression() {
		int length = temporaryBinds.size();
		if (length > 0) {
			String varname = temporaryBinds.get(length-1).tuple.variableName;
			String ctype = temporaryBinds.get(length-1).tuple.type.toC();
			return new IrVariableExpression(varname, ctype);
		}
		return condition;
	}
}
