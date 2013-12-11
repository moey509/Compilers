package ir.comp;

import java.util.ArrayList;
import java.util.HashMap;

import ir.CGenerationContext;
import ir.expressions.IrExpression;
import ir.statements.IrBind;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.IrGenerationContext;

public class IrComprehensionIf implements IrComprehension{
	public IrComprehension comp;
	public IrExpression expression;
	
	public String comprehensionName;
	public String nestedComprehensionName;
	public String structVariableName;
	public HashMap<String, CubexTypeGrammar> varList;
	
	public CubexTypeGrammar cubexType;
	public String cType;
	
	public IrComprehensionIf(IrComprehension comp, IrExpression expression,
			CubexTypeGrammar cubexType, String comprehensionName, String nestedComprehensionName, HashMap<String, CubexTypeGrammar> varList) {
		this.comp = comp;
		this.expression = expression;
		this.cubexType = cubexType;
		this.comprehensionName = comprehensionName;
		this.nestedComprehensionName = nestedComprehensionName;
		this.varList = varList;
	}

	public String toC(CGenerationContext context) {
		return this.toC(context, context.getComprehensionStruct());
	}
	
	public String toC(CGenerationContext context, String variableName) {
		// TODO Auto-generated method stub
		StringBuilder s = new StringBuilder();
		structVariableName = variableName;
		context.varDecl.put(structVariableName, this.getComprehensionName() + "_t");
		s.append(structVariableName + " = x3malloc(sizeof(struct " + this.getComprehensionName() + "));\n");
		s.append(structVariableName + "->_iterable = " + "NULL;\n");
		s.append(structVariableName + "->_iterator = " + "NULL;\n");
		s.append(structVariableName + "->hasEvaluatedOnce = " + "0;\n");
		s.append(structVariableName + "->evaluatedValue = " + "0;\n");
		for(String str : varList.keySet()){
			s.append(structVariableName + "->" + str + " = " + str + ";\n");
		}
		if(comp != null){
			String nestName = context.getComprehensionStruct();
			s.append(comp.toC(context, nestName));
			s.append(structVariableName + "->_nest_comp = " + nestName + ";");
		}
		context.comprehensionFunctions.add(addHasNextFunction(context));
		context.comprehensionFunctions.add(addGetNextFunction(context));
		
		return s.toString();
	}

	@Override
	public ArrayList<IrBind> getExpressions(CGenerationContext context) {
		// TODO Auto-generated method stub
		return new ArrayList<IrBind>();
	}
	
	public String addHasNextFunction(CGenerationContext context){
		StringBuilder s = new StringBuilder();
		s.append("int " + comprehensionName + "_hasNext(" + comprehensionName + "_t __comp){\n");
		//Check to see if we should look at expression
		s.append("if(__comp->hasEvaluatedOnce == 0){\n");
		s.append("return 1;\n");
		s.append("}\n");
		
		//See if we can get an element from farther down in the list of comprehensions
		//ex: for(v in e) for(v2 in e2) v2
		if(nestedComprehensionName == null){
			s.append("return 0;\n");
		}
		else{
			s.append("return " + nestedComprehensionName + "_hasNext(__comp->_nest_comp);\n");
		}
		s.append("}\n");
		return s.toString();
	}
	public String addGetNextFunction(CGenerationContext context){
		System.out.println();
		return "";
	}
	
	public String getComprehensionName() {
		return comprehensionName;
	}
	

	public String getStructVariableName(){
		return structVariableName;
	}
}
