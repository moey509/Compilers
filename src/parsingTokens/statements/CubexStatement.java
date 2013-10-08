package parsingTokens.statements;


import Exception.SemanticException;
import parsingTokens.expressions.CubexExpression;
import typeChecker.CubexCompleteContext;
import typeChecker.TypeContextReturn;
import typeChecker.TypeContext;

public abstract class CubexStatement {
	protected CubexExpression e;
	//Must return some expression. If unimplemented then returns false. Top rule  in program checking.
//	public boolean typeCheck(CubexCompleteContext c, boolean b){
//		return false;
//	}
	//For returns, given true/false for return and a type t
	public TypeContextReturn typeCheckReturn(CubexCompleteContext c) throws SemanticException {
		throw new SemanticException("CubexStatement does not implement typeCheckReturn");
	}
	public TypeContext typeCheck(CubexCompleteContext c) throws SemanticException{
		// TODO Auto-generated method stub
		throw new SemanticException("CubexStatement does not implement typeCheck");
	}
}