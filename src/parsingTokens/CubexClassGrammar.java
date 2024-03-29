package parsingTokens;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Exception.SemanticException;
import parsingTokens.context.CubexTypeScheme;
import parsingTokens.context.CubexTypeTuple;
import parsingTokens.expressions.CubexExpression;
import parsingTokens.statements.CubexBind;
import parsingTokens.statements.CubexListStatement;
import parsingTokens.statements.CubexStatement;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import parsingTokens.typeGrammar.CubexTypeIntersection;
import parsingTokens.typeGrammar.CubexTypeName;
import typeChecker.ClassContext;
import typeChecker.ClassContextElement;
import typeChecker.CubexCompleteContext;
import typeChecker.FunctionContext;
import typeChecker.IrGenerationContext;
import typeChecker.KindContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;
import ir.IrMiscFunctions;
import ir.IrType;
import ir.expressions.IrExpression;
import ir.expressions.IrFunctionCall;
import ir.expressions.IrVariableExpression;
import ir.program.IrFunction;
import ir.program.IrProgram;
import ir.program.IrStruct;
import ir.program.IrTypeTuple;
import ir.statements.IrBind;
import ir.statements.IrCStatement;
import ir.statements.IrReturn;

public class CubexClassGrammar {
	public String name;
	public CubexList<String> kindcontext;
	public CubexList<CubexTypeTuple> typecontext;
	public CubexTypeGrammar extendsType;
	public CubexList<CubexStatement> statements;
	public CubexList<CubexExpression> expressions;
	public CubexList<CubexFunctionDef> functions;
	public String constructableComponent;
	
	public CubexCompleteContext completeContext;

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

	public IrProgram toIr(IrGenerationContext context, IrProgram program) {
		context.setCurrentClassDeclaration(name);
		context.setSuperType(name, extendsType.name);
		addStruct(context, program);
		addConstructor(context, program);
		addDestructor(context, program);
		addFunctions(context, program);
		return program;
	}

	private void addStruct(IrGenerationContext context, IrProgram program) {
		if ((name != "Integer") && (name != "String") && (name != "Character")) {

			IrStruct irStruct = new IrStruct(name, constructableComponent);
			for (CubexTypeTuple tuple : typecontext.iterable()) {
				irStruct.addStructVariable(new IrTypeTuple(tuple
						.getTypeGrammar().toIrType(), tuple.getName()));
			}
			HashSet<String> varSet = new HashSet<String>();
			for (CubexStatement stmt : statements.iterable()) {
				if (stmt instanceof CubexBind) {
					CubexBind bind = (CubexBind) stmt;
					if (!varSet.contains(bind.getId())){
						irStruct.addStructVariable(new IrTypeTuple(bind.getIrType(), bind.getId()));
						varSet.add(bind.getId());
					}
				}
			}
			program.addStruct(irStruct);
		}
	}
	
	private void addDestructor(IrGenerationContext context, IrProgram program){
		ArrayList<String> arr = new ArrayList<String>();
		IrFunction irFunction = new IrFunction(new IrType("_kill_" + name), "_kill_" + name);
		IrTypeTuple argument = new IrTypeTuple(new IrType(name), "__struct");
		irFunction.addFunctionArgument(argument);
		HashMap<String, String> varSet = new HashMap<String, String>();
		for (CubexStatement stmt : statements.iterable()) {
			if (stmt instanceof CubexBind) {
				CubexBind bind = (CubexBind) stmt;
				varSet.put(bind.getId(), "__struct->" + bind.getId());			
			}
			
		}
		for(CubexTypeTuple t : typecontext.contextCollection){
			IrMiscFunctions._decrement_ref(context, "__struct->" + t.getName(), arr);
//			arr.add("ref_decrement(__struct->" + t.getName() + ");");
		}
		
		for(String s : varSet.keySet()){
			IrMiscFunctions._decrement_ref(context, s, arr);
//			arr.add("ref_decrement(" + s + ");");
		}
		irFunction.isConstructor = false;
		irFunction.addStatement(new IrCStatement(arr));
		program.addGlobalFunction(irFunction);
	}

	// Needs call to super constructor unless constructable component is
	// thing
	private void addConstructor(IrGenerationContext context, IrProgram program) {
		IrFunction irFunction = new IrFunction(new IrType(name), name);
		irFunction.isConstructor = true;
		//context.addGlobalFunction("_" + name);
		for (CubexTypeTuple tuple : typecontext.iterable()) {
			IrTypeTuple argument = new IrTypeTuple(tuple.getTypeGrammar().toIrType(), tuple.getName());
			irFunction.addFunctionArgument(argument);
			
			IrVariableExpression variable = 
					new IrVariableExpression(tuple.getName(), tuple.getTypeGrammar());
			IrBind bind = new IrBind(new IrTypeTuple(tuple.getTypeGrammar().toIrType(), "__struct->" +tuple.getName()), 
					variable, completeContext);
			irFunction.addStatement(bind);
		}		
		
		Set<CubexFunctionDef> addedFunctions = new HashSet<CubexFunctionDef>();
		String tempName = name.replace("_", "__");
		for (CubexFunctionDef funDef : functions.iterable()){
			String tempfun = funDef.name.replace("_", "__");
			irFunction.addVTableFunctionName("_" + tempName + "_" + tempfun);
			addedFunctions.add(funDef);
		}
		
		String parentClass = context.getSuperType(name);
		String superClass = parentClass;

		while (!superClass.equals("Thing")) {
			for (CubexFunctionDef function : context.functionSet(superClass)) {
				if (!addedFunctions.contains(function)) {
					addedFunctions.add(function);
					String tempfun = function.name.replace("_", "__");
					irFunction.addVTableFunctionName("_" + tempName + "_" + tempfun);
				}
			}
			superClass = context.getSuperType(superClass);
		}
		
		
		// set of variables (var) that need to be replaced with (__struct->var) 
		HashMap<String, String> varSet = new HashMap<String, String>();
		for (CubexStatement stmt : statements.iterable()) {
			if (stmt instanceof CubexBind) {
				CubexBind bind = (CubexBind) stmt;
				varSet.put(bind.getId(), "__struct->" + bind.getId());			
			}
			
		}
		
		
		for (CubexStatement stmt : statements.iterable()) {
			stmt.replaceVars(varSet);
			irFunction.addStatement(stmt.toIr(context));
		}
		
		if (constructableComponent != "Thing"){
			IrExpression e = new IrFunctionCall(this.constructableComponent, extendsType);
			irFunction.addSuperCall(e);
		}
	
		ArrayList<String> dec_inputs = new ArrayList<String>();
		for(CubexTypeTuple t : typecontext.contextCollection){
			IrMiscFunctions._decrement_ref(context, t.getName(), dec_inputs);
//			dec_inputs.add("ref_decrement(" + t.getName() + ");");
		}

		irFunction.addStatement(new IrCStatement(dec_inputs));
//		System.out.println(irFunction);
		context.addGlobalFunction("_" + irFunction.functionName);
		program.addGlobalFunction(irFunction);
	}

	private void addFunctions(IrGenerationContext context, IrProgram program) {
		HashSet<String> addedFunctions = new HashSet<String>();
		context.setCurrentClassDeclaration(name);
		for (CubexFunctionDef funDef : functions.iterable()) {
			IrFunction fun = funDef.toIr(context);
			fun.functionName = funDef.name;
			fun.addFunctionArgument(new IrTypeTuple(new IrType(name), "__struct"));
			addedFunctions.add(funDef.name);
			
			// Hack to free __struct at the bottom of a method call
			ArrayList<String> dec_inputs = new ArrayList<String>();	
			IrMiscFunctions._decrement_ref(context, "(__struct)", dec_inputs);
//			dec_inputs.add("ref_decrement(__struct);");
			
			fun.addExtras(dec_inputs);
			
			
			context.objectAddFunction(name, funDef);
			program.addGlobalFunction(fun);
		}
		String parentClass = context.getSuperType(name);
		String superClass = parentClass;

		while (!superClass.equals("Thing")) {
			for (CubexFunctionDef function : context.functionSet(superClass)) {
				if (!addedFunctions.contains(function.name)) {
					addedFunctions.add(function.name);
					IrFunction fun = function.toIr(context);
					
					
					
					
//					fun.addStatement(new IrReturn(new IrFunctionCall("_"
//							+ parentClass + "_" + function.name,
//							function.typescheme.getTypeGrammar().name, function.typescheme.getTypeGrammar()), completeContext));

					fun.addFunctionArgument(new IrTypeTuple(new IrType("void*"), "ConstructableComponent"));
					program.addGlobalFunction(fun);
				}
			}
			superClass = context.getSuperType(superClass);
		}

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

	// Need a way to get functions from supertype
	// Need a way to get the constructable component
	public CubexCompleteContext typeCheck(CubexCompleteContext originalContext)
			throws SemanticException {

		CubexCompleteContext context = originalContext.clone();
		context.kindContext = new KindContext(kindcontext);
		ClassContextElement superElement;

		if (context.classContext.containsKey(name))
			throw new SemanticException("Class name collision");

		// Check that the super type is valid
		boolean extendsTypeCanBeClass = true;
		try {
			String extendsTypeName = extendsType.getName();
			if (!originalContext.classContext.get(extendsTypeName).isClass())
				extendsTypeCanBeClass = false;
		} catch (Exception e) {
		}
		extendsType.validate(context, extendsTypeCanBeClass);

		HashMap<String, CubexTypeScheme> superFunction = new HashMap<String, CubexTypeScheme>();
		HashMap<String, CubexStatement> superFunctionStatements = new HashMap<String, CubexStatement>();
		// Find constructable component
		if (extendsType instanceof CubexTypeIntersection) {
			CubexTypeIntersection typeIntersection = (CubexTypeIntersection) extendsType;
			ClassContextElement element1 = context
					.getElementFromClassContext(typeIntersection.typeGrammar1.name);
			ClassContextElement element2 = context
					.getElementFromClassContext(typeIntersection.typeGrammar2.name);
			superElement = element1.Intersection(element2);
		}

		else if (extendsType.getName().equals("Thing")
				|| context.containsClassName(extendsType.getName())) {
			superElement = context.getElementFromClassContext(extendsType
					.getName());
			if (!extendsType.getName().equals("Thing")) {
				superFunction = superElement.functionMap;
				superFunctionStatements = superElement.functionStatementMap;
			}
		} else {
			throw new SemanticException("Supertype not found");
		}
		if (superElement.isClass) {
			constructableComponent = superElement.name;
		} else {
			constructableComponent = "Thing";
		}

		if (this.name != "String") {
			if (superElement.name == "Iterable") {
				throw new SemanticException("Cannot extend an Iterable");
			}
		}
		if (superElement.name == "Integer") {
			throw new SemanticException("Cannot extend an Integer");
		}
		if (superElement.name == "Character") {
			throw new SemanticException("Cannot extend a Character");
		}
		if (superElement.name == "String") {
			throw new SemanticException("Cannot extend a String");
		}
		FunctionContext funContextPrime = new FunctionContext();

		// Create class context prime
		ClassContext classContextPrime = new ClassContext();
		classContextPrime.put(name, new ClassContextElement(this));
		context.classContext.merge(classContextPrime);

		// Create function context prime
		CubexList<CubexTypeGrammar> kindList = new CubexList<CubexTypeGrammar>();
		for (String s : kindcontext.iterable()) {
			kindList.add(new CubexTypeName(s));
		}
		CubexTypeGrammar thisType = new CubexTypeClass(name, kindList);
		CubexTypeScheme typeScheme = new CubexTypeScheme(kindcontext,
				typecontext, thisType);
		funContextPrime.put(name, typeScheme);
		context.functionContext.merge(funContextPrime);

		// used for replaceParams
		TypeContext generics = new TypeContext();
		if (extendsType instanceof CubexTypeClass) {
			CubexTypeClass extendsInterface = (CubexTypeClass) extendsType;
			ArrayList<String> k = originalContext.classContext
					.get(extendsInterface.getName()).kindContext.contextSet;
			for (int i = 0; i < k.size(); i++) {
				generics.put(k.get(i), extendsInterface.typeList.get(i));
			}
		}

		HashMap<String, CubexFunctionDef> superFuncs = new HashMap<String, CubexFunctionDef>();
		for (Map.Entry<String, CubexTypeScheme> entry : superFunction
				.entrySet()) {
			// entry.getValue().validate(context);
			superFuncs.put(name, new CubexFunctionDef(entry.getKey(), entry
					.getValue().replaceParams(generics),
					superFunctionStatements.get(entry.getKey())));
		}
		for (CubexFunctionDef fun : functions.iterable()) {
			superFuncs.put(fun.name, fun);
			fun.typescheme.validate(context);
		}

		// Check that all function type schemes are valid
		for (CubexFunctionDef fun : superFuncs.values()) {
			// fun.typescheme.validate(context);
		}

		// Check that all type grammars in type context are valid
		for (int i = 0; i < typecontext.size(); i++) {
			typecontext.get(i).getTypeGrammar().validate(context, true);
		}

		// Set initial mutable type context to the classes type context
		context.mutableTypeContext = new TypeContext(typecontext);

		for (CubexStatement statement : statements.iterable()) {
			context.mutableTypeContext = statement.typeCheck(context);
		}

		context.typeContext.noConflictMerge(context.mutableTypeContext);
		// Check to see that super call is valid ??
		if (!superElement.name.equals("Thing")) {
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
		}

		HashSet<String> kindContextElements = new HashSet<String>();
		for (String s : this.kindcontext.iterable()) {
			kindContextElements.add(s);
		}
		// Add all functions to function context
		// For every element in the kind context of a function, check to make
		// sure its not in the classes kind context
		FunctionContext funContextDoublePrime = new FunctionContext();
		for (CubexFunctionDef fun : functions.iterable()) {
			funContextDoublePrime.put(fun.name, fun.typescheme);
			for (String s : fun.typescheme.getKindContext().iterable()) {
				if (kindContextElements.contains(s))
					throw new SemanticException(
							"CubexClassGrammar: TypeScheme overlap");
			}
		}
		for (CubexFunctionDef fun : superFuncs.values()) {
			funContextDoublePrime.put(fun.name, fun.typescheme);
			for (String s : fun.typescheme.getKindContext().iterable()) {
				if (kindContextElements.contains(s))
					throw new SemanticException(
							"CubexClassGrammar: TypeScheme overlap");
			}
		}

		// Complete function context
		context.functionContext.merge(funContextDoublePrime);

		// Check to see that all statements are valid under a lot of contexts
		KindContext originalKindContext = context.kindContext.clone();
		// Merge type contexts
		context.typeContext.merge(context.mutableTypeContext);

		// Create complete context and then typecheck function statement
		for (CubexFunctionDef fun : functions.iterable()) {
			context.kindContext = originalKindContext.clone();
			context.kindContext.addAll(new KindContext(fun.typescheme
					.getKindContext()));
			context.mutableTypeContext = new TypeContext(
					fun.typescheme.getTypeContext());
			TypeContextReturn ret = fun.statement.typeCheckReturn(context);
			// Returned type should be a subtype of the expected return
			if (ret.guaranteedToReturn == false
					|| !fun.typescheme.getTypeGrammar().isSuperTypeOf(context,
							ret.retType)) {
				throw new SemanticException(
						"CubexClassGrammar: Function does not return or returns wrong type");
			}
		}

		// 10.2.E,F
		// KindContext kindContext1 = new KindContext();
		// for (String s : kindcontext.iterable()){
		// kindContext1.add(s);
		// }
		// CubexCompleteContext completeContext = context.clone();
		// completeContext.classContext = context.classContext;
		// completeContext.kindContext = kindContext1;
		//
		// CubexCompleteContext completeContext1 = completeContext.clone();
		// completeContext1.typeContext = context.typeContext.clone();
		//
		// for (CubexStatement statement : statements.iterable()) {
		// completeContext1.mutableTypeContext =
		// statement.typeCheck(completeContext1);
		// }
		//
		// // 10.2.F
		// CubexCompleteContext completeContext2 = completeContext1.clone();
		// completeContext2.typeContext.noConflictMerge(completeContext2.mutableTypeContext);
		// completeContext2.mutableTypeContext = new TypeContext();
		//
		// CubexTypeGrammar superType;
		// if
		// (extendsType.equals(context.getTypeGrammarFromTypeContext("Thing")))
		// {
		// superType = context.getTypeGrammarFromTypeContext("Thing");
		// } else {
		// CubexTypeScheme superTypeScheme =
		// completeContext2.functionContext.get(extendsType.getName());
		// }
		//
		// // 10.2.G
		// FunctionContext functionContext2 = context.functionContext;
		// for (CubexFunctionDef fun : functions.iterable()) {
		// functionContext2.put(fun.name, fun.typescheme);
		// }
		//
		// // 10.2.H
		// context = context.clone();
		// context.classContext = context.classContext;
		// for (CubexFunctionDef function : functions.iterable()) {
		//
		// KindContext temp = new KindContext();
		// for (String s : function.typescheme.getKindContext().iterable()) {
		// temp.add(s);
		// }
		// context.kindContext.addAll(temp);
		// TypeContextReturn returns =
		// function.statement.typeCheckReturn(completeContext2);
		// if (returns.guaranteedToReturn){
		// if (!returns.retType.equals(function.typescheme.getTypeGrammar())){
		// throw new SemanticException("");
		// }
		// }
		// else {
		// throw new SemanticException("");
		// }
		// }
		originalContext.classContext.merge(classContextPrime);
		originalContext.functionContext.merge(funContextPrime);
		completeContext = originalContext.clone();
		return originalContext;
	}
	
	public void replaceVars(HashMap<String, String> map) {
		for (CubexExpression e : expressions.contextCollection) {
			e.replaceVars(map);
		}
		for (CubexStatement s : statements.contextCollection) {
			s.replaceVars(map);
		}
		for (CubexFunctionDef f : functions.contextCollection) {
			f.replaceVars(map);
		}
	}
}
