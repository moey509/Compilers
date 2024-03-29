package typeChecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.context.CubexTypeScheme;
import parsingTokens.typeGrammar.CubexTypeGrammar;

// Represents a complete context. Purpose: packaging reasons.
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

	// CubexCompleteContext add(ClassContext c, KindContext k, FunctionContext
	// f, TypeContext t, TypeContext mt){
	// CubexCompleteContext ccc = new CubexCompleteContext(c, k, f, t, mt);
	//
	// return null;
	// }

	// Returns a shadow copy where the two type contexts are also shallow copied
	public CubexCompleteContext clone() {
		return new CubexCompleteContext(classContext.clone(), kindContext.clone(),
				functionContext.clone(), typeContext.clone(),
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

	public void appendFunctionContext(FunctionContext t) throws SemanticException {
		functionContext.merge(t);
	}

	// Make sure appending the function context does not overload
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

	public CubexTypeScheme methodLookup(CubexTypeGrammar object,
			String methodName) throws SemanticException {
		ClassContextElement classContext;
		if (containsClassName(object.getName())) {
			classContext = getElementFromClassContext(object.getName());
		} else {
			throw new SemanticException("");
		}
		if (classContext.functionMap.containsKey(methodName)) {

			return classContext.functionMap.get(methodName);
		} else {
			throw new SemanticException("");
		}
	}

	public FunctionContext methodContextLookup(String methodName,
			KindContext kContext, CubexList<CubexTypeGrammar> lst)
			throws SemanticException {
		if (!classContext.containsKey(methodName))
			throw new SemanticException("");
		else {
			ClassContextElement ele = classContext.get(methodName);
			CubexTypeGrammar extendsType = ele.type;
			ClassContextElement superEle = classContext.get(extendsType
					.getName());

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

			Map<String, CubexTypeGrammar> map = new HashMap<String, CubexTypeGrammar>();
			ArrayList<CubexTypeGrammar> arrList = new ArrayList<CubexTypeGrammar>();
			for (CubexTypeGrammar tg : lst.iterable()) {
				arrList.add(tg);
			}
			for (String s : kContext.contextSet) {
				int i = 0;
				map.put(s, arrList.get(i));
				i++;
			}

			return fContext1.replace(map);
		}
	}

	public String toString() {
		return classContext.toString() + "\n" + kindContext.toString() + "\n"
				+ functionContext.toString() + "\n" + typeContext.toString()
				+ "\n" + "Mutable " + mutableTypeContext.toString();
	}

}
