package parsingTokens.expressions;

import ir.expressions.IrExpression;
import ir.expressions.IrIterable;
import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;

public class CubexIterable extends CubexExpression {
	CubexList<CubexExpression> list;

	public CubexIterable(CubexList<CubexExpression> listIn) {
		list = listIn;
	}
	
	public IrIterable toIr(IrGenerationContext context) {
		CubexList<IrExpression> irE = new CubexList<IrExpression>();
		for (CubexExpression i : list.contextCollection) {
			irE.add(i.toIr(context));
		}
		return new IrIterable(irE);
	}

	public String toString() {
		String rightSpace = list.size() == 0 ? "" : " ";
		return "[ " + list.toString(",") + rightSpace + "]";
	}

	// Check if the expression is of some type
	public CubexTypeGrammar typeCheck(CubexCompleteContext c)
			throws SemanticException {
		CubexTypeGrammar type;
		CubexTypeGrammar joinedType = new CubexTypeClass("Nothing", new CubexList<CubexTypeGrammar>());
		for (int i = 0; i < list.size(); i++) {
			type = list.get(i).typeCheck(c);
			joinedType = type.join(c, joinedType);
		}
		CubexList<CubexTypeGrammar> iterableType = new CubexList<CubexTypeGrammar>();
		iterableType.add(joinedType);
		return new CubexTypeClass("Iterable", iterableType);
	}
}
