package parsingTokens;

import ir.program.IrFunction;
import ir.program.IrProgram;
import ir.program.IrProgramContext;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import Exception.SemanticException;
import parsingTokens.context.CubexTypeScheme;
import parsingTokens.statements.CubexStatement;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import parsingTokens.typeGrammar.CubexTypeName;
import typeChecker.ClassContext;
import typeChecker.ClassContextElement;
import typeChecker.CubexCompleteContext;
import typeChecker.FunctionContext;
import typeChecker.KindContext;
import typeChecker.TypeContext;
import typeChecker.TypeContextReturn;

public class CubexInterface {
	public String name;
	public CubexList<String> kindContext;
	public CubexTypeGrammar extendsType;
	public CubexList<CubexFunctionDef> functionList;

	public CubexInterface(String n, CubexList<String> k, CubexTypeGrammar t,
			CubexList<CubexFunctionDef> l) {
		name = n;
		kindContext = k;
		extendsType = t;
		functionList = l;
	}
	
	public IrProgram toIr(IrProgramContext context, IrProgram program) {
		addStruct(context, program);
		addConstructor(context, program);
		addFunctions(context, program);
		return program;
	}
	
	private void addStruct(IrProgramContext context, IrProgram program) {
		//TODO 
	}
	
	private void addConstructor(IrProgramContext context, IrProgram program) {
		//TODO
	}
	
	private void addFunctions(IrProgramContext context, IrProgram program) {
		//TODO
	}

	public String toString() {
		String rightSpace1 = kindContext.size() == 0 ? "" : " ";
		String rightSpace2 = functionList.size() == 0 ? "" : " ; ";
		StringBuilder build = new StringBuilder();
		build.append("interface ");
		build.append(name);
		build.append(" < ");
		build.append(kindContext.toString(","));
		build.append(rightSpace1);
		build.append("> extends ");
		build.append(extendsType);
		build.append(" { ");
		build.append(functionList.toString(";"));
		build.append(rightSpace2);
		build.append("}");
		return build.toString();
	}

	// TODO: Need a way to get functions from supertype
	// TODO: Need a way to get the constructable component
	public ClassContext typeCheck(CubexCompleteContext originalContext)
			throws SemanticException {
		CubexCompleteContext context = originalContext.clone();
		context.kindContext = new KindContext(kindContext);
		ClassContextElement superElement;

		if (context.classContext.containsKey(name))
			throw new SemanticException("Class name collision");

		HashMap<String, CubexTypeScheme> superFunction = new HashMap<String, CubexTypeScheme>();
		HashMap<String, CubexStatement> superFunctionStatements = new HashMap<String, CubexStatement>();
		// Find constructable component
		if (extendsType.getName().equals("Thing")
				|| context.containsClassName(extendsType.getName())) {
			superElement = context.getElementFromClassContext(extendsType
					.getName());
			if (!extendsType.getName().equals("Thing"))
				if (superElement.isClass())
					throw new SemanticException(
							"Interfaces can only extend another Interface");
			if (!extendsType.getName().equals("Thing")) {
				superFunction = superElement.functionMap;
				superFunctionStatements = superElement.functionStatementMap;

			}
		} else {
			throw new SemanticException("Supertype not found");
		}

		// Create class context prime
		ClassContext classContextPrime = new ClassContext();
		classContextPrime.put(name, new ClassContextElement(this));
		context.classContext.merge(classContextPrime);

		// Create function context prime
		CubexList<CubexTypeGrammar> kindList = new CubexList<CubexTypeGrammar>();
		for (String s : kindContext.iterable()) {
			kindList.add(new CubexTypeName(s));
		}

		HashMap<String, CubexFunctionDef> superFuncs = new HashMap<String, CubexFunctionDef>();
		for (String name : superFunction.keySet()) {
			CubexTypeScheme scheme = superFunction.get(name);
			scheme.validate(context);
			superFuncs.put(name, new CubexFunctionDef(name, scheme,
					superFunctionStatements.get(name)));
		}
		for (CubexFunctionDef fun : functionList.iterable()) {
			superFuncs.put(fun.name, fun);
		}

		// Check that all function type schemes are valid
		for (CubexFunctionDef fun : superFuncs.values()) {
			fun.typescheme.validate(context);
		}

		context.typeContext.noConflictMerge(context.mutableTypeContext);
		// TODO: Check to see that super call is valid ??
		if (!superElement.name.equals("Thing")) {
			Map<String, CubexTypeScheme> superTypeFunctions = superElement.functionMap;
			for (CubexFunctionDef function : functionList.iterable()) {
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
		if (superElement.name == "Iterable") {
			throw new SemanticException("Cannot extend an Iterable");
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
		HashSet<String> kindContextElements = new HashSet<String>();
		for (String s : this.kindContext.iterable()) {
			kindContextElements.add(s);
		}
		// Add all functions to function context
		// For every element in the kind context of a function, check to make
		// sure its not in the classes kind context
		FunctionContext funContextDoublePrime = new FunctionContext();
		for (CubexFunctionDef fun : functionList.iterable()) {
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
		for (CubexFunctionDef fun : functionList.iterable()) {
			if (fun.statement != null) {
				context.kindContext = originalKindContext.clone();
				context.kindContext.addAll(new KindContext(fun.typescheme
						.getKindContext()));
				context.mutableTypeContext = new TypeContext(
						fun.typescheme.getTypeContext());
				TypeContextReturn ret = fun.statement.typeCheckReturn(context);
				// Returned type should be a subtype of the expected return
				if (ret.guaranteedToReturn == false
						|| !fun.typescheme.getTypeGrammar().isSuperTypeOf(
								context, ret.retType)) {
					throw new SemanticException(
							"CubexClassGrammar: Function does not return or returns wrong type");
				}
			}
		}

		originalContext.classContext.merge(classContextPrime);
		return originalContext.classContext;
	}

}
