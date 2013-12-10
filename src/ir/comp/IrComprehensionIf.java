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

	@Override
	public String toC(CGenerationContext context) {
		// TODO Auto-generated method stub
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
		return new ArrayList<IrBind>();
	}
	
	public String addHasNextFunction(CGenerationContext context){
		//See if we can get an element from farther down in the list of comprehensions
		//ex: for(v in e) for(v2 in e2) v2
		if(nestedComprehensionName != null){
			System.out.println("if(_" + nestedComprehensionName + "_hasNext(" + nestedComprehensionName + ") == 1);");
			System.out.println("{return 1;}");
		}
		return "";
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
