package ir.comp;


import java.util.ArrayList;
import java.util.HashMap;

import ir.CGenerationContext;
import ir.expressions.IrExpression;
import ir.statements.IrBind;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.IrGenerationContext;

public class IrComprehensionPair implements IrComprehension{
	public IrComprehension comp;
	public IrExpression expr;
	
	public String comprehensionName;
	public String nestedComprehensionName;
	public String structVariableName;
	public HashMap<String, CubexTypeGrammar> varList;
	
	public CubexTypeGrammar cubexType;
	public String cType;
	
	public IrComprehensionPair(IrComprehension comp, IrExpression expr,
			CubexTypeGrammar cubexType, String comprehensionName, String nestedComprehensionName, HashMap<String, CubexTypeGrammar> varList) {
		this.comp = comp;
		this.expr = expr;
		this.cubexType = cubexType;
		this.comprehensionName = comprehensionName;
		this.nestedComprehensionName = nestedComprehensionName;
		this.varList = varList;
	}

	@Override
	public String toC(CGenerationContext context) {
		// TODO Auto-generated method stub
		String hasNext = addHasNextFunction(context);
		String getNext = addGetNextFunction(context);
		StringBuilder s = new StringBuilder();
		structVariableName = context.getComprehensionStruct();
		s.append(structVariableName + " = x3malloc(sizeof(struct " + this.getComprehensionName() + "));\n");
		s.append(structVariableName + "->iterable = " + "NULL;\n");
		s.append(structVariableName + "->iterator = " + "NULL;\n");
		s.append(structVariableName + "->hasEvaluatedOnce = " + "0;\n");
		s.append(structVariableName + "->evaluatedValue = " + "0;\n");
		for(String str : varList.keySet()){
			s.append(structVariableName + "->" + str + " = " + str + ";\n");
		}
		return s.toString();
	}

	@Override
	public ArrayList<IrBind> getExpressions(CGenerationContext context) {
		// TODO Auto-generated method stub
		ArrayList<IrBind> arr = expr.getExpressions(context);
		arr.addAll(comp.getExpressions(context));
		return arr;
	}
	
	public String addHasNextFunction(CGenerationContext context){
		StringBuilder s = new StringBuilder();
		if(comp != null){
			comp.addHasNextFunction(context);
		}
		s.append(comprehensionName + "_hasNext(" + comprehensionName + "_t __comp){\n");
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
			s.append("return " + nestedComprehensionName + "_hasNext(" + nestedComprehensionName + ");\n");
		}
		s.append("}\n");
		context.comprehensionFunctions.add(s.toString());
		return "";
	}
	public String addGetNextFunction(CGenerationContext context){
		StringBuilder s = new StringBuilder();
		if(comp != null){
			comp.addGetNextFunction(context);
		}
		s.append(comprehensionName + "_getNext(" + comprehensionName + "_t __comp){\n");
		//Check to see if we should look at expression
		s.append("if(__comp->hasEvaluatedOnce == 0){\n");
		s.append("__comp->hasEvaluatedOnce == 1;\n");
		s.append("return " + expr.toC(context) + "\n");
		s.append("}");
		
		//See if we can get an element from farther down in the list of comprehensions
		//ex: [e,e,e,c]
		if(nestedComprehensionName != null){
			s.append("if(" + nestedComprehensionName + "_hasNext(" + nestedComprehensionName + ") == 1);\n");
			s.append("return " + nestedComprehensionName + "_getNext(" + nestedComprehensionName + ");\n");
			s.append("}");
		}
		else{
			s.append("return NULL;\n");
		}
		context.comprehensionFunctions.add(s.toString());
		return "";
	}
	
	public String getComprehensionName() {
		return comprehensionName;
	}
	

	public String getStructVariableName(){
		return structVariableName;
	}
}
