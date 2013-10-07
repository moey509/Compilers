package parsingTokens.expressions;

import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import Exception.SemanticException;

public class CubexAppend extends CubexExpression {
	CubexExpression e1, e2;

	public CubexAppend(CubexExpression expr1, CubexExpression expr2) {
		e1 = expr1;
		e2 = expr2;
	}

	public String toString() {
		return e1.toString() + " ++ " + e2.toString();
	}

	// Check if the expression is of some type
	public CubexTypeGrammar typeCheck(CubexCompleteContext c, CubexTypeGrammar t)
			throws SemanticException {
		//
		// TODO: Implement type intersection
		//
		CubexList<CubexTypeGrammar> iterableType = new CubexList<CubexTypeGrammar>();
		CubexTypeGrammar e1Type = e1.typeCheck(c, t);
		CubexTypeGrammar e2Type = e2.typeCheck(c, t);
		if (!(e1Type.getName().equals("Iterable") && e2Type.getName().equals("Iterable"))){
			throw new SemanticException("Must append arguments of type Iterable");
		}
		iterableType.add(e1Type.equals(e2Type) ? e1Type
						: new CubexTypeClass("Thing",
								new CubexList<CubexTypeGrammar>()));

		return new CubexTypeClass("Iterable", iterableType);
	}

	public CubexTypeGrammar typeCheck(CubexCompleteContext c, CubexTypeClass t)
			throws SemanticException {
		//
		// TODO: Implement type intersection
		//
		CubexList<CubexTypeGrammar> iterableType = new CubexList<CubexTypeGrammar>();
		CubexTypeGrammar e1Type = e1.typeCheck(c, t);
		CubexTypeGrammar e2Type = e2.typeCheck(c, t);
		if (!(e1Type.getName().equals("Iterable") && e2Type.getName().equals("Iterable"))){
			throw new SemanticException("Must append arguments of type Iterable");
		}
		iterableType.add(e1Type.equals(e2Type) ? e1Type
						: new CubexTypeClass("Thing",
								new CubexList<CubexTypeGrammar>()));

		return new CubexTypeClass("Iterable", iterableType);
	}

	// Check if the expression is of some list of types
	public CubexTypeGrammar typeCheck(CubexCompleteContext c,
			CubexList<CubexTypeGrammar> t) throws SemanticException {
		//
		// TODO: Implement type intersection
		//
		CubexList<CubexTypeGrammar> iterableType = new CubexList<CubexTypeGrammar>();
		CubexTypeGrammar e1Type = e1.typeCheck(c, t);
		CubexTypeGrammar e2Type = e2.typeCheck(c, t);
		if (!(e1Type.getName().equals("Iterable") && e2Type.getName().equals("Iterable"))){
			throw new SemanticException("Must append arguments of type Iterable");
		}
		iterableType.add(e1Type.equals(e2Type) ? e1Type
						: new CubexTypeClass("Thing",
								new CubexList<CubexTypeGrammar>()));

		return new CubexTypeClass("Iterable", iterableType);
	}
}
