package ir.statements;

import ir.CGenerationContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import optimization.LvaContext;
import parsingTokens.statements.CubexStatement;
import optimization.CseContext;
import typeChecker.CubexCompleteContext;

public class IrStatementList extends IrStatement{
	protected List<IrStatement> statementList;
	public CubexCompleteContext context;

	public IrStatementList(CubexCompleteContext context){
		this.statementList = new ArrayList<IrStatement>();
		this.context = context;
	}
	
	public IrStatementList(List<IrStatement> statementList, CubexCompleteContext context) {
		this.statementList = statementList;
		this.context = context;
	}

	public void addStatement(IrStatement stmt){
		this.statementList.add(stmt);
	}

	public void addDeclaration(ArrayList<String> arr, CGenerationContext context){
		for(IrStatement s : statementList){
			s.addDeclaration(arr, context);
		}
	}
	public void addInitialization(ArrayList<String> arr, CGenerationContext context){
		for(IrStatement s : statementList){
			s.addInitialization(arr, context);
		}
	}
	
	@Override
	public ArrayList<String> toC(CGenerationContext context, boolean isMain, ArrayList<String> extras) {
		ArrayList<String> output = new ArrayList<String>();
		for (IrStatement stmt : statementList){
			output.addAll(stmt.toC(context, isMain, extras));
			System.out.println("hi" + stmt.toC(context, isMain, extras));
			output.addAll(stmt.toC(context, isMain, extras));
		}
		return output;
	}
/*
	@Override
	public ArrayList<String> toMainC(CGenerationContext context) {
		ArrayList<String> output = new ArrayList<String>();
		for (IrStatement stmt : statementList){
			output.addAll(stmt.toMainC(context));
		}
		return output;
	}
	*/
	public ArrayList<IrBind> getTemporaryVariables(){
		for(IrStatement s : statementList){
			this.temporaryBinds.addAll(s.getTemporaryVariables());
		}
		return this.temporaryBinds;
	}

	@Override
	public void lva(LvaContext c) {
		for (IrBind s : temporaryBinds) {
			s.lva(c);
		}
		for (IrStatement s : statementList) {
			s.lva(c);
		}
		
	}

	@Override
	public void populateSets(LvaContext c) {
		if (nextSet==null) {
			nextSet = new HashSet<IrStatement>();
			
			populateSetsTemps(c);
			
			c.nextList.addAll(0, statementList);
			for (IrStatement s : statementList) {
				s.populateSets(c);
			}
		}
		
	}

	public void removeCommonSubexpressions(CseContext context) {
		for (IrStatement statement : statementList){
			statement.removeCommonSubexpressions(context);
		}
	}

	@Override
	public String toString() {
		return "IrStatementList";
	}
}
