package typeChecker;

import java.io.IOException;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lexer.CubexLexer;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Nullable;

import Exception.SemanticException;
import parser.CubexParser;
import parsingTokens.CubexClassGrammar;
import parsingTokens.CubexFunctionDef;
import parsingTokens.CubexList;
import parsingTokens.context.CubexTypeScheme;
import parsingTokens.context.CubexTypeTuple;
import parsingTokens.statements.CubexListStatement;
import parsingTokens.statements.CubexStatement;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import parsingTokens.typeGrammar.CubexTypeName;

public class TypeCheckerMain {
	static boolean lexedWithError = false;
	static boolean parsedWithError = false;

	public static void main(String[] args) throws IOException {
		// CharStream charStream = new ANTLRFileStream(args[0]);
		CharStream charStream = new ANTLRFileStream(
				"cg_tests/test16.x3");
		CubexLexer cubLexer = new CubexLexer(charStream);
		cubLexer.removeErrorListeners();

		ErrorListener listener = new ErrorListener();
		cubLexer.addErrorListener(listener);
		List<? extends Token> list1 = cubLexer.getAllTokens();
		if (lexedWithError) {
			System.out.print("reject");
			return;
		}
		// for (Token t : list1) {
		// System.out.print(t.getText() + " ");
		// }
		// System.out.print("\n");
		cubLexer.reset();
		CubexParser cubParser = new CubexParser(new CommonTokenStream(cubLexer));
		cubParser.removeErrorListeners();
		ErrorListener plistener = new ErrorListener();
		cubParser.addErrorListener(plistener);

		cubParser.fullprogram();
		// ParseTree parseTree = xiParser.fullprogram();

		CubexCompleteContext c = (new TypeCheckerMain()).initialize();
		// System.out.println(c.typeContext);
		// System.out.println(c.classContext);
		// System.out.println(c.functionContext);
		// System.out.println(c.classContext);
		if (cubParser.getNumberOfSyntaxErrors() > 0) {
			System.out.print("reject");
			return;
		}
		// TODO GET RID OF THIS PRINT STATEMENT BEFORE WE SUBMIT
		System.out.println(cubParser.programAST);
		try {
			cubParser.programAST.typeCheck(c);
			System.out.print("accept");
		} catch (SemanticException e) {
			// TODO GET RID OF e.toString() BEFORE WE SUBMIT
			e.printStackTrace();
			System.out.print("reject" + e.toString());
		}
	}

	static class ErrorListener implements ANTLRErrorListener {
		@Override
		public void reportAmbiguity(@NotNull Parser arg0, @NotNull DFA arg1,
				int arg2, int arg3, boolean arg4, @NotNull BitSet arg5,
				@NotNull ATNConfigSet arg6) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void reportAttemptingFullContext(@NotNull Parser arg0,
				@NotNull DFA arg1, int arg2, int arg3, @Nullable BitSet arg4,
				@NotNull ATNConfigSet arg5) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void reportContextSensitivity(@NotNull Parser arg0,
				@NotNull DFA arg1, int arg2, int arg3, int arg4,
				@NotNull ATNConfigSet arg5) {
			// TODO Auto-generated method stub
			return;
		}

		// private class lexException extends Exception{
		// public lexException(){ super(); }
		//
		// }

		@Override
		public void syntaxError(Recognizer<?, ?> arg0, @Nullable Object arg1,
				int arg2, int arg3, String arg4,
				@Nullable RecognitionException arg5) {
			// TODO Auto-generated method stub
			lexedWithError = true;
		}
	}

	public CubexCompleteContext initialize() {
		ClassContext classContext = new ClassContext();
		FunctionContext functionContext = new FunctionContext();
		KindContext kindContext = new KindContext();
		TypeContext typeContext = new TypeContext();
		TypeContext mutableTypeContext = new TypeContext();
		Map<String, CubexTypeClass> typeMap = new HashMap<String, CubexTypeClass>();

		// Map<String, CubexTypeClass> typeClassMap = new

		defineThing(classContext, typeMap);
		defineNothing(classContext, typeMap);
		defineIterable(classContext, typeMap);
		defineBoolean(classContext, typeMap);
		defineInteger(classContext, typeMap);
		defineCharacter(classContext, typeMap);
		defineString(classContext, typeMap);
		defineFunctions(classContext, functionContext, typeMap);
		defineInput(typeContext, typeMap);

		return new CubexCompleteContext(classContext, kindContext,
				functionContext, typeContext, mutableTypeContext);
	}

	public void defineThing(ClassContext classContext,
			Map<String, CubexTypeClass> typeMap) {
		// Define Thing
		CubexTypeClass thingType = new CubexTypeClass("Thing",
				new CubexList<CubexTypeGrammar>());
		typeMap.put("Thing", thingType);

		ClassContextElement thingClassContextElement = new ClassContextElement(
				new CubexClassGrammar("Thing", new CubexList<String>(),
						new CubexList<CubexTypeTuple>(), thingType));
		classContext.put("Thing", thingClassContextElement);

	}

	public void defineNothing(ClassContext classContext,
			Map<String, CubexTypeClass> typeMap) {

		// Define Thing
		CubexTypeClass nothingType = new CubexTypeClass("Nothing",
				new CubexList<CubexTypeGrammar>());
		typeMap.put("Nothing", nothingType);
	}

	public void defineIterable(ClassContext classContext,
			Map<String, CubexTypeClass> typeMap) {

		// Define Iterable
		CubexList<CubexTypeGrammar> genericTypeList = new CubexList<CubexTypeGrammar>();
		genericTypeList.add(new CubexTypeName("E"));
		CubexTypeClass iterableType = new CubexTypeClass("Iterable",
				genericTypeList);
		typeMap.put("Iterable", iterableType);

		CubexList<String> iterableKindContext = new CubexList<String>();
		iterableKindContext.add("E");
		ClassContextElement iterableClassContextElement = new ClassContextElement(
				new CubexClassGrammar("Iterable", iterableKindContext,
						new CubexList<CubexTypeTuple>(), typeMap.get("Thing")));
		classContext.put("Iterable", iterableClassContextElement);
	}

	public void defineBoolean(ClassContext classContext,
			Map<String, CubexTypeClass> typeMap) {

		// Define Boolean
		CubexTypeClass booleanType = new CubexTypeClass("Boolean",
				new CubexList<CubexTypeGrammar>());
		typeMap.put("Boolean", booleanType);

		ClassContextElement booleanClassContextElement = new ClassContextElement(
				new CubexClassGrammar("Boolean", new CubexList<String>(),
						new CubexList<CubexTypeTuple>(), typeMap.get("Thing")));
		classContext.put("Boolean", booleanClassContextElement);

		// Define boolean iterable
		CubexTypeClass iterableBooleanType = new CubexTypeClass("Iterable",
				new CubexList<CubexTypeGrammar>());
		iterableBooleanType.getTypeList().add(booleanType);

		// Define negate
		booleanClassContextElement.functionMap.put("negate",
				new CubexTypeScheme(new CubexList<String>(),
						new CubexList<CubexTypeTuple>(), booleanType));

		// Define and
		CubexList<CubexTypeTuple> andFunctionArguments = new CubexList<CubexTypeTuple>();
		andFunctionArguments.add(new CubexTypeTuple("that", booleanType));
		booleanClassContextElement.functionMap.put("and", new CubexTypeScheme(
				new CubexList<String>(), andFunctionArguments, booleanType));

		// Define or
		CubexList<CubexTypeTuple> orFunctionArguments = new CubexList<CubexTypeTuple>();
		orFunctionArguments.add(new CubexTypeTuple("that", booleanType));
		booleanClassContextElement.functionMap.put("or", new CubexTypeScheme(
				new CubexList<String>(), orFunctionArguments, booleanType));

		// Define through
		CubexList<CubexTypeTuple> throughFunctionArguments = new CubexList<CubexTypeTuple>();
		throughFunctionArguments.add(new CubexTypeTuple("upper", booleanType));
		throughFunctionArguments.add(new CubexTypeTuple("includeLower",
				booleanType));
		throughFunctionArguments.add(new CubexTypeTuple("includeUpper",
				booleanType));
		booleanClassContextElement.functionMap.put("through",
				new CubexTypeScheme(new CubexList<String>(),
						throughFunctionArguments, iterableBooleanType));

		// Define onward
		CubexList<CubexTypeTuple> onwardFunctionArguments = new CubexList<CubexTypeTuple>();
		onwardFunctionArguments
				.add(new CubexTypeTuple("inclusive", booleanType));
		booleanClassContextElement.functionMap.put("onward",
				new CubexTypeScheme(new CubexList<String>(),
						onwardFunctionArguments, iterableBooleanType));

		// Define lessThan
		CubexList<CubexTypeTuple> lessThanFunctionArguments = new CubexList<CubexTypeTuple>();
		lessThanFunctionArguments.add(new CubexTypeTuple("that", booleanType));
		booleanClassContextElement.functionMap.put("lessThan",
				new CubexTypeScheme(new CubexList<String>(),
						lessThanFunctionArguments, booleanType));

		// Define equals
		CubexList<CubexTypeTuple> equalsFunctionArguments = new CubexList<CubexTypeTuple>();
		equalsFunctionArguments.add(new CubexTypeTuple("that", booleanType));
		booleanClassContextElement.functionMap.put("equals",
				new CubexTypeScheme(new CubexList<String>(),
						equalsFunctionArguments, booleanType));
	}

	public void defineInteger(ClassContext classContext,
			Map<String, CubexTypeClass> typeMap) {

		// Define Integer
		CubexTypeClass integerType = new CubexTypeClass("Integer",
				new CubexList<CubexTypeGrammar>());
		typeMap.put("Integer", integerType);

		ClassContextElement integerClassContextElement = new ClassContextElement(
				new CubexClassGrammar("Integer", new CubexList<String>(),
						new CubexList<CubexTypeTuple>(), typeMap.get("Thing")));
		classContext.put("Integer", integerClassContextElement);

		// Define integer iterable
		CubexTypeClass iterableIntegerType = new CubexTypeClass("Iterable",
				new CubexList<CubexTypeGrammar>());
		iterableIntegerType.getTypeList().add(integerType);

		// Define negative
		integerClassContextElement.functionMap.put("negative",
				new CubexTypeScheme(new CubexList<String>(),
						new CubexList<CubexTypeTuple>(), integerType));

		// Define times
		CubexList<CubexTypeTuple> timesFunctionArguments = new CubexList<CubexTypeTuple>();
		timesFunctionArguments.add(new CubexTypeTuple("factor", integerType));
		integerClassContextElement.functionMap.put("times",
				new CubexTypeScheme(new CubexList<String>(),
						timesFunctionArguments, integerType));

		// Define divide
		CubexList<CubexTypeTuple> divideFunctionArguments = new CubexList<CubexTypeTuple>();
		divideFunctionArguments.add(new CubexTypeTuple("divisor", integerType));
		integerClassContextElement.functionMap.put("divide",
				new CubexTypeScheme(new CubexList<String>(),
						divideFunctionArguments, iterableIntegerType));

		// Define modulo
		CubexList<CubexTypeTuple> moduloFunctionArguments = new CubexList<CubexTypeTuple>();
		moduloFunctionArguments.add(new CubexTypeTuple("modulus", integerType));
		integerClassContextElement.functionMap.put("modulo",
				new CubexTypeScheme(new CubexList<String>(),
						moduloFunctionArguments, iterableIntegerType));

		// Define plus
		CubexList<CubexTypeTuple> plusFunctionArguments = new CubexList<CubexTypeTuple>();
		plusFunctionArguments.add(new CubexTypeTuple("summand", integerType));
		integerClassContextElement.functionMap.put("plus", new CubexTypeScheme(
				new CubexList<String>(), plusFunctionArguments, integerType));

		// Define minus
		CubexList<CubexTypeTuple> minusFunctionArguments = new CubexList<CubexTypeTuple>();
		minusFunctionArguments
				.add(new CubexTypeTuple("subtrahend", integerType));
		integerClassContextElement.functionMap.put("minus",
				new CubexTypeScheme(new CubexList<String>(),
						minusFunctionArguments, integerType));

		// Define through
		CubexList<CubexTypeTuple> throughFunctionArguments = new CubexList<CubexTypeTuple>();
		throughFunctionArguments.add(new CubexTypeTuple("upper", integerType));
		throughFunctionArguments.add(new CubexTypeTuple("includeLower", typeMap
				.get("Boolean")));
		throughFunctionArguments.add(new CubexTypeTuple("includeUpper", typeMap
				.get("Boolean")));
		integerClassContextElement.functionMap.put("through",
				new CubexTypeScheme(new CubexList<String>(),
						throughFunctionArguments, iterableIntegerType));

		// Define onward
		CubexList<CubexTypeTuple> onwardFunctionArguments = new CubexList<CubexTypeTuple>();
		onwardFunctionArguments.add(new CubexTypeTuple("inclusive", typeMap
				.get("Boolean")));
		integerClassContextElement.functionMap.put("onwards",
				new CubexTypeScheme(new CubexList<String>(),
						onwardFunctionArguments, iterableIntegerType));

		// Define lessThan
		CubexList<CubexTypeTuple> lessThanFunctionArguments = new CubexList<CubexTypeTuple>();
		lessThanFunctionArguments.add(new CubexTypeTuple("that", integerType));
		integerClassContextElement.functionMap.put("lessThan",
				new CubexTypeScheme(new CubexList<String>(),
						lessThanFunctionArguments, typeMap.get("Boolean")));

		// Define equals
		CubexList<CubexTypeTuple> equalsFunctionArguments = new CubexList<CubexTypeTuple>();
		equalsFunctionArguments.add(new CubexTypeTuple("that", integerType));
		integerClassContextElement.functionMap.put("equals",
				new CubexTypeScheme(new CubexList<String>(),
						equalsFunctionArguments, typeMap.get("Boolean")));
	}

	public void defineCharacter(ClassContext classContext,
			Map<String, CubexTypeClass> typeMap) {

		// Define character
		CubexTypeClass characterType = new CubexTypeClass("Character",
				new CubexList<CubexTypeGrammar>());
		typeMap.put("Character", characterType);

		ClassContextElement characterClassContextElement = new ClassContextElement(
				new CubexClassGrammar("Character", new CubexList<String>(),
						new CubexList<CubexTypeTuple>(), typeMap.get("Thing")));
		classContext.put("Character", characterClassContextElement);

		// Define unicode
		characterClassContextElement.functionMap.put("unicode", new CubexTypeScheme(new CubexList<String>(), new CubexList<CubexTypeTuple>(), typeMap.get("Integer")));

		// Define equals
		CubexList<CubexTypeTuple> equalsFunctionArguments = new CubexList<CubexTypeTuple>();
		equalsFunctionArguments.add(new CubexTypeTuple("that", characterType));
		characterClassContextElement.functionMap.put("equals",
				new CubexTypeScheme(new CubexList<String>(),
						equalsFunctionArguments, typeMap.get("Boolean")));
	}

	public void defineString(ClassContext classContext,
			Map<String, CubexTypeClass> typeMap) {

		// Define character iterable

		CubexTypeClass characterIterable = new CubexTypeClass("Iterable",
				new CubexList<CubexTypeGrammar>());
		characterIterable.getTypeList().add(
				new CubexTypeClass("Character",
						new CubexList<CubexTypeGrammar>()));

		// Define String
		CubexTypeClass stringType = new CubexTypeClass("String",
				new CubexList<CubexTypeGrammar>());
		typeMap.put("String", stringType);

		ClassContextElement stringClassContextElement = new ClassContextElement(
				new CubexClassGrammar("String", new CubexList<String>(),
						new CubexList<CubexTypeTuple>(), characterIterable));
		classContext.put("String", stringClassContextElement);

		// Define equals
		CubexList<CubexTypeTuple> equalsFunctionArguments = new CubexList<CubexTypeTuple>();
		equalsFunctionArguments.add(new CubexTypeTuple("that", stringType));
		stringClassContextElement.functionMap.put("equals",
				new CubexTypeScheme(new CubexList<String>(),
						equalsFunctionArguments, typeMap.get("Boolean")));
	}

	public void defineFunctions(ClassContext classContext,
			FunctionContext functionContext, Map<String, CubexTypeClass> typeMap) {

		// Define character
		CubexList<CubexTypeTuple> characterFunctionArguments = new CubexList<CubexTypeTuple>();
		characterFunctionArguments.add(new CubexTypeTuple("unicode", typeMap
				.get("Integer")));
		functionContext.put("character",
				new CubexTypeScheme(new CubexList<String>(),
						characterFunctionArguments, typeMap.get("Character")));

		// Define string
		CubexTypeClass characterIterable = new CubexTypeClass("Iterable",
				new CubexList<CubexTypeGrammar>());
		characterIterable.getTypeList().add(typeMap.get("Character"));

		CubexList<CubexTypeTuple> stringFunctionArguments = new CubexList<CubexTypeTuple>();
		stringFunctionArguments.add(new CubexTypeTuple("characters",
				characterIterable));
		functionContext.put("string",
				new CubexTypeScheme(new CubexList<String>(),
						stringFunctionArguments, typeMap.get("String")));
	}

	public void defineInput(TypeContext typeContext,
			Map<String, CubexTypeClass> typeMap) {
		CubexTypeClass stringIterable = new CubexTypeClass("Iterable",
				new CubexList<CubexTypeGrammar>());
		stringIterable.getTypeList().add(typeMap.get("String"));
		typeContext.put("input", stringIterable);
	}

}
