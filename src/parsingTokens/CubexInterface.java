package parsingTokens;

import java.util.HashMap;
import java.util.Map;

import Exception.SemanticException;
import parsingTokens.context.CubexTypeScheme;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.ClassContext;
import typeChecker.ClassContextElement;
import typeChecker.CubexCompleteContext;

public class CubexInterface {
	public String name;
	public CubexList<String> kindContext;
	public CubexTypeGrammar extendsType;
	public CubexList<CubexFunctionDef> functionList;

	public CubexInterface(String n, CubexList<String> k, CubexTypeGrammar t,
			CubexList<CubexFunctionDef> l) {
		name = n;
		kindContext = k;
		extendsType = t;
		functionList = l;
	}

	public String toString() {
		String rightSpace1 = kindContext.size() == 0 ? "" : " ";
		String rightSpace2 = functionList.size() == 0 ? "" : " ; ";
		StringBuilder build = new StringBuilder();
		build.append("interface ");
		build.append(name);
		build.append(" < ");
		build.append(kindContext.toString(","));
		build.append(rightSpace1);
		build.append("> extends ");
		build.append(extendsType);
		build.append(" { ");
		build.append(functionList.toString(";"));
		build.append(rightSpace2);
		build.append("}");
		return build.toString();
	}
	//TODO: Need a way to get functions from supertype
	//TODO: Need a way to get the constructable component
	public ClassContext typeCheck(CubexCompleteContext originalContext)
			throws SemanticException {
		CubexCompleteContext context = originalContext.clone();
		
		
		
		
		ClassContextElement element = new ClassContextElement(this);
		context.appendClassContext(name, element);

		
		
		for (String s : kindContext.iterable()){
			//do something with kind context
		}
		
		ClassContextElement superElement;
		if (context.containsClassName(extendsType.getName())) {
			superElement = context.getElementFromClassContext(extendsType.getName());
		}
		else {
			throw new SemanticException("Supertype not found");
		}
		Map<String, CubexTypeScheme> superTypeFunctions = superElement.functionMap;

		for (CubexFunctionDef function : functionList.iterable()) {
			if (superTypeFunctions.containsKey(function.name)) {
				if (superTypeFunctions.get(function.name).equals(
						function.typescheme)) {
					throw new SemanticException(
							"Type parameters for function "
									+ function.name
									+ " does not agree with the supertype function parameters.");
				}
			}
		}
		return context.classContext;
	}

}
