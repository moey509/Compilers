package ir.statements;

import ir.CGenerationContext;

import java.util.ArrayList;

public interface IrStatement{
	public ArrayList<IrBind> getTemporaryVariables();
	public ArrayList<String> toC(CGenerationContext context);
	
	public ArrayList<String> toMainC(CGenerationContext context);
}