package ir.statements;

import ir.CGenerationContext;
import ir.program.IrProgramElem;

import java.util.ArrayList;

public interface IrStatement extends IrProgramElem{
	public ArrayList<IrBind> getTemporaryVariables();
	public void addDeclaration(ArrayList<String> arr, CGenerationContext context);
	public void addInitialization(ArrayList<String> arr, CGenerationContext context);
	public ArrayList<String> toC(CGenerationContext context);
	
	public ArrayList<String> toMainC(CGenerationContext context);
}