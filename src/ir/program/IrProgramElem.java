package ir.program;

import java.util.ArrayList;

import ir.CGenerationContext;

public interface IrProgramElem {
	public ArrayList<String> toC(CGenerationContext context, boolean isMain);
}
