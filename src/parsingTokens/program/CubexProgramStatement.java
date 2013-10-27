package parsingTokens.program;

import ir.IrProgramElem;

import java.util.ArrayList;

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
	
	public ArrayList<IrProgramElem> toIr() {
		ArrayList<IrProgramElem> arr = new ArrayList<IrProgramElem>();
		arr.add(statement.toIr());
		return arr;
	}

	public String toString() {
		return statement.toString();
	}

	//Top rule in Program Checking
	public CubexCompleteContext typeCheck(CubexCompleteContext c) throws SemanticException{
		CubexList<CubexTypeGrammar> l = new CubexList<CubexTypeGrammar>();
		c.kindContext = new KindContext();
		c.mutableTypeContext = new TypeContext();	
		TypeContextReturn ret = statement.typeCheckReturn(c);
		CubexList<CubexTypeGrammar> iterableString = new CubexList<CubexTypeGrammar>();
		iterableString.add(new CubexTypeClass("String", new CubexList<CubexTypeGrammar>()));
		
		//This must return and the return must be a subtype of iterable<String>
		if(!ret.guaranteedToReturn || !(new CubexTypeClass("Iterable", iterableString)).isSuperTypeOf(c, ret.retType)){
			throw new SemanticException("CubexProgramStatement");
		}

		return c;
	}
}