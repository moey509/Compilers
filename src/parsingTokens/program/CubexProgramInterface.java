package parsingTokens.program;

import java.util.HashMap;

import ir.program.IrProgram;
import Exception.SemanticException;
import parsingTokens.CubexInterface;
import typeChecker.ClassContext;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;

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
		ClassContext cont = cubexInterface.typeCheck(c);
		c.appendClassContext(cont);
		return c;
	}

	@Override
	public IrProgram toIr(IrGenerationContext context, IrProgram program) {
		return cubexInterface.toIr(context, program);
	}

	@Override
	public void replaceVars(HashMap<String, String> map) {
		cubexInterface.replaceVars(map);
		
	}
}
