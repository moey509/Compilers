package ir.program;

import ir.CGenerationContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import optimization.CseContext;

public class IrComprehensionStruct implements IrProgramElem {
	public String structName;
	public String nestedComprehension;
	public List<IrTypeTuple> structVariables;
	
	public IrComprehensionStruct(String structName, String nestedComprehension){
		this.structName = structName;
		this.nestedComprehension = nestedComprehension;
		this.structVariables = new ArrayList<IrTypeTuple>();
	}
	
	public void addStructVariable(IrTypeTuple variable){
		structVariables.add(variable);
	}
	
	public ArrayList<String> toC(CGenerationContext context, boolean isMain, ArrayList<String> extras){
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("typedef struct " + structName + "* "	+ structName + "_t;");
		arr.add("struct " + structName);
		arr.add("{");
		arr.add("int ref_count;");
		if(this.nestedComprehension == null){
			arr.add("General_t _nest_comp;");
		}else{
			arr.add(this.nestedComprehension + "_t _nest_comp;");
		}
		arr.add("git_t _iterable;");
		arr.add("iterator_t _iterator;");
		arr.add("int hasEvaluatedOnce;");
		arr.add("int evaluatedValue;");
		Set<String> varSet = new HashSet<String>();
		for(IrTypeTuple t : structVariables){
			arr.add(t.type.declarationInStruct() + " " + t.variableName + ";");
			varSet.add(t.variableName);
		}
		//context.objectToDataMap.put(structName, varSet);
		
		arr.add("};");
		
		return arr;
	}

	@Override
	public void removeCommonSubexpressions(CseContext context) {
		// TODO Auto-generated method stub
		
	}
}
