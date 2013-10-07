package typeChecker;

import java.util.HashMap;

import parsingTokens.CubexClassGrammar;
import parsingTokens.CubexFunctionDef;
import parsingTokens.CubexInterface;
import parsingTokens.context.CubexTypeScheme;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public class ClassContextElement{
	boolean isClass; //Class or interface
	String name;
	CubexTypeGrammar type;
	KindContext kindContext;
	HashMap<String, CubexTypeScheme> functionMap = new HashMap<String, CubexTypeScheme>();
	
	
	//Duplicated code between for classes and interfaces...
	public ClassContextElement(CubexInterface element) {
		isClass = true;
		name = element.name;
		type = element.type;
		kindContext.addAll(element.kindcontext.contextCollection);
		for(CubexFunctionDef def : element.list.contextCollection){
			functionMap.put(def.name, def.typescheme);
		}
	}
	
	public ClassContextElement(CubexClassGrammar element) {
		isClass = true;
		name = element.name;
		type = element.extendsType;
		kindContext.addAll(element.kindcontext.contextCollection);
		for(CubexFunctionDef def : element.functions.contextCollection){
			functionMap.put(def.name, def.typescheme);
		}
	}
	
}
