package parsingTokens.expressions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.IrGenerationContext;
import ir.IrType;
import ir.expressions.IrBinaryExpression;
import ir.expressions.IrExpression;
import ir.expressions.IrVariableExpression;
import ir.program.IrTypeTuple;
import ir.statements.IrBind;


public abstract class CubexBinaryExpression extends CubexExpression {
	private CubexExpression mLeft, mRight;
	public CubexTypeGrammar cubexType;
	public String operator;
	
	public ArrayList<IrBind> getExpressions(IrGenerationContext context){
		ArrayList<IrBind> arr1 = mLeft.getExpressions(context);
		ArrayList<IrBind> arr2 = mRight.getExpressions(context);
		ArrayList<IrBind> ret  = new ArrayList<IrBind>();
		
		IrExpression var1;
		IrExpression var2;
		if(arr1.size() == 0){
			var1 = mLeft.toIr(context);
		}
		else{
			IrBind bindRight = arr1.get(arr1.size()-1);
			var1 = new IrVariableExpression(bindRight.tuple.variableName, mLeft.type);
		}
		if(arr2.size() == 0){
			var2 = mRight.toIr(context);
		}
		else{
			IrBind bindLeft = arr2.get(arr2.size()-1);
			var2 = new IrVariableExpression(bindLeft.tuple.variableName, mRight.type);
		}
		ret.addAll(arr1);
		ret.addAll(arr2);
		IrBinaryExpression e = new IrBinaryExpression(var1, var2, operator, cubexType);
		IrType t = new IrType("void*");
		IrTypeTuple tt = new IrTypeTuple(t, context.nextTemp());
		IrBind b = new IrBind(tt, e, cubexContext);
		ret.add(b);
		return ret;
	}
	
	public CubexBinaryExpression(CubexExpression left, CubexExpression right) {
		setmLeft(left);
		setmRight(right);
	}
	public CubexExpression getmLeft() {
		return mLeft;
	}
	public void setmLeft(CubexExpression mLeft) {
		this.mLeft = mLeft;
	}
	public CubexExpression getmRight() {
		return mRight;
	}
	public void setmRight(CubexExpression mRight) {
		this.mRight = mRight;
	}
	
	public abstract IrBinaryExpression toIr(IrGenerationContext context);
	
	@Override
	public void getVars(Set<String> s) {
		mLeft.getVars(s);
		mRight.getVars(s);
	}
	
	@Override
	public void replaceVars(HashMap<String, String> map) {
		mLeft.replaceVars(map);
		mRight.replaceVars(map);
	}
	public boolean equals(CubexBinaryExpression expr){
		return mLeft.equals(expr.mLeft) && mRight.equals(expr.mRight) && operator.equals(expr.operator);
	}
	
	public int hashCode(){
		return toString().hashCode();
	}
}