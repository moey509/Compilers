package parsingTokens.typeGrammar;

import java.util.ArrayList;

import typeChecker.CubexCompleteContext;
import typeChecker.TypeContext;
import Exception.SemanticException;

public class CubexTypeIntersection extends CubexTypeGrammar {
	public CubexTypeGrammar typeGrammar1;
	public CubexTypeGrammar typeGrammar2;

	public CubexTypeIntersection(CubexTypeGrammar typeGrammar1,
			CubexTypeGrammar typeGrammar2) {
		this.typeGrammar1 = typeGrammar1;
		this.typeGrammar2 = typeGrammar2;
	}

	@Override
	public String getName() throws SemanticException {
		throw new SemanticException("CubexTypeIntersection does not have name");
	}

	@Override
	public String toString() {
		return typeGrammar1.toString() + " & " + typeGrammar2.toString();
	}

	@Override
	public void validate(CubexCompleteContext c, boolean canBeClass) throws SemanticException {
		if (!typeGrammar1.join(c, typeGrammar2).getName().equals("Thing") )
				throw new SemanticException("Cannot extend two types that extend the same type");
		typeGrammar1.validate(c, false);
		typeGrammar2.validate(c, true);
	}

	public CubexTypeGrammar replaceParams(TypeContext cont) {
		CubexTypeGrammar t1 = typeGrammar1.replaceParams(cont);
		CubexTypeGrammar t2 = typeGrammar2.replaceParams(cont);
		return new CubexTypeIntersection(t1, t2);
	}

	public boolean equalType(CubexTypeGrammar t) throws SemanticException {
		if (t instanceof CubexTypeIntersection) {
			CubexTypeIntersection t1 = (CubexTypeIntersection) t;
			return typeGrammar1.equalType(t1.typeGrammar1)
					&& typeGrammar2.equalType(t1.typeGrammar2);
		}
		return false;
	}

	public ArrayList<CubexTypeClass> joinHelper(CubexCompleteContext c,
			CubexTypeGrammar t, ArrayList<CubexTypeClass> a)
			throws SemanticException {
		ArrayList<CubexTypeClass> arr1 = typeGrammar1.joinHelper(c, t, a);
		return typeGrammar2.joinHelper(c, t, arr1);
	}
}
