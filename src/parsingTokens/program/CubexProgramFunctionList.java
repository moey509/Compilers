package parsingTokens.program;

import ir.program.IrFunction;
import ir.program.IrProgram;
import ir.program.IrProgramContext;
import ir.program.IrTypeTuple;
import Exception.SemanticException;
import parsingTokens.CubexFunctionDef;
import parsingTokens.CubexList;
import parsingTokens.context.CubexTypeTuple;
import typeChecker.CubexCompleteContext;
import typeChecker.KindContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;

public class CubexProgramFunctionList implements CubexProgramType {
	private CubexList<CubexFunctionDef> functionList;

	public CubexProgramFunctionList(CubexList<CubexFunctionDef> functionList) {
		this.functionList = functionList;
	}

	public String toString() {
		return functionList.toString();
	}

	@Override
	public CubexCompleteContext typeCheck(CubexCompleteContext c)
			throws SemanticException {
		// Create delta'
		for (int i = 0; i < functionList.size(); i++) {
			CubexFunctionDef fun = functionList.get(i);
			c.appendFunctionContext(fun.name, fun.typescheme);
		}
		// Validate gamma, tau, and statements of each function
		for (int i = 0; i < functionList.size(); i++) {
			// Check that all types are valid given a class and kind context
			CubexFunctionDef fun = functionList.get(i);
			CubexList<CubexTypeTuple> list = fun.typescheme.getTypeContext();
			c.kindContext = new KindContext(fun.typescheme.getKindContext());
			c.mutableTypeContext = new TypeContext(
					fun.typescheme.getTypeContext());
			// Validate gamma
			for (int j = 0; j < fun.typescheme.getTypeContext().size(); j++) {
				list.get(j).getTypeGrammar().validate(c, true);
			}
			// Validate type
			fun.typescheme.getTypeGrammar().validate(c, true);
			TypeContextReturn ret = fun.statement.typeCheckReturn(c);
			// fun.typescheme.getTypeGrammar().isSuperTypeOf(c, ret.retType);
			if (ret.guaranteedToReturn == false
					|| !(fun.typescheme.getTypeGrammar().isSuperTypeOf(c,
							ret.retType))) {
				throw new SemanticException("");
			}
		}
		c.kindContext = new KindContext();
		c.mutableTypeContext = new TypeContext();
		return c;
	}

	@Override
	public IrProgram toIr(IrProgramContext context, IrProgram program) {
		for (CubexFunctionDef funDef : functionList.iterable()) {
			IrFunction irFunction = new IrFunction(funDef.typescheme
					.getTypeGrammar().toIrType(), funDef.name);
			for (CubexTypeTuple tuple : funDef.typescheme.getTypeContext()
					.iterable()) {
				IrTypeTuple argument = new IrTypeTuple(tuple.getTypeGrammar()
						.toIrType(), tuple.getName());
				irFunction.addFunctionArgument(argument);
			}
			irFunction.addStatement(funDef.statement.toIr(context));
			program.addGlobalFunction(irFunction);
		}
		return program;
	}

}
