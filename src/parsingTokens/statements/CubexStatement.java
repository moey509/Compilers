package parsingTokens.statements;


import Exception.SemanticException;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeClass;
import typeChecker.CubexCompleteContext;
import typeChecker.TypeContextReturn;
import typeChecker.TypeContext;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.typeGrammar.CubexTypeClass;

public abstract class CubexStatement {
	public CubexExpression e;
	//Must return some expression. If unimplemented then returns false. Top rule  in program checking.
	public boolean typeCheck(CubexCompleteContext c, boolean b){
		return false;
	}
	//For returns, given true/false for return and a type t
	public TypeContextReturn typeCheckReturn(CubexCompleteContext c) throws SemanticException {
		throw new SemanticException("");
	}
	public TypeContext typeCheck(CubexCompleteContext c) throws SemanticException{
		// TODO Auto-generated method stub
		throw new SemanticException("");
	}
}