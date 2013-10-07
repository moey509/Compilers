package parsingTokens.program;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.statements.CubexStatement;
import typeChecker.CubexCompleteContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;

public class CubexProgramStatementList implements CubexProgramType {
	private CubexList<CubexStatement> statementList;

	public CubexProgramStatementList(CubexList<CubexStatement> statementList) {
		this.statementList = statementList;
	}

	public String toString() {
		return statementList.toString(" ");
	}

	@Override
	public CubexCompleteContext typeCheck(CubexCompleteContext c) throws SemanticException {
		TypeContextReturn ret;
		CubexCompleteContext tempContext = c.clone();
		TypeContext nextContext = null;
		tempContext.kindContext = null;
		
		for(int i = 0; i < statementList.size(); i++){
			tempContext.mutableTypeContext = nextContext;
			//TODO:needs typeCheckReturns method
			ret = null;//TODO: write typeCheckReturns? =statementList.get(i).typeCheckReturns(tempContext);
			nextContext = ret.typeContext;
			//TODO:Check for ret.typeContext <: Iterable<String>
			if(ret.guaranteedToReturn){
				throw new SemanticException("");
			}
		}
		
		tempContext.appendTypeContext(tempContext.mutableTypeContext);
		return tempContext;
	}
}
