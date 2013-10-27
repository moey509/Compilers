package parsingTokens.program;

import java.util.ArrayList;

import ir.IrProgramElem;
import Exception.SemanticException;
import parsingTokens.CubexClassGrammar;
import typeChecker.CubexCompleteContext;

public class CubexProgramClass implements CubexProgramType {
	private CubexClassGrammar cubexClass;

	public CubexProgramClass(CubexClassGrammar cubexClass) {
		this.cubexClass = cubexClass;
	}

	public String toString() {
		return cubexClass.toString();
	}

	@Override
	public CubexCompleteContext typeCheck(CubexCompleteContext c) throws SemanticException {
		// TODO Auto-generated method stub
		return cubexClass.typeCheck(c);
	}

	@Override
	public ArrayList<IrProgramElem> toIr() {
		ArrayList<IrProgramElem> arr = new ArrayList<IrProgramElem>();
		arr.add(cubexClass.toIr());
		return arr;
	}

}