package parsingTokens.program;

import ir.IrProgramElem;
import java.util.ArrayList;
import Exception.SemanticException;
import parsingTokens.CubexInterface;
import typeChecker.ClassContext;
import typeChecker.CubexCompleteContext;

public class CubexProgramInterface implements CubexProgramType {
	private CubexInterface cubexInterface;

	public CubexProgramInterface(CubexInterface cubexInterface) {
		this.cubexInterface = cubexInterface;
	}
	
	public ArrayList<IrProgramElem> toIr() {
		ArrayList<IrProgramElem> arr = new ArrayList<IrProgramElem>();
		arr.add(cubexInterface.toIr());
		return arr;
	}

	public String toString() {
		return cubexInterface.toString();
	}

	@Override
	public CubexCompleteContext typeCheck(CubexCompleteContext c) throws SemanticException {
		// TODO Auto-generated method stub
		ClassContext cont = cubexInterface.typeCheck(c);
		c.appendClassContext(cont);
		return c;
	}
}
