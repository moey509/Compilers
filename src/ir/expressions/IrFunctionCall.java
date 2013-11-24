package ir.expressions;

import ir.CGenerationContext;
import ir.IrType;
import ir.statements.IrBind;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import parsingTokens.typeGrammar.CubexTypeGrammar;


public final class IrFunctionCall implements IrExpression {
	private String functionName;	
	private List<IrExpressionTuple> arguments;
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
				sb.append("(" + tuple.argType.toC() + ") " + tuple.expression.toC(context));
			}
			else{
				sb.append(", (" + tuple.argType.toC() + ") " + tuple.expression.toC(context));
			}
		}
		
		if (functionName.equals("_string")) {
			return sb.toString();
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
}


