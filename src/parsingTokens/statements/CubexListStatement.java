package parsingTokens.statements;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.statements.CubexStatement;
import typeChecker.CubexCompleteContext;

public final class CubexListStatement extends CubexStatement {
	private CubexList<CubexStatement> cList;
	public static boolean flatten = false;

	public CubexListStatement(CubexList<CubexStatement> cList) {
		this.cList = cList;
	}

	public String toString() {
		String rightSpace = cList.size() == 0 ? "" : " ";
		if(flatten || (cList.size() == 1)){
			return cList.toString(" ");
		}
		else{
			boolean prev = flatten;
			flatten = true;
			String s = "{ " + cList.toString(" ") + rightSpace + "}";
			flatten = prev;
			return s;
		}
	}

	@Override
	public CubexCompleteContext typeCheck(CubexCompleteContext c) throws SemanticException{
		// TODO Auto-generated method stub
		System.out.println("hiii");
		for(int i = 0; i < cList.size(); i++){
			//TODO: Must check for something to be true/false here
//			if(!cList.get(i).typeCheck(c)){
//				return null;
//			}
			
		}
		throw new SemanticException("");
	}
}