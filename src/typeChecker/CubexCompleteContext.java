package typeChecker;

import parsingTokens.context.CubexTypeScheme;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public class CubexCompleteContext {
	ClassContext classContext;
	KindContext kindContext;
	FunctionContext functionContext;
	TypeContext typeContext;
	TypeContext mutableTypeContext;

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
	public CubexCompleteContext clone() {
		return new CubexCompleteContext(classContext, kindContext,
				functionContext, typeContext, mutableTypeContext);
	}

	public void appendClassContext(ClassContext t) {
		classContext.merge(t);
	}

	public void appendClassContext(String s, ClassContextElement t) {
		classContext.put(s, t);
	}

	public boolean containsClassName(String s){
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
	
	public boolean containsFunctionName(String s){
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
	
	public boolean containsTypeVariableInTypeContext(String s){
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
	
	public boolean containsTypeVariableInMutableTypeContext(String s){
		return mutableTypeContext.containsKey(s);
	}

	public CubexTypeGrammar getTypeGrammarFromMutableTypeContext(
			String variableName) {
		return mutableTypeContext.get(variableName);
	}

}
