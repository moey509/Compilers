package ir.program;

import ir.CGenerationContext;

import java.util.ArrayList;
import java.util.List;

public class IrStruct {
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
	
	public List<String> toC(CGenerationContext context){
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("typedef struct ");
		arr.add("{");
		arr.add("int refcount;");
		arr.add("char** funcName;");
		arr.add("functionPointer p;");
		arr.add(this.constructableComponent + "* constructableComponent;");
		for(IrTypeTuple t : structVariables){
			arr.add(t.type.declarationInStruct() + " " + t.variableName + ";");
		}
		
		arr.add("}" + structName + ";");
		
		return arr;
	}
}
