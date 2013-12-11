package parsingTokens.comprehension;

import ir.comp.IrComprehension;
import ir.comp.IrComprehensionFor;

import java.util.HashMap;
import java.util.Set;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.statements.CubexBind;
import parsingTokens.statements.CubexStatement;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import parsingTokens.typeGrammar.CubexTypeName;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;

public class CompFor extends Comp {
	private String v;
	public String structName;
	
	CubexTypeGrammar cubexType;
//	private Set<String> freeContext;
	
	public CompFor(String v, CubexExpression e, Comp c) {
		this.v = v;
		this.e = e;
		this.comp = c;
	}

	public String toString() {
		return "for ( " + v + " in " + e.toString() + " ) " + comp.toString();
	}

	@Override
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException {
		for(String s : c.mutableTypeContext.keySet()){
			CubexTypeGrammar g = c.mutableTypeContext.get(s);
			varList.put(s, g);
		}
		CubexTypeGrammar exprType = e.typeCheck(c);
		CubexList<CubexTypeGrammar> tempList = new CubexList<CubexTypeGrammar>();
		tempList.add(new CubexTypeName("Thing"));
		if (!(new CubexTypeClass("Iterable", tempList)).isSuperTypeOf(c, exprType)){
			throw new SemanticException(e.toString() + " must be of type Iterable");
		}
		if (c.typeContext.containsKey(v) && !c.mutableTypeContext.containsKey(v)){
			System.out.println(c.mutableTypeContext);
			System.out.println(c.typeContext);
			throw new SemanticException(v + " is a variable that has already been declared");
		}
		CubexCompleteContext c1 = c.clone();
		c1.typeContext.put(v, exprType.getTypeList().get(0));
		//System.out.println(c1.toString());
		cubexType = comp.typeCheck(c1);
		return cubexType;
	}

	@Override
	public void getVars(Set<String> set) {
		set.add(v);
		e.getVars(set);
		if (comp!=null) {
			comp.getVars(set);
		}
	}

	@Override
	public void replaceVars(HashMap<String, String> map) {
		if (map.containsKey(v)) {
			v = map.get(v);
		}
		e.replaceVars(map);
		if (comp!=null) {
			comp.replaceVars(map);
		}
	}

	@Override
	public IrComprehension toIr(IrGenerationContext context, HashMap<String, CubexTypeGrammar> extras) {
		extras.put(v, cubexType);
		IrComprehension c = comp.toIr(context, extras);
		addStruct(context, c.getComprehensionName(), extras);
		nestedComprehensionName = c.getComprehensionName();
		System.out.println(comp.toIr(context, extras));
		return new IrComprehensionFor(comp.toIr(context, extras), e.toIr(context), v, cubexType, comprehensionName, nestedComprehensionName, varList);
	}
	
	
}
