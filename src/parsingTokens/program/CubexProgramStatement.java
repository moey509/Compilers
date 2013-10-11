package parsingTokens.program;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.statements.CubexStatement;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import parsingTokens.typeGrammar.CubexTypeName;
import typeChecker.CubexCompleteContext;
import typeChecker.KindContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;

public class CubexProgramStatement implements CubexProgramType {
	private CubexStatement statement;

	public CubexProgramStatement(CubexStatement statement) {
		statement.flatten();
		this.statement = statement;
	}

	public String toString() {
		return statement.toString();
	}
	//Top rule in Program Checking
	//TODO:make sure contexts setting to null is correct
	public CubexCompleteContext typeCheck(CubexCompleteContext c) throws SemanticException{
		CubexList<CubexTypeGrammar> l = new CubexList<CubexTypeGrammar>();
		c.kindContext = new KindContext();
		c.mutableTypeContext = new TypeContext();
		TypeContextReturn ret = statement.typeCheckReturn(c);
		//TODO:Check for ret.typeContext <: Iterable<String>
		CubexList<CubexTypeGrammar> typeList = ret.retType.getTypeList();
		if(!ret.guaranteedToReturn || typeList.size() != 1 || !typeList.get(0).name.equals("String")){
			throw new SemanticException("CubexProgramStatement");
		}
		
		return c;
	}
}