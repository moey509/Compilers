package ir.expressions;

import ir.CGenerationContext;
import ir.comp.IrComprehension;
import ir.statements.IrBind;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import optimization.CseContext;
import parsingTokens.typeGrammar.CubexTypeGrammar;

public class IrIterableComp implements IrExpression{
	public IrComprehension comprehension;
	
	public String cType;
	public CubexTypeGrammar cubexType;

	public IrIterableComp(IrComprehension comprehension){
		this.comprehension = comprehension;
	}
	
	@Override
	public String getCType() {
		// TODO Auto-generated method stub
		return cType;
	}

	@Override
	public CubexTypeGrammar getCubexType() {
		// TODO Auto-generated method stub
		return cubexType;
	}

	@Override
	public String toC(CGenerationContext context) {
		StringBuilder s = new StringBuilder();
		if (comprehension!=null) {
			String hasNext = "&" + comprehension.getComprehensionName() + "_hasNext";
			String getNext = "&" + comprehension.getComprehensionName() + "_getNext";
			s.append("new_lazy_git_obj((void*) " + comprehension.getStructVariableName() + ", " + hasNext + ", " + getNext + ")");
		} else {
			s.append("NULL");
		}

		return s.toString();
	}

	@Override
	public ArrayList<IrBind> getExpressions(CGenerationContext context) {
		//TODO: Need to 
		return comprehension.getExpressions(context);
	}

	@Override
	public void getVars(Set<String> set, Map<String, Set<String>> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IrExpression eliminateSubexpression(CseContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IrExpression getSubexpressions(CseContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	public IrExpression clone() {
		// TODO Auto-generated method stub
		return null;
	}
}
