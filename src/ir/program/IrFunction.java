package ir.program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import optimization.LvaContext;
import optimization.CseContext;
import ir.CGenerationContext;
import ir.IrType;
import ir.expressions.IrExpression;
import ir.statements.IrBind;
import ir.statements.IrStatement;

public class IrFunction implements IrProgramElem{
	public IrType type;
	public String object;
	public String functionName;
	public List<IrTypeTuple> arguments;
	public List<IrStatement> statements;
	public List<String> vTableFunctionNames;
	public IrExpression superCall;
	public boolean isConstructor = false;
	ArrayList<IrBind> tempVariables = new ArrayList<IrBind>();

	public boolean isToplevel;

	public IrFunction(IrType type, String object, String functionName) {
		this.type = type;
		this.object = (object == null) ? "" : object;
		this.isToplevel = (this.object.equals("")) ? true : false;
		this.functionName = functionName;
		this.arguments = new ArrayList<IrTypeTuple>();
		this.statements = new ArrayList<IrStatement>();
		this.vTableFunctionNames = new ArrayList<String>();
	}

	public IrFunction(IrType type, String functionName) {
		this.type = type;
		this.object = "";
		this.functionName = functionName;
		this.arguments = new ArrayList<IrTypeTuple>();
		this.statements = new ArrayList<IrStatement>();
		this.vTableFunctionNames = new ArrayList<String>();
	}

	public void addFunctionArgument(IrTypeTuple argument) {
		arguments.add(argument);
	}

	public void addStatement(IrStatement statement) {
		ArrayList<IrBind> binds = statement.getTemporaryVariables();
		tempVariables.addAll(binds);
		statements.add(statement);
	}
	
	public void addVTableFunctionName(String functionName){
		vTableFunctionNames.add(functionName);
	}
	
	public void addSuperCall(IrExpression expression){
		superCall = expression;
	}
	//TODO: Can structs and functions have the same name
	public ArrayList<String> toC(CGenerationContext context, boolean isMain) {
		context.varDecl = new HashMap<String, String>();
		context.varInit = new HashMap<String, String>();
		//Declaration
		ArrayList<String> arr = new ArrayList<String>();
		
		String s = "void* ";
		if (object != "" && object != null){
			s = s + "_" + object;
		}
		s = s + "_" + functionName + "(";
		
		HashSet<String> tempVarSet = new HashSet<String>();
		HashSet<String> argumentNames = new HashSet<String>();
		boolean firstElement = true;
		for(IrTypeTuple t : arguments){
			argumentNames.add(t.variableName);
			tempVarSet.add(t.variableName);
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
			tempVarSet.add(b.tuple.variableName);
		}
		
		ArrayList<String> postarr = new ArrayList<String>();
		
		// if constructor, make first malloc struct for super
		if(isConstructor){
			s = " __struct = (" + type.toC() + ")(x3malloc(sizeof(struct " + type.toC().substring(0, type.toC().length()-2) + ")));";
			postarr.add(s);
			postarr.add("__struct->ref_count = 0;");
			postarr.add("__struct->fun_names = NULL;");
			postarr.add("__struct->fun_length = 0;");
			postarr.add("__struct->fun_ptrs = NULL;");
			postarr.add("__struct->con_comp = NULL;");
			postarr.add("__struct->is_iter = 0;");
			postarr.add("__struct->is_thru_ward = 0;");


			int counter = 0;
			postarr.add("__struct->fun_ptrs = (functionPointer*) x3malloc(sizeof(functionPointer) * " + (vTableFunctionNames.size()+1) + ");");
			postarr.add("__struct->fun_names = (char**) x3malloc(sizeof(char*) * " + (vTableFunctionNames.size()+1) + ");");
			postarr.add("__struct->fun_length = " + (vTableFunctionNames.size() + 1) + ";");
			for (String str : vTableFunctionNames){
				postarr.add("__struct->fun_names[" + counter + "] = (char*) x3malloc(sizeof(char) * " + (str.length() + 1) + ");");
				postarr.add("__struct->fun_ptrs[" + counter + "] = &" + str + ";");
				//postarr.add("__struct->fun_names[" + counter + "] = \"" + str + "\";");
				//memery_kopee("_Multiplier_print\0", __struct->fun_names[0], 18);
				postarr.add("memery_kopee(\"" + str + "\", __struct->fun_names[" + counter + "], " + (str.length() + 1) + ");");
				counter++;
			}
			postarr.add("__struct->fun_names[" + counter + "] = (char*) x3malloc(sizeof(char) * " + ("__kill".length() + 1) + ");");
			postarr.add("__struct->fun_ptrs[" + counter + "] = &" + "__kill_" + type.toC().substring(0, type.toC().length()-2) + ";");
			//postarr.add("__struct->fun_names[" + counter + "] = \"" + "__kill" + "\";");
			postarr.add("memery_kopee(\"" + "__kill" + "\", __struct->fun_names[" + counter + "], " + ("__kill".length() + 1) + ");");
					
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
				postarr.add("__struct->" + t.variableName + " = NULL;");
			}
		}
		
		context.currentObject = object;
		for(IrStatement st : statements){
//			System.out.println(st.toC(context));
			postarr.addAll(st.toC(context, false));
		}

		context.currentObject = null;
		
		if (isConstructor){
			arr.add(type.toC() + " __struct;");
		}
		
		// add binding vars to the output, add everything above (postarr) to the output
		for (String str : context.varDecl.keySet()) {
			if (!tempVarSet.contains(str)) {
				if (!isConstructor)
					arr.add(context.varDecl.get(str) + " " + str + ";");
//				arr.add("void* " + str + ";");
			}
		}
		for (String str : context.varInit.keySet()) {
			boolean isStruct = str.contains("__struct->");
			if (!isStruct && !argumentNames.contains(str)) arr.add(str + " = " + context.varInit.get(str) + ";");
		}
		arr.addAll(postarr);
		
		if(superCall != null){
			arr.add("__struct->con_comp = _" + superCall.toC(context) + ";");
			arr.add("__struct->con_comp->ref_count = 1;");
		}
		if(isConstructor){
			arr.add("return __struct;");
		}
		arr.add("}");
		return arr;
	}
	
	public String topDeclaration(){
		String s = "void* ";
		if (object != "" && object != null){
			s = s + "_" + object;
		}
		s = s + "_" + functionName + "(";
		
		HashSet<String> tempVarSet = new HashSet<String>();
		boolean firstElement = true;
		for(IrTypeTuple t : arguments){
			tempVarSet.add(t.variableName);
			if(firstElement){
				s += t.type.toC() + " " + t.variableName;
				firstElement = false;
			}
			else{
				s += ", " + t.type.toC() + " " + t.variableName;
			}
		}
		s += ");";
		return s;
	}

	public void addConstructorStatement(IrBind irBind) {
		
	}

	@Override
	public void removeCommonSubexpressions(CseContext context) {
		for (IrStatement statement : statements){
			statement.removeCommonSubexpressions(context);
		}
		
	}
}
