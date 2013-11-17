package parsingTokens.expressions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.IrGenerationContext;
import ir.IrType;
import ir.expressions.IrBinaryExpression;
import ir.expressions.IrExpression;
import ir.expressions.IrUnaryExpression;
import ir.expressions.IrVariableExpression;
import ir.program.IrTypeTuple;
import ir.statements.IrBind;


public abstract class CubexUnaryExpression extends CubexExpression {
	private CubexExpression mArgument;
	public String operator;
	public CubexTypeGrammar cubexType;
	
	public ArrayList<IrBind> getExpressions(IrGenerationContext context){
		ArrayList<IrBind> arr = mArgument.getExpressions(context);
		ArrayList<IrBind> ret  = new ArrayList<IrBind>();
		
		IrExpression var1;
		
		if(arr.size() == 0){
			var1 = mArgument.toIr(context);
		}
		else{
			IrBind bindRight = arr.get(arr.size()-1);
			var1 = new IrVariableExpression(bindRight.tuple.variableName, mArgument.type);
		}
		ret.addAll(arr);
		
		IrUnaryExpression e = new IrUnaryExpression(var1, operator, cubexType);
		IrType t = new IrType("void*");
		IrTypeTuple tt = new IrTypeTuple(t, context.nextTemp());
		IrBind b = new IrBind(tt, e, cubexContext);
		ret.add(b);

		return ret;
	}
	
	public CubexUnaryExpression(CubexExpression arg) {
		setmArgument(arg);
		type = mArgument.type;
	}
	public CubexExpression getmArgument() {
		return mArgument;
	}
	public void setmArgument(CubexExpression mArgument) {
		this.mArgument = mArgument;
	}
	
	public abstract IrUnaryExpression toIr(IrGenerationContext context);
	
	@Override
	public void getVars(Set<String> set) {
		mArgument.getVars(set);
	}
	
	@Override
	public void replaceVars(HashMap<String, String> map) {
		mArgument.replaceVars(map);
	}
}