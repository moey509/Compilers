package parsingTokens.statements;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.statements.CubexStatement;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;

public final class CubexListStatement extends CubexStatement {
	private CubexList<CubexStatement> cList;
	public static boolean flatten = false;

	public CubexListStatement(CubexList<CubexStatement> cList) {
		this.cList = cList;
	}
	
	public CubexList<CubexStatement> flatten(){
		CubexList<CubexStatement> returnList = new CubexList<CubexStatement>();
		CubexList<CubexStatement> tempList = new CubexList<CubexStatement>();
		for(int i = 0; i < cList.size(); i++){
			CubexStatement s = cList.get(i);
			tempList = s.flatten();
			returnList.add(tempList);
		}
		cList = returnList;
		return returnList;
	}
	
	public String toString() {
		String rightSpace = cList.size() == 0 ? "" : " ";
		if(flatten || (cList.size() == 1)){
			return cList.toString(" ");
		}
		else{
			String s = "{ " + cList.toString(" ") + rightSpace + "}";
			return s;
		}
	}

	@Override
	public TypeContext typeCheck(CubexCompleteContext c) throws SemanticException{
		TypeContext prev = c.mutableTypeContext;
		for(int i = 0; i < cList.size(); i++){
			CubexCompleteContext cclone = c.clone();
			cclone.mutableTypeContext = prev;
			prev = cList.get(i).typeCheck(c);
		}
		return prev;
	}
	
	public TypeContextReturn typeCheckReturn(CubexCompleteContext c) throws SemanticException {
		TypeContextReturn prevReturnContext = null;
		TypeContext prev = c.mutableTypeContext.clone();
		CubexCompleteContext cclone = c.clone();
		CubexTypeGrammar rettype = null;
		boolean rettypeupdated = false;
		boolean guaranteed = false;
		for (int i=0; i<cList.size(); i++) {
			cclone.mutableTypeContext = prev;
			prevReturnContext = cList.get(i).typeCheckReturn(cclone);
			prev = prevReturnContext.typeContext;
			guaranteed = prevReturnContext.guaranteedToReturn || guaranteed;
			// assuming that if gauranteedToReturn==True, the return type can't be "anything" (null)
			if (prevReturnContext.guaranteedToReturn || prevReturnContext.retType!=null) {
				if (rettypeupdated) {
					// assumes equality of all tau's
					rettype = rettype.join(c, prevReturnContext.retType);
				} else {
					rettypeupdated = true;
					rettype = prevReturnContext.retType;
				}
			}
		}
		return new TypeContextReturn(prev, guaranteed, rettype);
	}
}