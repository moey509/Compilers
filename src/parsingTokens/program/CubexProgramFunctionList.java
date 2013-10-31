package parsingTokens.program;

import java.util.ArrayList;

import context.IrContext;
import ir.IrFunctionDef;
import ir.IrProgramElem;
import Exception.SemanticException;
import parsingTokens.CubexFunctionDef;
import parsingTokens.CubexList;
import parsingTokens.context.CubexTypeTuple;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.FunctionContext;
import typeChecker.KindContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;


public class CubexProgramFunctionList implements CubexProgramType {
	private CubexList<CubexFunctionDef> functionList;

	public CubexProgramFunctionList(CubexList<CubexFunctionDef> functionList) {
		this.functionList = functionList;
	}
	
	public ArrayList<IrProgramElem> toIr(IrContext context) {
		ArrayList<IrProgramElem> arr = new ArrayList<IrProgramElem>();
		for (CubexFunctionDef i : functionList.contextCollection) {
			arr.add(i.toIr(context));
		}
		return arr;
	}

	public String toString() {
		return functionList.toString();
	}

	@Override
	public CubexCompleteContext typeCheck(CubexCompleteContext c) throws SemanticException {
		// Create delta'
		for(int i = 0; i < functionList.size(); i++){
			CubexFunctionDef fun = functionList.get(i);
			c.appendFunctionContext(fun.name, fun.typescheme);
		}
		//Validate gamma, tau, and statements of each function
		for(int i = 0; i < functionList.size(); i++){
			//Check that all types are valid given a class and kind context
			CubexFunctionDef fun = functionList.get(i);
			CubexList<CubexTypeTuple> list = fun.typescheme.getTypeContext();
			c.kindContext = new KindContext(fun.typescheme.getKindContext());
			c.mutableTypeContext = new TypeContext(fun.typescheme.getTypeContext());
			//Validate gamma
			for(int j = 0; j < fun.typescheme.getTypeContext().size(); j++){
				list.get(j).getTypeGrammar().validate(c, true);
			}
			//Validate type
			fun.typescheme.getTypeGrammar().validate(c, true);
			TypeContextReturn ret = fun.statement.typeCheckReturn(c);
			//fun.typescheme.getTypeGrammar().isSuperTypeOf(c, ret.retType);
			if(ret.guaranteedToReturn == false || !(fun.typescheme.getTypeGrammar().isSuperTypeOf(c, ret.retType))){
				throw new SemanticException("");
			}
		}
		c.kindContext = new KindContext();
		c.mutableTypeContext = new TypeContext();
		return c;
	}

}
