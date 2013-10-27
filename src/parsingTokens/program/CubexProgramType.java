package parsingTokens.program;

import java.util.ArrayList;

import ir.IrProgramElem;
import Exception.SemanticException;
import typeChecker.CubexCompleteContext;

public interface CubexProgramType {
	public CubexCompleteContext typeCheck(CubexCompleteContext c) throws SemanticException;
	public ArrayList<IrProgramElem> toIr();
}
