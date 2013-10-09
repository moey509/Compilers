package typeChecker;

import java.util.HashMap;
import java.util.List;

import parsingTokens.CubexClassGrammar;
import parsingTokens.CubexFunctionDef;
import parsingTokens.CubexInterface;
import parsingTokens.context.CubexTypeScheme;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public class ClassContextElement{
	private boolean isClass; //Class or interface
	public String name;
	public CubexTypeGrammar type;
	public KindContext kindContext = new KindContext();
	public HashMap<String, CubexTypeScheme> functionMap = new HashMap<String, CubexTypeScheme>();
	
	
	//Duplicated code between for classes and interfaces...
	public ClassContextElement(CubexInterface element) {
		isClass = false;
		name = element.name;
		type = element.extendsType;
		kindContext.addAll(element.kindContext.contextCollection);
		for(CubexFunctionDef def : element.functionList.contextCollection){
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
	
	public boolean isClass(){
		return isClass;
	}
	
}
