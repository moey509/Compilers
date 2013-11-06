package parsingTokens.expressions;

import java.util.ArrayList;
import java.util.Set;

import ir.IrType;
import ir.expressions.IrExpression;
import ir.expressions.IrIterable;
import ir.program.IrTypeTuple;
import ir.statements.IrBind;
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
	
	public ArrayList<IrBind> getExpressions(IrGenerationContext context){
		System.out.println("ITERABLE getExpression");
		ArrayList<IrBind> arr = new ArrayList<IrBind>();
		for(CubexExpression e : list.contextCollection){
			System.out.println("Expressions string: " + e.toString());
			arr.addAll(e.getExpressions(context));
			System.out.println("Size of array: " + arr.size());
		}
		if(arr.size() == 0){
			IrType t = new IrType("void*");
			IrTypeTuple tuple = new IrTypeTuple(t, context.nextTemp());
			IrBind b = new IrBind(tuple, this.toIr(context));
			arr.add(b);
			return arr;
		}
		else{
			return arr;
		}
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
	
	@Override
	public void getVars(Set<String> set){
		for (CubexExpression e : list.contextCollection) {
			e.getVars(set);
		}
	}
}
