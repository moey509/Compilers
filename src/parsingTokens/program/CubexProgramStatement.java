package parsingTokens.program;

import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.statements.CubexStatement;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import parsingTokens.typeGrammar.CubexTypeName;
import typeChecker.CubexCompleteContext;

public class CubexProgramStatement implements CubexProgramType {
	private CubexStatement statement;

	public CubexProgramStatement(CubexStatement statement) {
		this.statement = statement;
	}

	public String toString() {
		return statement.toString();
	}
	//Top rule in Program Checking
	public boolean typeCheck(CubexCompleteContext c) throws SemanticException{
		CubexList<CubexTypeGrammar> l = new CubexList<CubexTypeGrammar>();
		l.add(new CubexTypeName("String"));
		CubexTypeClass t = new CubexTypeClass("Iterable", l);
		return statement.typeCheck(c, true, t);
	}
}
