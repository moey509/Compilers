package ir.comp;

import java.util.ArrayList;

import typeChecker.IrGenerationContext;
import ir.CGenerationContext;
import ir.statements.IrBind;

public interface IrComprehension {
	public String toC(CGenerationContext context);
	
	public ArrayList<IrBind> getExpressions(CGenerationContext context);
	
	public String addHasNextFunction(CGenerationContext context);
	public String addGetNextFunction(CGenerationContext context);
	public String getComprehensionName();
	public String getStructVariableName();
}
