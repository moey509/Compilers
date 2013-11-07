package ir.program;

import java.util.ArrayList;
import java.util.List;

import ir.CGenerationContext;
import ir.IrType;
import ir.expressions.IrExpression;
import ir.statements.IrBind;
import ir.statements.IrStatement;

public class IrFunction {
	public IrType type;
	public String object;
	public String functionName;
	public List<IrTypeTuple> arguments;
	public List<IrStatement> statements;
	public IrExpression superCall;
	public boolean isConstructor = false;
	ArrayList<IrBind> tempVariables = new ArrayList<IrBind>();

	public IrFunction(IrType type, String object, String functionName) {
		this.type = type;
		this.object = (object == null) ? "" : object;
		this.functionName = functionName;
		this.arguments = new ArrayList<IrTypeTuple>();
		this.statements = new ArrayList<IrStatement>();
	}

	public IrFunction(IrType type, String functionName) {
		this.type = type;
		this.object = "";
		this.functionName = functionName;
		this.arguments = new ArrayList<IrTypeTuple>();
		this.statements = new ArrayList<IrStatement>();
	}

	public void addFunctionArgument(IrTypeTuple argument) {
		arguments.add(argument);
	}

	public void addStatement(IrStatement statement) {
		ArrayList<IrBind> binds = statement.getTemporaryVariables();
		tempVariables.addAll(binds);
		statements.add(statement);
	}
	
	public void addSuperCall(IrExpression expression){
		superCall = expression;
	}
	//TODO: Can structs and functions have the same name
	public ArrayList<String> toC(CGenerationContext context) {
		//Declaration
		ArrayList<String> arr = new ArrayList<String>();
		String s = type.toC() + " " + functionName + "(";
		boolean firstElement = true;
		for(IrTypeTuple t : arguments){
			if(firstElement){
				s += t.type.toC() + " " + t.variableName;
				firstElement = false;
			}
			else{
				s += ", " + t.type.toC() + " " + t.variableName;
			}
		}
		s += "){";
		arr.add(s);
		
		for(IrBind b : tempVariables){
			arr.add(b.tuple.type.type + " " + b.tuple.variableName + ";");
		}
		
		if(isConstructor){
			s = type.toC() + " __struct = (" + type.toC() + ")(x3malloc(sizeof(struct" + type.toC().substring(0, type.toC().length()-2) + ")));";
			arr.add(s);
			arr.add("__struct->ref_count = 0;");
			for(IrTypeTuple t : arguments){
				if(firstElement){
					s += t.type.toC() + " " + t.variableName;
					firstElement = false;
				}
				else{
					s += ", " + t.type.toC() + " " + t.variableName;
				}
			}
		}
		
		if(isConstructor){
			for(IrTypeTuple t : arguments){
				arr.add("__struct->" + t.variableName + " = NULL;");
			}
		}
		
		for(IrStatement st : statements){
			System.out.println(st.toC(context));
			arr.addAll(st.toC(context));
		}
		if(superCall != null){
			arr.add("__struct->con_comp = " + superCall.toC(context) + ";");
			arr.add("__struct->con_comp->ref_count = 1;");
		}
		if(isConstructor){
			arr.add("return __struct;");
		}
		arr.add("}");
		return arr;
	}

	public void addConstructorStatement(IrBind irBind) {
		
	}
}
