package typeChecker;

import java.io.IOException;
import java.util.BitSet;
import java.util.List;

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

import parser.CubexParser;
import parsingTokens.context.CubexClassGrammar;
import parsingTokens.context.CubexTypeTuple;
import parsingTokens.statements.CubexList;
import parsingTokens.typeGrammar.CubexTypeClass;
import parsingTokens.typeGrammar.CubexTypeGrammar;
import parsingTokens.typeGrammar.CubexTypeName;



public class TypeCheckerMain {
	static boolean lexedWithError = false;
	static boolean parsedWithError = false;
	
	public static void main(String[] args) throws IOException{
		CharStream charStream = new ANTLRFileStream(args[0]);
		CubexLexer cubLexer = new CubexLexer(charStream);	
		cubLexer.removeErrorListeners();

		ErrorListener listener = new ErrorListener();
		cubLexer.addErrorListener(listener);
		List<? extends Token> list1 = cubLexer.getAllTokens();
		if (lexedWithError) {
			System.out.print("lexer error");
			return;
		}
//		for (Token t : list1) {
//			System.out.print(t.getText() + " "); 
//		}
//		System.out.print("\n");
		cubLexer.reset();
		CubexParser cubParser = new CubexParser(new CommonTokenStream(cubLexer));
		cubParser.removeErrorListeners();
		ErrorListener plistener = new ErrorListener();
		cubParser.addErrorListener(plistener);
		
		cubParser.fullprogram();
		//ParseTree parseTree = xiParser.fullprogram();
		
		if(cubParser.getNumberOfSyntaxErrors() > 0){
			System.out.print("parser error");
			return;
		}
		System.out.print(cubParser.programAST);

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
	
	public void initialize(){
		ClassContext classContext = new ClassContext();
		KindContext kindContext = new KindContext();
		FunctionContext functionContext = new FunctionContext();
		TypeContext typeContext = new TypeContext();
		
		CubexTypeName thing = new CubexTypeName("Thing");
		CubexList<CubexTypeGrammar> thingList = new CubexList<CubexTypeGrammar>();
		thingList.add(thing);
		CubexTypeClass iterableType = new CubexTypeClass("Iterable", thingList);
		
		CubexClassGrammar iterableClass = new CubexClassGrammar("Iterable", new CubexList<String>(), 
				new CubexList<CubexTypeTuple>(), thing);
		
	}
}
