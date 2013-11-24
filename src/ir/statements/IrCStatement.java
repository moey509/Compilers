package ir.statements;

import ir.CGenerationContext;

import java.util.ArrayList;

import optimization.CseContext;
import optimization.LvaContext;

public class IrCStatement extends IrStatement {
	public ArrayList<String> cStatements;
	
	public IrCStatement(ArrayList<String> cStatements){
		this.cStatements = cStatements;
	}
	
	public void removeCommonSubexpressions(CseContext context) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public ArrayList<IrBind> getTemporaryVariables() {
		// TODO Auto-generated method stub
		return new ArrayList<IrBind>();
	}

	@Override
	public void addDeclaration(ArrayList<String> arr, CGenerationContext context) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void addInitialization(ArrayList<String> arr,
			CGenerationContext context) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public ArrayList<String> toC(CGenerationContext context, boolean isMain) {
		// TODO Auto-generated method stub
		return cStatements;
	}

	@Override
	public void lva(LvaContext c) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void populateSets(LvaContext c) {
		// TODO Auto-generated method stub
		return;
	}

}
