package parsingTokens.expressions;

import java.util.ArrayList;
import java.util.Set;

import ir.IrType;
import ir.expressions.IrAppend;
import ir.program.IrTypeTuple;
import ir.statements.IrBind;
import parsingTokens.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;
import Exception.SemanticException;

public class CubexAppend extends CubexExpression {
	CubexExpression e1, e2;

	public CubexAppend(CubexExpression expr1, CubexExpression expr2) {
		e1 = expr1;
		e2 = expr2;
		type = "Iterable";
	}
	
	public ArrayList<IrBind> getExpressions(IrGenerationContext context){
		IrType t = new IrType("void* ");
		IrTypeTuple tt = new IrTypeTuple(t, context.nextTemp());
		IrBind b = new IrBind(tt, this.toIr(context));
		ArrayList<IrBind> arr = new ArrayList<IrBind>();
		arr.add(b);
		return arr;
	}
	
	public IrAppend toIr(IrGenerationContext context) {
		IrAppend ir = new IrAppend(e1.toIr(context), e2.toIr(context));
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
		CubexList<CubexTypeGrammar> thingList = new CubexList<CubexTypeGrammar>();
		thingList.add(new CubexTypeClass("Thing", new CubexList<CubexTypeGrammar>()));
		
		//To get an iterable of something or if thats not possible, Thing which does not type check
		join = join.join(c, nothing);
		
		//Join must have type iterable
		CubexTypeClass thingClass = new CubexTypeClass("Iterable", thingList);
		if (!thingClass.isSuperTypeOf(c, join)){
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
	
	@Override
	public void getVars(Set<String> set){
		e1.getVars(set);
		e2.getVars(set);
	}
}
