package parsingTokens.comprehension;

import ir.comp.IrComprehension;
import ir.program.IrComprehensionStruct;
import ir.program.IrProgram;
import ir.program.IrStruct;
import ir.program.IrTypeTuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import Exception.SemanticException;
import parsingTokens.context.CubexTypeTuple;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.statements.CubexBind;
import parsingTokens.statements.CubexStatement;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;

public abstract class Comp {
	protected CubexExpression e;
	protected Comp comp; // can be null - needs to be checked
	
	//Maps variable name to type
	public HashMap<String, CubexTypeGrammar> varList = new HashMap<String, CubexTypeGrammar>();
	
	public abstract CubexTypeGrammar typeCheck(CubexCompleteContext c) throws SemanticException;
	public abstract void getVars(Set<String> set);
	public abstract void replaceVars(HashMap<String, String> map);

	public abstract IrComprehension toIr(IrGenerationContext context);
	
	
	public String addStruct(IrGenerationContext context) {
		if(this instanceof CompPair){
			return null;
		}
		String nestedName = null;
		if(comp != null){
			nestedName = comp.addStruct(context);
		}
		String name = context.nextComprehensionName();
		IrComprehensionStruct struct = new IrComprehensionStruct(name, nestedName);
		//TODO: Check this to make sure IrType is correct
		for(String variable : varList.keySet()){
			struct.addStructVariable(new IrTypeTuple(varList.get(variable).toIrType(), variable));
		}
		context.comprehensionStructs.add(struct);
		return name;
	}
}
