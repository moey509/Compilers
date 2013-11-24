package ir.program;

import java.util.ArrayList;

import optimization.CseContext;
>>>>>>> 059289e3fa9cdbf674a1fc0536d23c2bf78796ed
import ir.CGenerationContext;

public interface IrProgramElem {
	public ArrayList<String> toC(CGenerationContext context, boolean isMain);
	
	public void removeCommonSubexpressions(CseContext context);
}
