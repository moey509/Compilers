package ir.program;

import java.util.ArrayList;

import optimization.CseContext;
import ir.CGenerationContext;

public interface IrProgramElem {
	public ArrayList<String> toC(CGenerationContext context, boolean isMain, ArrayList<String> extras);
	
	public void removeCommonSubexpressions(CseContext context);
}
