package typeChecker;

import java.util.HashMap;
import java.util.Map;

import Exception.SemanticException;
import parsingTokens.CubexClassGrammar;
import parsingTokens.CubexFunctionDef;
import parsingTokens.CubexInterface;
import parsingTokens.context.CubexTypeScheme;
import parsingTokens.statements.CubexStatement;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import parsingTokens.typeGrammar.CubexTypeIntersection;

public class ClassContextElement {
	private boolean isClass; // Class or interface
	private boolean isIntersection;
	public String name;
	public CubexTypeGrammar type;
	public KindContext kindContext = new KindContext();
	public HashMap<String, CubexTypeScheme> functionMap = new HashMap<String, CubexTypeScheme>();
	public HashMap<String, CubexStatement> functionStatementMap = new HashMap<String, CubexStatement>();

	public ClassContextElement(CubexInterface element) {
		isClass = false;
		isIntersection = false;
		name = element.name;
		type = element.extendsType;
		kindContext.addAll(element.kindContext.contextCollection);
		for (CubexFunctionDef def : element.functionList.contextCollection) {
			functionMap.put(def.name, def.typescheme);
			if (def.statement != null)
				functionStatementMap.put(def.name, def.statement);
		}
	}

	public ClassContextElement(CubexClassGrammar element) {
		isClass = true;
		isIntersection = false;
		name = element.name;
		type = element.extendsType;
		kindContext.addAll(element.kindcontext.contextCollection);
		for (CubexFunctionDef def : element.functions.contextCollection) {
			functionMap.put(def.name, def.typescheme);
			functionStatementMap.put(def.name, def.statement);
		}
	}
	
	private ClassContextElement(ClassContextElement element1, ClassContextElement element2) throws SemanticException{
		isClass = false;
		isIntersection = true;
		name = element1.name + " & " + element2.name;
		type = null;
		for (Map.Entry<String, CubexTypeScheme> entry : element1.functionMap.entrySet()) {
			functionMap.put(entry.getKey(), entry.getValue());
			if (element1.functionStatementMap.containsKey(entry.getKey()))
				functionStatementMap.put(entry.getKey(), element1.functionStatementMap.get(entry.getKey()));
		}
		for (Map.Entry<String, CubexTypeScheme> entry : element2.functionMap.entrySet()) {
			if (functionMap.containsKey(entry.getKey())){
				throw new SemanticException("A class should extend two classes that share function names");
			}
			functionMap.put(entry.getKey(), entry.getValue());
			if (element1.functionStatementMap.containsKey(entry.getKey()))
				functionStatementMap.put(entry.getKey(), element2.functionStatementMap.get(entry.getKey()));
		}
		
	}
	
	public ClassContextElement Intersection(ClassContextElement element) throws SemanticException{
		return new ClassContextElement(this, element);
	}

	public boolean isClass() {
		return isClass;
	}
	
	public String toString(){
		try {
			if (type instanceof CubexTypeIntersection){
				CubexTypeIntersection intersection = (CubexTypeIntersection) type;
				
				return " extends " + intersection.typeGrammar1.name + " & " + intersection.typeGrammar2.name + ". " + kindContext.toString() + ". Functions:" + functionMap.toString();
			}
			return " extends " + type.getName() + ". " + kindContext.toString() + ". Functions:" + functionMap.toString();
		} catch (SemanticException e) {
			e.printStackTrace();
			return "ERROR";
		} 
	}

}
