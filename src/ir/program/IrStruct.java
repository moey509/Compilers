package ir.program;

import ir.CGenerationContext;

import java.util.ArrayList;
import java.util.List;

public class IrStruct {
	public String structName;
	public List<IrTypeTuple> structVariables;

	public IrStruct(String structName){
		this.structName = structName;
		this.structVariables = new ArrayList<IrTypeTuple>();
	}
	
	public void addStructVariable(IrTypeTuple variable){
		structVariables.add(variable);
	}
	
	public List<String> toC(CGenerationContext context){
		return null;
	}
}
