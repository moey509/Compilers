package parsingTokens;

import java.util.LinkedList;
import java.util.Map;

import Exception.SemanticException;
import parsingTokens.context.CubexTypeScheme;
import parsingTokens.context.CubexTypeTuple;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.statements.CubexListStatement;
import parsingTokens.statements.CubexStatement;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import parsingTokens.typeGrammar.CubexTypeName;
import typeChecker.ClassContext;
import typeChecker.ClassContextElement;
import typeChecker.CubexCompleteContext;
import typeChecker.FunctionContext;
import typeChecker.KindContext;
import typeChecker.TypeCheckerMain;
import typeChecker.TypeContext;

public class CubexClassGrammar {
	public String name;
	public CubexList<String> kindcontext;
	public CubexList<CubexTypeTuple> typecontext;
	public CubexTypeGrammar extendsType;
	public CubexList<CubexStatement> statements;
	public CubexList<CubexExpression> expressions;
	public CubexList<CubexFunctionDef> functions;

	public CubexClassGrammar(String n, CubexList<String> k,
			CubexList<CubexTypeTuple> typecont, CubexTypeGrammar t,
			CubexList<CubexStatement> s, CubexList<CubexExpression> e,
			CubexList<CubexFunctionDef> f) {
		name = n;
		kindcontext = k;
		typecontext = typecont;
		extendsType = t;
		statements = s;
		expressions = e;
		functions = f;
	}

	public void flatten() {
		CubexList<CubexStatement> returnList = new CubexList<CubexStatement>();
		CubexList<CubexStatement> tempList = new CubexList<CubexStatement>();
		for (int i = 0; i < statements.size(); i++) {
			CubexStatement s = statements.get(i);
			tempList = s.flatten();
			returnList.add(tempList);
		}
		statements = returnList;
	}

	public CubexClassGrammar(String name, CubexList<String> kindContext,
			CubexList<CubexTypeTuple> typeContext, CubexTypeGrammar extendsType) {
		this.name = name;
		this.kindcontext = kindContext;
		this.typecontext = typeContext;
		this.extendsType = extendsType;
		this.statements = new CubexList<CubexStatement>();
		this.expressions = new CubexList<CubexExpression>();
		this.functions = new CubexList<CubexFunctionDef>();
	}

	public String toString() {
		String kSpace = kindcontext.size() == 0 ? "" : " ";
		String tSpace = typecontext.size() == 0 ? "" : " ";
		String sSpace = statements.size() == 0 ? "" : " ";
		String eSpace = expressions.size() == 0 ? "" : " ";
		String fSpace = functions.size() == 0 ? "" : " ";

		StringBuilder build = new StringBuilder();
		build.append("class ");
		build.append(name);
		build.append(" < ");
		build.append(kindcontext.toString(","));
		build.append(kSpace);
		build.append("> ( ");
		build.append(typecontext.toString(","));
		build.append(tSpace);
		build.append(") extends ");
		build.append(extendsType);
		build.append(" { ");
		CubexListStatement.flatten = true;
		build.append(statements.toString());
		CubexListStatement.flatten = false;
		build.append(sSpace);
		build.append("super ( ");
		build.append(expressions.toString(","));
		build.append(eSpace);
		build.append(") ; ");
		build.append(functions.toString());
		build.append(fSpace);
		build.append("}");

		return build.toString();
	}

	public CubexCompleteContext typeCheck(CubexCompleteContext context)
			throws SemanticException {
		
		ClassContext classContext1;
		FunctionContext funContext1;
		FunctionContext funContext2;
		
		ClassContextElement superElement;
		ClassContextElement thisElement;
		

		CubexTypeScheme thisTypeScheme;
		
		// Find supertype
		if (context.containsClassName(extendsType.getName())) {
			superElement = context.getElementFromClassContext(extendsType.getName());
		}
		else {
			throw new SemanticException("Supertype not found");
		}
		
		
		// Create Type Grammar
		CubexList<CubexTypeGrammar> kindList = new CubexList<CubexTypeGrammar>();
		for(String s : kindcontext.iterable()){
			kindList.add(new CubexTypeName(s));
		}
		CubexTypeGrammar thisType = new CubexTypeClass(name, kindList);	
		
		// 8.2.B
		classContext1 = context.classContext.clone();
		classContext1.put(name, new ClassContextElement(this));
		
		
		// 8.2.C
		funContext1 = context.functionContext.clone();
		thisTypeScheme = new CubexTypeScheme(kindcontext, typecontext, thisType);
		funContext1.put(name, thisTypeScheme);
		
		KindContext kindContext1 = new KindContext();
		for (String s : kindcontext.iterable()){
			kindContext1.add(s);
		}
		
		// 8.2.D,E,F
		CubexCompleteContext completeContext = context.clone();
		completeContext.classContext = classContext1;
		completeContext.kindContext = kindContext1;
		
		CubexCompleteContext completeContext1 = completeContext.clone();		
		completeContext1.typeContext = context.typeContext.clone();
		
		for (CubexStatement statement : statements.iterable()){
			completeContext1.mutableTypeContext = statement.typeCheck(completeContext1);
		}
		
		
		// 8.2.G,H
		CubexCompleteContext completeContext2 = completeContext1.clone();
		completeContext2.typeContext.noConflictMerge(completeContext2.mutableTypeContext);
		completeContext2.mutableTypeContext = new TypeContext();
		
		CubexTypeGrammar superType;
		if (extendsType.equals(context.getTypeGrammarFromTypeContext("Thing"))) {
			superType = context.getTypeGrammarFromTypeContext("Thing");
		}
		else {
			CubexTypeScheme superTypeScheme = completeContext2.functionContext.get(extendsType.getName());
			//Implement this later
		}
		
		
		
		// 8.2.I
		FunctionContext functionContext2 = funContext1.clone();
		for (CubexFunctionDef fun : functions.iterable()){
			functionContext2.put(fun.name, fun.typescheme);
		}
		

		// 8.2.J
		CubexCompleteContext completeContext3= context.clone();
		completeContext3.classContext = classContext1;
		for (CubexFunctionDef function : functions.iterable()){

			KindContext temp = new KindContext();
			for (String s : function.typescheme.getKindContext().iterable()){
				temp.add(s);
			}
			completeContext3.kindContext.addAll(temp);
			completeContext3.typeContext = function.statement.typeCheck(completeContext2);
		}
		
		
		// 8.2.K
		Map<String, CubexTypeScheme> superTypeFunctions = superElement.functionMap;
		for (CubexFunctionDef function : functions.iterable()) {
			if (superTypeFunctions.containsKey(function.name)) {
				if (superTypeFunctions.get(function.name).equals(
						function.typescheme)) {
					throw new SemanticException(
							"Type parameters for function "
									+ function.name
									+ " does not agree with the supertype function parameters.");
				}
			}
		}

		return context;
	}
}
