package parsingTokens.expressions;

import java.util.ArrayList;
import java.util.Set;

import ir.IrType;
import ir.expressions.IrExpression;
import ir.expressions.IrIterable;
import ir.expressions.IrVariableExpression;
import ir.program.IrTypeTuple;
import ir.statements.IrBind;
import ir.statements.IrStatement;
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
		type = "Iterable";
	}
	
	public ArrayList<IrBind> getExpressions(IrGenerationContext context){
		ArrayList<IrBind> arr = new ArrayList<IrBind>();
		ArrayList<IrBind> tempBinds = new ArrayList<IrBind>();
		ArrayList<IrBind> params = new ArrayList<IrBind>();
		for(CubexExpression e : list.contextCollection){
			params = e.getExpressions(context);
			if(params.size() == 0){
				IrType t = new IrType("git_t");
				IrTypeTuple tuple = new IrTypeTuple(t, e.toString());
				tempBinds.add(new IrBind(tuple, new IrVariableExpression(tuple.variableName, tuple.type.type)));
			}
			//Throw in a temporary variable
			else{
				System.out.println("In the else: " + this);
				tempBinds.add(params.get(params.size()-1));
			}
			arr.addAll(params);
		}
		if(arr.size() == 0){
			IrType t = new IrType("git_t");
			IrTypeTuple tuple = new IrTypeTuple(t, context.nextTemp());
			IrBind b = new IrBind(tuple, this.toIr(context));
			arr.add(b);
			return arr;
		}
		else{
			CubexList<IrExpression> irE = new CubexList<IrExpression>();
			for (IrBind s : tempBinds) {
				irE.add(new IrVariableExpression(s.tuple.variableName, s.tuple.type.type));
			}
			IrIterable iterable = new IrIterable(irE);
			IrType t = new IrType("git_t");
			IrTypeTuple tuple = new IrTypeTuple(t, context.nextTemp());
			IrBind b = new IrBind(tuple, iterable);
			arr.add(b);
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
