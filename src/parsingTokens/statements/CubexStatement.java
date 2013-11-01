package parsingTokens.statements;


import ir.program.IrProgramContext;
import ir.statements.IrStatement;
import Exception.SemanticException;
import parsingTokens.CubexList;
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
		throw new SemanticException("CubexStatement does not implement typeCheck");
	}
	public CubexList<CubexStatement> flatten() {
		// If not a statement list, return a statement list of size 1
		CubexList<CubexStatement> l = new CubexList<CubexStatement>();
		l.add(this);
		return l;
	}
	
	public abstract IrStatement toIr(IrProgramContext context);
	
}