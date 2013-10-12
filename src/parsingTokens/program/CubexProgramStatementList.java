package parsingTokens.program;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.statements.CubexStatement;
import typeChecker.CubexCompleteContext;
import typeChecker.KindContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;

public class CubexProgramStatementList implements CubexProgramType {
	private CubexList<CubexStatement> statementList;

	public CubexProgramStatementList(CubexList<CubexStatement> statementList) {
		CubexList<CubexStatement> returnList = new CubexList<CubexStatement>();
		CubexList<CubexStatement> tempList = new CubexList<CubexStatement>();
		
		for(int i = 0; i < statementList.size(); i++){
			tempList= statementList.get(i).flatten();
			returnList.add(tempList);
		}
		this.statementList = returnList;
	}

	public String toString() {
		return statementList.toString(" ");
	}

	@Override
	public CubexCompleteContext typeCheck(CubexCompleteContext c) throws SemanticException {
		TypeContextReturn ret;
		CubexCompleteContext tempContext = c.clone();
		TypeContext nextContext = new TypeContext();
		tempContext.kindContext = new KindContext();
		
		for(int i = 0; i < statementList.size(); i++){
			tempContext.mutableTypeContext = nextContext;
			//TODO:needs typeCheckReturns method
			ret = statementList.get(i).typeCheckReturn(tempContext);
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
