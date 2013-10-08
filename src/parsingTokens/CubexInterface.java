package parsingTokens;

import Exception.SemanticException;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.ClassContext;
import typeChecker.ClassContextElement;
import typeChecker.CubexCompleteContext;

public class CubexInterface {
	public String name;
	public CubexList<String> kindcontext;
	public CubexTypeGrammar extendsType;
	public CubexList<CubexFunctionDef> functionList;
	public CubexInterface(String n, CubexList<String> k, CubexTypeGrammar t, CubexList<CubexFunctionDef> l) {
		name = n;
		kindcontext = k;
		extendsType = t;
		functionList = l;
	}
	
	public String toString() {
		String rightSpace1 = kindcontext.size() == 0 ? "" : " ";
		String rightSpace2 = functionList.size() == 0 ? "" : " ; ";
		StringBuilder build = new StringBuilder();
		build.append("interface ");
		build.append(name);
		build.append(" < ");
		build.append(kindcontext.toString(","));
		build.append(rightSpace1);
		build.append("> extends ");
		build.append(extendsType);
		build.append(" { ");
		build.append(functionList.toString(";"));
		build.append(rightSpace2);
		build.append("}");
		return build.toString();
	}

	public CubexCompleteContext typeCheck(CubexCompleteContext context) throws SemanticException {
		ClassContextElement element = new ClassContextElement(this);
		context.appendClassContext(name, element);
		if (context.
		context.(extendsType);
		
		for (CubexFunctionDef function : functionList.iterable()) {
			
		}
		return context;
	}

}
