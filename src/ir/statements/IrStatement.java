package ir.statements;

import ir.CGenerationContext;

import java.util.ArrayList;

public interface IrStatement{
	public ArrayList<IrBind> getTemporaryVariables();
	public void addDeclaration(ArrayList<String> arr, CGenerationContext context);
	public void addInitialization(ArrayList<String> arr, CGenerationContext context);
	public ArrayList<String> toC(CGenerationContext context, boolean isMain);
}