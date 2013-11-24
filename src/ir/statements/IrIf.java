package ir.statements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import optimization.LvaContext;
import optimization.CseContext;
import typeChecker.CubexCompleteContext;
import ir.CGenerationContext;
import ir.expressions.IrExpression;

public class IrIf extends IrStatement {

	private ArrayList<String> freeContext; //if block
	private ArrayList<String> freeContext2; // else block
	private IrExpression condition;
	private List<IrStatement> statements1; // { s1 }
	private List<IrStatement> statements2; // else {s2}
	public ArrayList<IrBind> temporaryBinds = new ArrayList<IrBind>();
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
	public ArrayList<String> toC(CGenerationContext context, boolean isMain) {
		ArrayList<String> arrList = new ArrayList<String>();
		for(IrBind b : temporaryBinds){
			context.varDecl.put(b.tuple.variableName, b.tuple.type.toC());
			context.varInit.put(b.tuple.variableName, "NULL");
			arrList.addAll(b.toC(context, isMain));
		}
		arrList.add("if(((Boolean_t)" + condition.toC(context) + ")->value) {");
		for(IrBind b : temporaryBinds){
			String s = b.tuple.variableName;
			arrList.add("ref_decrement((General_t)" + s + ");");
			arrList.add(s + "= NULL;");
		}
		for (IrStatement s1 : statements1) {
			arrList.addAll(s1.toC(context, isMain));
		}
		//ref_decrement the discarded variables
		for (String s : freeContext) {
			arrList.add("ref_decrement((General_t)" + s + ");");
		}
		if (statements2.isEmpty()) {
			arrList.add("}");
			for(IrBind b : temporaryBinds){
				String s = b.tuple.variableName;
				arrList.add("ref_decrement((General_t)" + s + ");");
				arrList.add(s + "= NULL;");
			}
		} else {
			arrList.add("} else {");
			for(IrBind b : temporaryBinds){
				String s = b.tuple.variableName;
				arrList.add("ref_decrement((General_t)" + s + ");");
				arrList.add(s + "= NULL;");
			}
			for (IrStatement s2 : statements2) {
				arrList.addAll(s2.toC(context, isMain));
			}
			//ref_decrement the else discarded variables
			for (String s : freeContext2) {
				arrList.add("ref_decrement((General_t)" + s + ");");
			}
			arrList.add("}");
		}
		return arrList;
	}
/*
	@Override
	public ArrayList<String> toMainC(CGenerationContext context) {
//		ArrayList<String> arrList = new ArrayList<String>();
//		for (IrBind b : temporaryBinds){
//			arrList.addAll(b.toC(context));
//		}
//		arrList.add("if(" + condition.toC(context) + ") {");
//		for(IrBind b : temporaryBinds){
//			arrList.add("ref_decrement((General_t)" + b.tuple.variableName + ");");
//		}
//		for (IrStatement s1 : statements1) {
//			arrList.addAll(s1.toMainC(context));
//		}
//		//ref_decrement the else discarded variables
//		for (String s : freeContext) {
//			arrList.add("ref_decrement((General_t)" + s + ");");
//		}
		if (statements2.isEmpty()) {
			arrList.add("}");
		} else {
			arrList.add("} else {");
			for (IrStatement s2 : statements2) {
				arrList.addAll(s2.toMainC(context));
			}
			//ref_decrement the else discarded variables
			for (String s : freeContext2) {
				arrList.add("ref_decrement((General_t)" + s + ");");
			}
			arrList.add("}");
		}
		return arrList;
	}
	*/
	public ArrayList<IrBind> getTemporaryVariables(){
		return this.temporaryBinds;
	}

	@Override
	public void lva(LvaContext c) {
		lvaHelper(c);
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
			condition.getVars(useSet, c.functionUse);
			
			populateSetsTemps(c);
			
			int length = statements1.size();
			if (length > 0) {
				LvaContext cCopy = c.clone();
				IrStatement afterIf = cCopy.nextList.removeFirst().getTop();

				cCopy.nextList.addAll(0, statements1);
				nextSet.add(cCopy.nextList.removeFirst().getTop());

				IrStatement lastForStatement = statements1.get(length-1);
				lastForStatement.nextSet = new HashSet<IrStatement>();
				lastForStatement.nextSet.add(afterIf);
				
				for (IrStatement s : statements1) {
					s.populateSets(cCopy);
				}
				
			}
			
			if (statements2.size() > 0) {
				c.nextList.addAll(0, statements2);
				nextSet.add(c.nextList.removeFirst().getTop());
				
				for (IrStatement s : statements2) {
					s.populateSets(c);
				}
			} else {
				nextSet.add(c.nextList.removeFirst().getTop());
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
		for (IrStatement statement : statements1){
			statement.removeCommonSubexpressions(context2);
		}
		context = context1.merge(context2);
	}
}
