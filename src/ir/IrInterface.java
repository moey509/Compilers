package ir;

import java.util.ArrayList;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public class IrInterface implements IrProgramElem {
	public String name;
	public CubexList<String> kindContext;
	public CubexTypeGrammar extendsType;
	public CubexList<IrFunctionDef> functionList;

	public IrInterface(String n, CubexList<String> k, CubexTypeGrammar t,
			CubexList<IrFunctionDef> l) {
		name = n;
		kindContext = k;
		extendsType = t;
		functionList = l;
	}

	@Override
	public ArrayList<String> toC() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
