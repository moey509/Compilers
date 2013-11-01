package parsingTokens.program;

import ir.program.IrProgram;
import ir.program.IrProgramContext;

import Exception.SemanticException;
import parsingTokens.CubexInterface;
import typeChecker.ClassContext;
import typeChecker.CubexCompleteContext;

public class CubexProgramInterface implements CubexProgramType {
	private CubexInterface cubexInterface;

	public CubexProgramInterface(CubexInterface cubexInterface) {
		this.cubexInterface = cubexInterface;
	}

	public String toString() {
		return cubexInterface.toString();
	}

	@Override
	public CubexCompleteContext typeCheck(CubexCompleteContext c)
			throws SemanticException {
		// TODO Auto-generated method stub
		ClassContext cont = cubexInterface.typeCheck(c);
		c.appendClassContext(cont);
		return c;
	}

	@Override
	public IrProgram toIr(IrProgramContext context, IrProgram program) {
		// TODO Auto-generated method stub
		return null;
	}
}
