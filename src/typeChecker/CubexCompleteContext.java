package typeChecker;

import java.util.Map;
import java.util.Map.Entry;

import Exception.SemanticException;
import parsingTokens.context.CubexTypeScheme;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public class CubexCompleteContext {
	public ClassContext classContext;
	public KindContext kindContext;
	public FunctionContext functionContext;
	public TypeContext typeContext;
	public TypeContext mutableTypeContext;

	CubexCompleteContext(ClassContext c, KindContext k, FunctionContext f,
			TypeContext t, TypeContext mt) {
		classContext = c;
		kindContext = k;
		functionContext = f;
		typeContext = t;
		mutableTypeContext = mt;
	}

	// TODO: implement adding onto the complete context
	// CubexCompleteContext add(ClassContext c, KindContext k, FunctionContext
	// f, TypeContext t, TypeContext mt){
	// CubexCompleteContext ccc = new CubexCompleteContext(c, k, f, t, mt);
	//
	// return null;
	// }

	// Returns a shadow copy where the two type contexts are also shallow copied
	public CubexCompleteContext clone() {
		return new CubexCompleteContext(classContext, kindContext,
				functionContext, typeContext.clone(),
				mutableTypeContext.clone());
	}

	public void appendClassContext(ClassContext t) {
		classContext.merge(t);
	}

	public void appendClassContext(String s, ClassContextElement t) {
		classContext.put(s, t);
	}

	public boolean containsClassName(String s) {
		return classContext.containsKey(s);
	}

	public ClassContextElement getElementFromClassContext(String s) {
		return classContext.get(s);
	}

	public void appendKindContext(KindContext t) {
		kindContext.addAll(t);
	}

	public void appendKindContext(String s) {
		kindContext.add(s);
	}

	public boolean kindContextContainsTypeParam(String typeParameter) {
		return kindContext.contains(typeParameter);
	}

	public void appendFunctionContext(FunctionContext t) {
		functionContext.merge(t);
	}

	public void appendFunctionContext(String s, CubexTypeScheme t) {
		functionContext.put(s, t);
	}

	public boolean containsFunctionName(String s) {
		return functionContext.containsKey(s);
	}

	public CubexTypeScheme getTypeSchemeFromFunctionContext(String s) {
		return functionContext.get(s);
	}

	public void appendTypeContext(TypeContext t) {
		typeContext.merge(t);
	}

	public void appendTypeContext(String s, CubexTypeGrammar t) {
		typeContext.put(s, t);
	}

	public boolean containsTypeVariableInTypeContext(String s) {
		return typeContext.containsKey(s);
	}

	public CubexTypeGrammar getTypeGrammarFromTypeContext(String variableName) {
		return typeContext.get(variableName);
	}

	public void appendMutableTypeContext(TypeContext t) {
		mutableTypeContext.merge(t);
	}

	public void appendMutableTypeContext(String s, CubexTypeGrammar t) {
		mutableTypeContext.put(s, t);
	}

	public boolean containsTypeVariableInMutableTypeContext(String s) {
		return mutableTypeContext.containsKey(s);
	}

	public CubexTypeGrammar getTypeGrammarFromMutableTypeContext(
			String variableName) {
		return mutableTypeContext.get(variableName);
	}
<<<<<<< HEAD

	public CubexTypeScheme methodLookup(CubexTypeGrammar object,
			String methodName) throws SemanticException {
		ClassContextElement classContext;
=======
	
	public CubexTypeScheme methodLookup(CubexTypeGrammar object, String methodName) throws SemanticException{
		ClassContextElement cCont;
>>>>>>> 2dd00efdf47a07e07f742b6da8048ca6ad81e658
		if (containsClassName(object.name)) {
			cCont = getElementFromClassContext(object.name);
		} else {
			throw new SemanticException("");
		}
<<<<<<< HEAD
		if (classContext.functionMap.containsKey(methodName)) {

			return classContext.functionMap.get(methodName);
=======
		if (cCont.functionMap.containsKey(methodName)) {
			
			return cCont.functionMap.get(methodName);
>>>>>>> 2dd00efdf47a07e07f742b6da8048ca6ad81e658
		} else {
			throw new SemanticException("");
		}
	}

	public FunctionContext methodContextLookup(String methodName,
			KindContext kContext) throws SemanticException {
		if (!classContext.containsKey(methodName))
			throw new SemanticException("");
		else {
			ClassContextElement ele = classContext.get(methodName);
			CubexTypeGrammar extendsType = ele.type;
			ClassContextElement superEle = classContext.get(extendsType.name);

			FunctionContext fContext2 = new FunctionContext();
			for (Entry<String, CubexTypeScheme> entry : superEle.functionMap
					.entrySet()) {
				fContext2.put(entry.getKey(), entry.getValue());
			}

			FunctionContext fContext1 = new FunctionContext();
			for (Entry<String, CubexTypeScheme> entry : ele.functionMap
					.entrySet()) {
				fContext1.put(entry.getKey(), entry.getValue());
			}

			for (Entry<String, CubexTypeScheme> entry : fContext1.nameToTypeSchemeMap
					.entrySet()) {
				if (fContext2.containsKey(entry.getKey())) {
					CubexTypeScheme scheme1 = entry.getValue();
					CubexTypeScheme scheme2 = fContext2.get(entry.getKey());
					if (!scheme1.equals(scheme2))
						throw new SemanticException("Type Schemes do not match");
				}
			}

			return fContext1;

		}
	}

	public CubexTypeGrammar methodImplementedCheck() {
		return null;
	}
}
