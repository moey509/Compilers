package parsingTokens.context;

import java.util.HashMap;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.TypeContext;

public class CubexTypeScheme {
	private CubexList<String> kindContext;
	private CubexList<CubexTypeTuple> typeContext;
	private CubexTypeGrammar typeGrammar;

	public CubexTypeScheme(CubexList<String> kindContext,
			CubexList<CubexTypeTuple> typeContext, CubexTypeGrammar typeGrammar) {
		this.kindContext = kindContext;
		this.typeContext = typeContext;
		this.typeGrammar = typeGrammar;
	}

	public String toString() {
		return this.toString(" ");
	}
	
	public CubexList<String> getKindContext() {
		return kindContext;
	}

	public CubexList<CubexTypeTuple> getTypeContext() {
		return typeContext;
	}

	public CubexTypeGrammar getTypeGrammar() {
		return typeGrammar;
	}

	public String toString(String separator) {
		String rightSpace1 = kindContext.size() == 0 ? "" : " ";
		String rightSpace2 = typeContext.size() == 0 ? "" : " ";
		return "< " + kindContext.toString(separator) + rightSpace1 + "> ( "
				+ typeContext.toString(separator) + rightSpace2 + ") : " + typeGrammar;
	}
	
	public void validate(CubexCompleteContext context) throws SemanticException{
		CubexCompleteContext copy = context.clone();
		copy.kindContext.addAll(kindContext.contextCollection);
		for (CubexTypeTuple tuple : getTypeContext().iterable()) {
			tuple.getTypeGrammar().validate(copy, true);
		}
		typeGrammar.validate(copy, true);
	}
	
	// replace generics for type scheme
	public CubexTypeScheme replaceParams(TypeContext cont) {
		CubexTypeGrammar gram = typeGrammar.replaceParams(cont);
		CubexList<CubexTypeTuple> list = new CubexList<CubexTypeTuple>();
		for (CubexTypeTuple i : typeContext.contextCollection) {
			list.add(new CubexTypeTuple(i.getName(), i.getTypeGrammar().replaceParams(cont)));
		}
		return new CubexTypeScheme(kindContext, list, gram);
	}
	
	public void replaceVars(HashMap<String, String> map) {
		for (CubexTypeTuple i : typeContext.contextCollection) {
			i.replaceVars(map);
		}
	}
}
