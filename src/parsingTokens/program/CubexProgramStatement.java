package parsingTokens.program;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import ir.program.IrProgram;
import ir.program.IrTypeTuple;
import ir.statements.IrBind;
import ir.statements.IrStatement;
import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.statements.CubexBind;
import parsingTokens.statements.CubexStatement;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import typeChecker.CubexCompleteContext;
import typeChecker.IrGenerationContext;
import typeChecker.KindContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;

public class CubexProgramStatement implements CubexProgramType {
	private CubexStatement statement;
	private Set<String> globalVariableSet;
	private Set<String> freeContext;

	public CubexProgramStatement(CubexStatement statement) {
		statement.flatten();
		this.statement = statement;
	}

	public String toString() {
		return statement.toString();
	}

	// Top rule in Program Checking
	public CubexCompleteContext typeCheck(CubexCompleteContext c)
			throws SemanticException {
		CubexList<CubexTypeGrammar> l = new CubexList<CubexTypeGrammar>();
		c.kindContext = new KindContext();
		c.mutableTypeContext = new TypeContext();
		TypeContextReturn ret = statement.typeCheckReturn(c);
		CubexList<CubexTypeGrammar> iterableString = new CubexList<CubexTypeGrammar>();
		iterableString.add(new CubexTypeClass("String",
				new CubexList<CubexTypeGrammar>()));

		// This must return and the return must be a subtype of iterable<String>
		if (!ret.guaranteedToReturn
				|| !(new CubexTypeClass("Iterable", iterableString))
						.isSuperTypeOf(c, ret.retType)) {
			throw new SemanticException("CubexProgramStatement");
		}
		globalVariableSet = new HashSet<String>(c.typeContext.keySet());
		freeContext = c.typeContext.keySet();
		return c;
	}

	@Override
	public IrProgram toIr(IrGenerationContext context, IrProgram program) {
		for (String s : globalVariableSet) {
			context.addGlobalVariable(s);
		}
		if (statement instanceof CubexBind) {
			CubexBind cubexBind = (CubexBind) statement;
			program.addGlobalVariable(cubexBind.toIr(context));
		}
		IrStatement s = statement.toIr(context);
		program.addMainStatement(s);
		for(IrBind bind : s.getTemporaryVariables()){
			program.addGlobalVariable(bind);
		}
		//freeContext setting
		program.setFreeContext(new ArrayList<String>(freeContext));
		
		return program;
	}
}