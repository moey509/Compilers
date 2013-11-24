package parsingTokens.program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import ir.program.IrProgram;
import ir.statements.IrReturn;
import ir.statements.IrStatement;
import Exception.SemanticException;
import parsingTokens.CubexList;
import parsingTokens.statements.CubexReturn;
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
		freeContext = new HashSet<String>(c.typeContext.keySet());
		return c;
	}

	@Override
	public IrProgram toIr(IrGenerationContext context, IrProgram program) {
		for (String s : globalVariableSet) {
			context.addGlobalVariable(s);
		}

		IrStatement s = statement.toIr(context);
		// overwrite the free context if this is a return
		if (statement instanceof CubexReturn) {
			// add the return variable to the freeContext at the toplevel

			
			// removing to allow for freeing of var we're returning in main
			/*
			// find all variables associated with the return statement
			CubexReturn cr = (CubexReturn) statement;
			Set<String> donotfree = new HashSet<String>();
			cr.gete().getVars(donotfree);			
			//freeContext.removeAll(donotfree);			 
			 */
			Set<String> modfc = new HashSet<String>();
			
			//toplevel variables: prepend _
//			for (String str : freeContext) {
//				modfc.add("_" + str);
//			}

			IrReturn ret = (IrReturn) s;
			ret.setFreeContext(new ArrayList<String>(modfc));
		}
		program.addMainStatement(s);
//		for(IrBind bind : s.getTemporaryVariables()){
//			program.addGlobalVariable(bind);
//		}
		//freeContext setting
		program.setFreeContext(new ArrayList<String>(freeContext));
		
		return program;
	}

	@Override
	// need to handle globalVariableSet
	public void replaceVars(HashMap<String, String> map) {
		statement.replaceVars(map);
		for (String s : map.keySet()) {
			if (freeContext.contains(s)) {
				freeContext.remove(s);
				freeContext.add(map.get(s));
			}
		}
		
	}
}