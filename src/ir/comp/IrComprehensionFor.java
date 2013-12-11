package ir.comp;

import java.util.ArrayList;
import java.util.HashMap;

import ir.CGenerationContext;
import ir.expressions.IrExpression;
import ir.expressions.IrIterableComp;
import ir.statements.IrBind;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.IrGenerationContext;

public class IrComprehensionFor implements IrComprehension{
	public IrComprehension comp;
	public IrExpression expression;
	public String variableName;
	public String comprehensionName;
	public String nestedComprehensionName;
	public String structVariableName;
	public HashMap<String, CubexTypeGrammar> varList;
	
	public CubexTypeGrammar cubexType;
	public String cType;
	
	public IrComprehensionFor(IrComprehension comp, IrExpression expression,
			String variableName, CubexTypeGrammar cubexType, String comprehensionName, String nestedComprehensionName, HashMap<String, CubexTypeGrammar> varList) {
		this.comp = comp;
		this.expression = expression;
		this.variableName = variableName;
		this.cubexType = cubexType;
		this.comprehensionName = comprehensionName;
		this.nestedComprehensionName = nestedComprehensionName;
		this.varList = varList;
	}

	
	public String toC(CGenerationContext context, String variableName) {
		// TODO Auto-generated method stub
		System.out.println("FOR: " + this.comprehensionName);
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
			System.out.println("COMP SHOULD NOT BE NULL");
			String nestName = context.getComprehensionStruct();
			s.append(comp.toC(context, nestName));
			System.out.println(comp.getStructVariableName());
			s.append(structVariableName + "->_nest_comp = " + nestName + ";");
		}
		context.comprehensionFunctions.add(addHasNextFunction(context));
		context.comprehensionFunctions.add(addGetNextFunction(context));
		
		return s.toString();
	}
	
	public String toC(CGenerationContext context) {
		return this.toC(context, context.getComprehensionStruct());
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
		
		//In this case, create an iterable
		s.append("if(__comp->hasEvaluatedOnce == 0){\n");
		s.append("__comp->hasEvaluatedOnce = 1;\n");
		if(expression instanceof IrIterableComp){
			IrIterableComp comp = (IrIterableComp)expression;
			s.append(comp.comprehension.toC(context));
			s.append("__comp->_iterable = iterable_append((" + comp.comprehension.getStructVariableName() + "), NULL);\n");
		}
		else if(expression instanceof IrComprehension){
			s.append(expression.toC(context));
			s.append("__comp->_iterable = iterable_append((" + ((IrComprehension)expression).getStructVariableName() + "), NULL);\n");
		}
		else
		{
			s.append("__comp->_iterable = iterable_append((" + expression.toC(context) + "), NULL);\n");
		}
		s.append("__comp->_iterator = new_iterator(__comp->_iterable);\n");
		
		//While there are still elements in the for loop, get the next element and see if we can get another from the nestedComprehension
		s.append("while(hasNext(__comp->_iterator) == 1){\n");
		if(comp != null){
			s.append("__comp->_nest_comp->hasEvaluatedOnce = 0;\n");
			for(String str : varList.keySet()){
				s.append("__comp->_nest_comp->" + str + " = __comp->" + str + ";\n");
			}
			s.append("__comp->_nest_comp->" + variableName + "= getNext(__comp->_iterator);\n");
			s.append("if(" + nestedComprehensionName + "_hasNext(__comp->_nest_comp) == 1){return 1;}\n");		
		}
		s.append("}\n"); //End while
		
		s.append("}\n"); //End if
		
		//See if we can get an element from farther down in the list of comprehensions
		//ex: for(v in e) for(v2 in e2) v2
		if(nestedComprehensionName == null){
			s.append("return 0;\n");
		}
		else{
			//If there are still elements in the nested Comprehension, return true
			s.append("if(" + nestedComprehensionName + "_hasNext(__comp->_nest_comp) == 1){return 1;}\n");
			//Check in iterable for another element
			s.append("while(hasNext(__comp->_iterator) == 1){\n");
			if(comp != null){
				s.append("__comp->_nest_comp->hasEvaluatedOnce = 0;\n");
				for(String str : varList.keySet()){
					s.append("__comp->_nest_comp->" + str + " = __comp->" + str + ";\n");
				}
				s.append("__comp->_nest_comp->" + variableName + "= getNext(__comp->_iterator);\n");
				s.append("if(" + nestedComprehensionName + "_hasNext(__comp->_nest_comp) == 1){return 1;}\n");		
			}
			s.append("}\n"); //End while
		}
		s.append("return 0;\n");
		s.append("}\n"); //End function
		return s.toString();
	}
	public String addGetNextFunction(CGenerationContext context){
		StringBuilder s = new StringBuilder();
		s.append("void* " + comprehensionName + "_getNext(" + comprehensionName + "_t __comp){\n");
		s.append("if(" + nestedComprehensionName + "_hasNext(__comp->_nest_comp) == 1){\n");
		s.append(comp.toC(context));
		s.append("return " + nestedComprehensionName + "_hasNext(__comp->_nest_comp);\n");
		s.append("}\n");
		s.append("}\n");
		return s.toString();
	}

	@Override
	public String getComprehensionName() {
		return comprehensionName;
	}
	
	public String getStructVariableName(){
		return structVariableName;
	}
}
