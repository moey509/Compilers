package parsingTokens.program;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import ir.program.IrProgram;
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

public class CubexProgramStatementList implements CubexProgramType {
	private CubexList<CubexStatement> statementList;
	private Set<String> globalVariableSet = null;

	public CubexProgramStatementList(CubexList<CubexStatement> statementList) {
		CubexList<CubexStatement> returnList = new CubexList<CubexStatement>();
		CubexList<CubexStatement> tempList = new CubexList<CubexStatement>();

		for (int i = 0; i < statementList.size(); i++) {
			tempList = statementList.get(i).flatten();
			returnList.add(tempList);
		}
		this.statementList = returnList;
	}

	public String toString() {
		return statementList.toString(" ");
	}

	@Override
	public CubexCompleteContext typeCheck(CubexCompleteContext c)
			throws SemanticException {
		TypeContextReturn ret;
		CubexCompleteContext tempContext = c.clone();
		TypeContext nextContext = new TypeContext();
		tempContext.kindContext = new KindContext();

		for (int i = 0; i < statementList.size(); i++) {
			tempContext.mutableTypeContext = nextContext;
			ret = statementList.get(i).typeCheckReturn(tempContext);
			nextContext = ret.typeContext;
			// CubexList<CubexTypeGrammar> typeList = ret.retType.getTypeList();
			if (ret.guaranteedToReturn) {
				CubexList<CubexTypeGrammar> iterableString = new CubexList<CubexTypeGrammar>();
				iterableString.add(new CubexTypeClass("String",
						new CubexList<CubexTypeGrammar>()));
				if (!ret.guaranteedToReturn
						|| !(new CubexTypeClass("Iterable", iterableString))
								.isSuperTypeOf(c, ret.retType)) {
					throw new SemanticException("");
				}
			}
		}

		tempContext.appendTypeContext(nextContext);

		globalVariableSet = new HashSet<String>(tempContext.typeContext.keySet());

		return tempContext;
	}

	@Override
	public IrProgram toIr(IrGenerationContext context, IrProgram program) {
		for (String s : globalVariableSet){
			context.addGlobalVariable(s);
		}
		for (CubexStatement statement : statementList.iterable()) {
			IrStatement s;
			if (statement instanceof CubexBind) {
				IrBind b = ((CubexBind) statement).toIr(context);
				s = b;
//				for(IrBind bind : b.getTemporaryVariables()){
//					program.addGlobalVariable(bind);
//				}
			}
			else{
				s = statement.toIr(context);
			}
			program.addMainStatement(s);
		}
		return program;
	}

	@Override
	public void replaceVars(HashMap<String, String> map) {
		for (CubexStatement s : statementList.contextCollection) {
			s.replaceVars(map);
		}
		
	}
}
