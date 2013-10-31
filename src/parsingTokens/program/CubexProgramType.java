package parsingTokens.program;

import java.util.List;

import context.IrContext;
import ir.IrProgramElem;
import Exception.SemanticException;
import typeChecker.CubexCompleteContext;

public interface CubexProgramType {
	public CubexCompleteContext typeCheck(CubexCompleteContext c)
			throws SemanticException;

	public List<IrProgramElem> toIr(IrContext context);
}
