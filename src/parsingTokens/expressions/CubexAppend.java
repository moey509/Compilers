package parsingTokens.expressions;

import ir.IrGenerationContext;
import ir.expressions.IrAppend;
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
	
	public IrAppend toIr(IrGenerationContext context) {
		return new IrAppend(e1.toIr(context), e2.toIr(context));
	}

	public String toString() {
		return e1.toString() + " ++ " + e2.toString();
	}
	
	public CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException{
		CubexTypeGrammar e1Type = e1.typeCheck(c);
		CubexTypeGrammar e2Type = e2.typeCheck(c);
		CubexTypeGrammar join = e1Type.join(c, e2Type);
		
		CubexList<CubexTypeGrammar> nothingList = new CubexList<CubexTypeGrammar>();
		nothingList.add(new CubexTypeClass("Nothing", new CubexList<CubexTypeGrammar>()));
		CubexTypeClass nothing = new CubexTypeClass("Iterable", nothingList);
		
		//To get an iterable of something or if thats not possible, Thing which does not type check
		join = join.join(c, nothing);
		
		//Join must have type iterable
		CubexTypeClass tempClass = new CubexTypeClass("Iterable", new CubexList<CubexTypeGrammar>());
		if (!(join.name.equals("Iterable")) && !(join.isSuperTypeOf(c, tempClass))){
			System.out.println(join);
			throw new SemanticException("Must append arguments of type Iterable");
		}
//		CubexList<CubexTypeGrammar> list = e1Type.getTypeList();
//		CubexList<CubexTypeGrammar> list2 = e2Type.getTypeList();
//		
//		CubexList<CubexTypeGrammar> output = new CubexList<CubexTypeGrammar>();
//		output.add(list.get(0).join(c, list2.get(0)));
//		return new CubexTypeClass("Iterable", output);

		return e1Type.join(c,e2Type);
	}
}
