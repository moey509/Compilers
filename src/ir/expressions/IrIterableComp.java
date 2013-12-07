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
	public ArrayList<IrComprehension> list;
	
	public String cType;
	public CubexTypeGrammar cubexType;

	@Override
	public String getCType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CubexTypeGrammar getCubexType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toC(CGenerationContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<IrBind> getExpressions(CGenerationContext context) {
		// TODO Auto-generated method stub
		return null;
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
