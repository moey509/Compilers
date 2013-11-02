package ir;

import ir.statements.IrStatement;

import java.util.ArrayList;
import java.util.List;

public class IrGenerationContext {
	private String superClass;
	private List<String> globalFunctions;
	private List<String> globalVariables;
	private List<IrStatement> mainFunctionStatements;

	public IrGenerationContext() {
		globalFunctions = new ArrayList<String>();
		globalVariables = new ArrayList<String>();
		mainFunctionStatements = new ArrayList<IrStatement>();
	}

	public String getSuperClass() {
		return superClass;
	}

	public void setSuperClass(String superClass) {
		this.superClass = superClass;
	}

	public void addGlobalVariable(String variable) {
		globalVariables.add(variable);
	}

	public boolean containsGlobalVariable(String variable) {
		return globalVariables.contains(variable);
	}

	public void addGlobalFunction(String function) {
		globalFunctions.add(function);
	}

	public boolean containsGlobalFunction(String function) {
		return globalFunctions.contains(function);
	}

	public void addStatementToMainFunction(List<IrStatement> irStatementList) {
		mainFunctionStatements.addAll(irStatementList);
	}

	public List<IrStatement> getMainFunctionStatements() {
		return mainFunctionStatements;
	}
}
