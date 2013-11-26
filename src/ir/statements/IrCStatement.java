package ir.statements;

import ir.CGenerationContext;
import ir.expressions.IrExpression;

import java.util.ArrayList;

import optimization.CseContext;
import optimization.LvaContext;

public class IrCStatement extends IrStatement {
	public ArrayList<String> cStatements;
	
	public IrCStatement(ArrayList<String> cStatements){
		this.cStatements = cStatements;
	}
	
	public void removeCommonSubexpressions(CseContext context) {
		return;
	}

	@Override
	public ArrayList<IrBind> getTemporaryVariables() {
		return new ArrayList<IrBind>();
	}

	@Override
	public void addDeclaration(ArrayList<String> arr, CGenerationContext context) {
		return;
	}

	@Override
	public void addInitialization(ArrayList<String> arr, CGenerationContext context) {
		return;
	}

	@Override
	public ArrayList<String> toC(CGenerationContext context, boolean isMain, ArrayList<String> extras) {
		return cStatements;
	}

	@Override
	public void lva(LvaContext c) {
		return;
	}

	@Override
	public void populateSets(LvaContext c) {
		return;
	}

	@Override
	public String toString() {
		return "IrCStatement";
	}

}
