package ir.program;

import ir.CGenerationContext;

import java.util.ArrayList;
import java.util.List;

public class IrStruct implements IrProgramElem{
	public String structName;
	public String constructableComponent;
	public List<IrTypeTuple> structVariables;

	public IrStruct(String structName, String constructableComponent){
		this.structName = structName;
		this.constructableComponent = constructableComponent;
		this.structVariables = new ArrayList<IrTypeTuple>();
	}
	
	public void addStructVariable(IrTypeTuple variable){
		structVariables.add(variable);
	}
	
	public ArrayList<String> toC(CGenerationContext context, boolean isMain){
		/*
		 * int ref_count;
  char** fun_names;
  int fun_length;
  char** fun_ptrs;
  int ptr_length;
  void* con_comp;
  int is_iter;
  int is_thru_ward;
		 */
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("typedef struct " + structName + "* "	+ structName + "_t;");
		arr.add("struct " + structName);
		arr.add("{");
		arr.add("int ref_count;");
		arr.add("char** fun_names;");
		arr.add("int fun_length;");
		arr.add("functionPointer** fun_ptrs;");
		arr.add("int ptr_length;");
		if(this.constructableComponent.equals("Thing")){
			arr.add("General_t con_comp;");
		}else{
			arr.add(this.constructableComponent + "_t con_comp;");
		}
		arr.add("int is_iter;");
		arr.add("int is_thru_ward;");
		for(IrTypeTuple t : structVariables){
			arr.add(t.type.declarationInStruct() + " " + t.variableName + ";");
		}
		
		arr.add("};");
		
		return arr;
	}
}
