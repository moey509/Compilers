package parsingTokens.expressions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import ir.IrType;
import ir.expressions.IrAppend;
import ir.expressions.IrExpression;
import ir.expressions.IrVariableExpression;
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
	CubexTypeGrammar cubexType;
	CubexCompleteContext cubexContext;

	public CubexAppend(CubexExpression expr1, CubexExpression expr2) {
		e1 = expr1;
		e2 = expr2;
		type = "Iterable";
	}
	
	public ArrayList<IrBind> getExpressions(IrGenerationContext context){
		//Get temporary binds 
		ArrayList<IrBind> tempe1 = e1.getExpressions(context);
		ArrayList<IrBind> tempe2 = e2.getExpressions(context);
		
		//Get the last assignment. This will be the variables that are input into the append function
		//If temporary variable assigned, create variableExpression as the input to an IrAppend
		IrExpression vare1;
		IrExpression vare2;
		if(tempe1.size() > 0){
			IrBind binde1 = tempe1.get(tempe1.size()-1);
			vare1 = new IrVariableExpression(binde1.tuple.variableName);
		}
		else{
//			System.out.println("tempe1: " + this);
			vare1 = e1.toIr(context);
		}
		if(tempe2.size() > 0){
			IrBind binde2 = tempe2.get(tempe2.size()-1);		
			vare2 = new IrVariableExpression(binde2.tuple.variableName);
		}
		else{
			vare2 = e2.toIr(context);
		}
		
		//Create a bind for the result of the append
		IrAppend app = new IrAppend(vare1, vare2, cubexType);
		IrType t = new IrType("void*");
		IrTypeTuple tt = new IrTypeTuple(t, context.nextTemp());
		IrBind b = new IrBind(tt, app, cubexContext);
		ArrayList<IrBind> arr = new ArrayList<IrBind>();
		
		//Add all temporary variables
		arr.addAll(tempe1);
		arr.addAll(tempe2);
		arr.add(b);
		return arr;
	}
	
	public IrAppend toIr(IrGenerationContext context) {
		return new IrAppend(e1.toIr(context), e2.toIr(context), cubexType);
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
		
		
		cubexType = e1Type.join(c,e2Type);
		cubexContext = c.clone();
		return cubexType;
	}
	
	@Override
	public void getVars(Set<String> set){
		e1.getVars(set);
		e2.getVars(set);
	}
			
	@Override
	public void replaceVars(HashMap<String, String> map){
		e1.replaceVars(map);
		e2.replaceVars(map);
	}
	
	public boolean equals(CubexAppend expr){
		return e1.equals(expr.e1) && e2.equals(expr.e2);
	}
	
	public int hashCode(){
		return toString().hashCode();
	}
}
