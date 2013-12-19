package ir.comp;

import java.util.ArrayList;
import java.util.HashMap;

import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.IrGenerationContext;
import ir.CGenerationContext;
import ir.statements.IrBind;

public interface IrComprehension {
	public String toC(CGenerationContext context);
	public String toC(CGenerationContext context, boolean embedded);
	
	public ArrayList<IrBind> getExpressions(CGenerationContext context);
	
	public String addHasNextFunction(CGenerationContext context);
	public String addGetNextFunction(CGenerationContext context);
	public String getComprehensionName();
	public String getStructVariableName();
	public String toC(CGenerationContext context, String variableName);
	public String toC(CGenerationContext context, String variableName, boolean embedded); //I don't think this will work for all cases, but it mgith get some extra points
}
