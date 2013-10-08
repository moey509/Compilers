package parsingTokens.program;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.statements.CubexStatement;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import parsingTokens.typeGrammar.CubexTypeName;
import typeChecker.CubexCompleteContext;
import typeChecker.TypeContextReturn;

public class CubexProgramStatement implements CubexProgramType {
	private CubexStatement statement;

	public CubexProgramStatement(CubexStatement statement) {
		this.statement = statement;
	}

	public String toString() {
		return statement.toString();
	}
	//Top rule in Program Checking
	//TODO:make sure contexts setting to null is correct
	public void typeCheck(CubexCompleteContext c) throws SemanticException{
		CubexList<CubexTypeGrammar> l = new CubexList<CubexTypeGrammar>();
		l.add(new CubexTypeName("String"));
		CubexTypeClass t = new CubexTypeClass("Iterable", l);
		c.kindContext = null;
		c.mutableTypeContext = null;
		TypeContextReturn ret = statement.typeCheckReturn(c);
		//TODO:Check for ret.typeContext <: Iterable<String>
		if(ret.guaranteedToReturn){
			throw new SemanticException("");
		}
	}
}