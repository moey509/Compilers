package parsingTokens.program;

import java.util.HashMap;

import ir.program.IrProgram;
import Exception.SemanticException;
import parsingTokens.CubexClassGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;

public class CubexProgramClass implements CubexProgramType {
	private CubexClassGrammar cubexClass;

	public CubexProgramClass(CubexClassGrammar cubexClass) {
		this.cubexClass = cubexClass;
	}

	public String toString() {
		return cubexClass.toString();
	}

	@Override
	public CubexCompleteContext typeCheck(CubexCompleteContext c)
			throws SemanticException {
		// TODO Auto-generated method stub
		return cubexClass.typeCheck(c);
	}

	@Override
	public IrProgram toIr(IrGenerationContext context, IrProgram program) {
		return cubexClass.toIr(context, program);
	}

	@Override
	public void replaceVars(HashMap<String, String> map) {
		cubexClass.replaceVars(map);
		
	}

}