package ir.expressions;

import ir.CGenerationContext;
import ir.IrType;
import ir.statements.IrBind;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import optimization.CseContext;
import parsingTokens.typeGrammar.CubexTypeGrammar;


public final class IrFunctionCall implements IrExpression {
	public String functionName;	
	public List<IrExpressionTuple> arguments;
	private String cType;	
	private CubexTypeGrammar cubexType;
	
	public ArrayList<IrExpression> functions = new ArrayList<IrExpression>();
	
	
	
	public IrFunctionCall(String functionName, String type, CubexTypeGrammar cubexType) {
		this.functionName = functionName;
		this.arguments = new ArrayList<IrExpressionTuple>();
		this.cType = type;
		this.cubexType = cubexType;
	}

	public void addArgument(IrType argType, IrExpression argument){
		this.arguments.add(new IrExpressionTuple(argType, argument));
	}
	
	public void addArgument(String argType, IrExpression argument){
		this.arguments.add(new IrExpressionTuple(new IrType(argType), argument));
	}

	public String getCType () {
		return cType;
	}
	
	public List<IrExpressionTuple> getArugments() {
		return this.arguments;
	}
	
	public ArrayList<IrBind> getExpressions(CGenerationContext context){
		ArrayList<IrBind> arr = new ArrayList<IrBind>();
		for(IrExpressionTuple tuple : arguments){
			arr.addAll(tuple.expression.getExpressions(context));
		}
		return arr;
	}
	
	public String toC(CGenerationContext context) {
		boolean firstTime = true;
		StringBuilder sb = new StringBuilder();
		ArrayList<IrBind> arr = getExpressions(context);
		for(int i = 0; i < arr.size(); i++){
			if(arr.get(i) != null){
				//System.out.println(arr.get(i).toC(context));
			}
		}
		for (IrExpressionTuple tuple : arguments){
			if(firstTime){
				firstTime = false;
				if(tuple.expression instanceof IrIterableComp){
					IrIterableComp comp = (IrIterableComp) tuple.expression;
					sb.append("(" + tuple.argType.toC() + ") " + comp.comprehension.getComprehensionName() + "_getNext(" + comp.comprehension.getStructVariableName() + ")");
				}
				else{
					sb.append("(" + tuple.argType.toC() + ") " + tuple.expression.toC(context));
				}
			}
			else{
				if(tuple.expression instanceof IrIterableComp){
					IrIterableComp comp = (IrIterableComp) tuple.expression;
					sb.append(", (" + tuple.argType.toC() + ") " + comp.comprehension.getComprehensionName() + "_getNext(" + comp.comprehension.getStructVariableName() + ")");
				}
				else{
					sb.append(", (" + tuple.argType.toC() + ") " + tuple.expression.toC(context));
				}
				sb.append(", (" + tuple.argType.toC() + ") " + tuple.expression.toC(context));
			}
		}
		
		return functionName + "(" + sb.toString() + ")" ;
	}

	@Override
	public CubexTypeGrammar getCubexType() {
		return cubexType;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (IrExpressionTuple tuple : arguments){
			if (first){
				first = false;
				sb.append(tuple.getExpression().toString());	
			}
			else {
				sb.append(", " + tuple.getExpression().toString());
			}
		}
		
		return functionName + "(" + sb.toString() + ")";
	}

	@Override
	public void getVars(Set<String> set, Map<String, Set<String>> map) {
		// TODO: FIX
		for (IrExpressionTuple e : arguments) {
			e.expression.getVars(set, map);
		}
		
		if (map.containsKey(functionName)) {
			set.addAll(map.get(functionName));
		}
		return;
	}
	
	public boolean equals(Object object){
		if (object instanceof IrFunctionCall){
			IrFunctionCall expr = (IrFunctionCall) object;
			if (!functionName.equals(expr.functionName)){
				return false;
			}
			Iterator<IrExpressionTuple> iter1 = arguments.iterator();
			Iterator<IrExpressionTuple> iter2 = expr.arguments.iterator();
			while (iter1.hasNext() && iter2.hasNext()){
				if (!iter1.next().expression.equals(iter2.next().expression)){
					return false;
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public int hashCode(){
		return toString().hashCode();
	}

	@Override
	public IrExpression eliminateSubexpression(CseContext context) {
		IrExpression expr = getSubexpressions(context);
		if (context.containsExpression(expr)){
			return context.getVariableExpression(expr);
		} else {
			for (IrExpressionTuple tuple : arguments){
				tuple.expression = tuple.expression.eliminateSubexpression(context);
			}
			return this;
		}
	}

	@Override
	public IrExpression getSubexpressions(CseContext context) {
		IrFunctionCall output = new IrFunctionCall(functionName, cType, cubexType);
		for (IrExpressionTuple tuple : arguments){
			output.addArgument(tuple.argType, tuple.expression.getSubexpressions(context));
		}
		return output;
	}
	
	public IrExpression clone(){
		IrFunctionCall output = new IrFunctionCall(functionName, cType, cubexType);
		for (IrExpressionTuple tuple : arguments){
			output.addArgument(new IrType(tuple.argType.type), tuple.expression.clone());
		}
		return output;
	}
}


